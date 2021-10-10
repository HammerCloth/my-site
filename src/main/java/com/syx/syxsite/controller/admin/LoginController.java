package com.syx.syxsite.controller.admin;

import com.syx.syxsite.model.User;
import com.syx.syxsite.service.UserService;
import com.syx.syxsite.utils.Commons;
import com.syx.syxsite.utils.EasyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * login页面的控制器
 *
 * @author:syx
 * @date:2021/10/8 20:40
 * @version:v2.0
 */
@Api(description = "login页面的控制器")
@Controller
public class LoginController {
    @Autowired
    private EasyResponse easyResponse;
    @Autowired
    private UserService userService;
    @Autowired
    private Commons commons;

    @ApiOperation(value = "提供登录页面入口", notes = "登录页面跳转入口")
    @RequestMapping("/admin")
    public String toLogin() {
        return "admin/login";
    }


    @ApiOperation(value = "校验用户名和密码", notes = "校验用户名和密码，并返回响应")
    @PostMapping("/admin/login")
    @ResponseBody //这里不需要跳转页面，所以必须加上该注解用于传递消息,否则会不断返回login页面
    public EasyResponse login(String username, String password, HttpSession session) {
        User login = userService.login(username, password);
        if (login != null) {
            session.setAttribute("login_user", login);//将登录信息注入到session
            return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
        }
        return easyResponse.setMsg("用户或者密码错误").setCode(EasyResponse.CODE_FAIL);
    }


    @ApiOperation(value = "注销登录", notes = "注销登录信息，并返回登录页面")
    @GetMapping("/admin/logout")
    public String loginOut(HttpSession session) {
        session.removeAttribute("login_user");
        return "redirect:/admin";
    }
}
