package com.syx.syxsite.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 个人信息页面控制器
 * @author:syx
 * @date:2021/10/10 19:06
 * @version:v1.0
 */
@Api(description = "个人信息页面控制器")
@Controller
public class ProfileController {

    @ApiOperation(value = "跳转到个人信息页面", notes = "跳转到个人信息页面")
    @GetMapping("/admin/profile")
    public String toProfile(){
        //todo 需要传递信息
        return "admin/profile";
    }
}
