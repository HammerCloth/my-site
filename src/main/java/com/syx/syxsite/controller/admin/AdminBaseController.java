package com.syx.syxsite.controller.admin;

import com.syx.syxsite.utils.EasyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "后台基本跳转控制")
@Controller
public class AdminBaseController {
    @Autowired
    private EasyResponse easyResponse;

    @ApiOperation(value = "提供登录页面入口" ,notes="登录页面跳转入口")
    @RequestMapping("/admin")
    public String toLogin(){
        return "admin/login";
    }


    @ApiOperation(value = "校验用户名和密码" ,notes="校验用户名和密码，并返回响应")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
            })
    @PostMapping("/admin/login")
    public EasyResponse login(String username, String password){
        if (username.equals("admin")&&password.equals("123456")){
            return easyResponse.setCode(EasyResponse.CODE_SUCCESS);
        }
        return easyResponse.setMsg("用户或者密码错误").setCode(EasyResponse.CODE_FAIL);
    }

}
