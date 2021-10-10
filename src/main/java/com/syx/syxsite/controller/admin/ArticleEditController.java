package com.syx.syxsite.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 文章发布页面控制器
 * @author:syx
 * @date:2021/10/10 19:12
 * @version:v1.0
 */
@Api(description = "文章发布页面控制器")
@Controller
public class ArticleEditController {

    @ApiOperation(value = "跳转到文章发布页面", notes = "跳转到文章发布页面")
    @GetMapping("/admin/article/publish")
    public String toArticleEdit(){
        // todo 传递所需要的信息
        return "admin/article_edit";
    }
}
