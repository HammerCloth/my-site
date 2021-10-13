package com.syx.syxsite.controller.admin;

import com.syx.syxsite.dao.UserDao;
import com.syx.syxsite.model.User;
import com.syx.syxsite.utils.Commons;
import com.syx.syxsite.utils.EasyResponse;
import com.syx.syxsite.utils.TaleUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 个人信息页面控制器
 *
 * @author:syx
 * @date:2021/10/10 19:06
 * @version:v1.0
 */
@Api(description = "个人信息页面控制器")
@Controller
public class ProfileController {

    @Autowired
    private Commons commons;
    @Autowired
    private UserDao userDao;
    @Autowired
    private EasyResponse easyResponse;

    @ApiOperation(value = "跳转到个人信息页面", notes = "跳转到个人信息页面")
    @GetMapping("/admin/profile")
    public String toProfile(Model model) {
        model.addAttribute("commons", commons);
        return "admin/profile";
    }

    @ApiOperation(value = "修改个人信息", notes = "修改个人信息")
    @PostMapping("/admin/profile")
    @ResponseBody //这里不需要跳转页面，所以必须加上该注解用于传递消息,否则会不断返回login页面
    public EasyResponse saveProfile(String screenName, String email, HttpSession session,Model model) {
        model.addAttribute("commons", commons);
        if (StringUtils.isNotBlank(screenName) && StringUtils.isNotBlank(email)) {
            User login_user = (User) session.getAttribute("login_user");
            Integer uid = login_user.getUid();
            User user = userDao.getUserInfoById(uid);
            user.setEmail(email);
            user.setScreenName(screenName);
            userDao.updateUserInfo(user);
            // 更新session中的信息
            session.setAttribute("login_user", user);
            return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
        }
        return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("screenName或者email为空");
    }

    @ApiOperation(value = "修改后台密码", notes = "修改后台密码")
    @PostMapping("/admin/password")
    @ResponseBody
    public EasyResponse savePassword(String oldPassword,String password,HttpSession session){
        User loginUser = (User) session.getAttribute("login_user");
        if (StringUtils.isBlank(oldPassword)||StringUtils.isBlank(password)){
            return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("信息输入不完整！");
        }
        if (!loginUser.getPassword().equals(TaleUtils.MD5encode(loginUser.getUsername()+oldPassword))){
            return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("旧密码输入不正确");
        }
        if (password.length()<6||password.length()>14){
            return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("请输入6-14位密码");
        }
        try {
            loginUser.setPassword(TaleUtils.MD5encode(loginUser.getUsername()+password));
            userDao.updateUserInfo(loginUser);
            User user = userDao.getUserInfoById(loginUser.getUid());
            // 更新session中的信息
            session.setAttribute("login_user",user);
            return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
        } catch (Exception e) {
            return easyResponse.setCode(EasyResponse.CODE_FAIL).setMsg("密码修改失败");
        }
    }
}
