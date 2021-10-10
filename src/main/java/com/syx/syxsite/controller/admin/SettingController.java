package com.syx.syxsite.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 设置控制类
 *
 * @author:syx
 * @date:2021/10/10 19:45
 * @version:v1.0
 */
@Api(description = "设置控制类")
@Controller
public class SettingController {

    @ApiOperation(value = "跳转到设置页面", notes = "跳转到设置页面")
    @GetMapping("/admin/setting")
    public String toSetting() {
        // todo 传递信息
        return "admin/setting";
    }
}
