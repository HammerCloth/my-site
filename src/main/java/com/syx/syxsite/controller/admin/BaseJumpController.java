package com.syx.syxsite.controller.admin;

import com.syx.syxsite.utils.EasyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:syx
 * @date:2021/10/3 21:02
 * @version:v1.0
 */
@Controller
public class BaseJumpController {
    @Autowired
    private EasyResponse easyResponse;

    @RequestMapping("/admin")
    public String toLogin(){
        return "admin/login";
    }


    @PostMapping("/admin/login")
    @ResponseBody
    public EasyResponse login(String username, String password){
        if (username.equals("admin")&&password.equals("123456")){
            return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
        }
        return easyResponse.setMsg("用户或者密码错误").setCode(EasyResponse.CODE_FAIL);
    }

}
