package com.syx.syxsite.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 连接页面控制器
 *
 * @author:syx
 * @date:2021/10/10 19:41
 * @version:v1.0
 */
@Api(description = "连接页面控制器")
@Controller
public class LinksController {

    @ApiOperation(value = "跳转到连接主页面", notes = "跳转到连接主页面")
    @GetMapping("/admin/links")
    public String toLinks() {
        //todo 需要传递信息
        return "admin/links";
    }
}
