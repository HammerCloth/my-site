package com.syx.syxsite.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 文章列表页面控制器
 *
 * @author:syx
 * @date:2021/10/10 19:18
 * @version:v1.0
 */
@Api(description = "文章列表页面控制器")
@Controller
public class ArticleListController {

    @ApiOperation(value = "跳转到文章列表页面", notes = "跳转到文章列表页面")
    @GetMapping("/admin/article")
    public String toArticleList() {
        // todo 传递相关的数据
        return "admin/article_list";
    }
}
