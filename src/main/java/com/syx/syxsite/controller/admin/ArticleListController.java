package com.syx.syxsite.controller.admin;

import com.github.pagehelper.PageInfo;
import com.syx.syxsite.dto.cond.ContentCond;
import com.syx.syxsite.model.Content;
import com.syx.syxsite.service.ContentService;
import com.syx.syxsite.utils.Commons;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private Commons commons;
    @Autowired
    private ContentService contentService;
    @ApiOperation(value = "跳转到文章列表页面", notes = "跳转到文章列表页面")
    @GetMapping("/admin/article")
    public String toArticleList(@RequestParam(name = "page", required = false, defaultValue = "1")
                                        int page,
                                @RequestParam(name = "limit", required = false, defaultValue = "15")
                                        int limit,
                                Model model
    ) {
        PageInfo<Content> articles = contentService.getArticlesByCond(new ContentCond(), page, limit);
        model.addAttribute("commons",commons);
        model.addAttribute("articles",articles);
        return "admin/article_list";
    }
}
