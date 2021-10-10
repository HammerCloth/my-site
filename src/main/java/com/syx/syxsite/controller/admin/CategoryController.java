package com.syx.syxsite.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 标签管理页面控制器
 *
 * @author:syx
 * @date:2021/10/10 19:33
 * @version:v1.0
 */
@Api(description = "标签管理页面控制器")
@Controller
public class CategoryController {

    @ApiOperation(value = "跳转到标签列表页面", notes = "跳转到标签列表页面")
    @GetMapping("/admin/category")
    public String toCategory() {
        // todo 传递数据
        return "admin/category";
    }
}
