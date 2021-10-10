package com.syx.syxsite.controller.admin;

import com.syx.syxsite.dto.StatisticsDto;
import com.syx.syxsite.model.Comment;
import com.syx.syxsite.model.Content;
import com.syx.syxsite.service.CommentService;
import com.syx.syxsite.service.ContentService;
import com.syx.syxsite.service.SiteService;
import com.syx.syxsite.utils.Commons;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:syx
 * @date:2021/10/3 21:02
 * @version:v1.0
 */
@Api(description = "后台基本界面跳转控制")
@Controller
public class IndexController {
    @Autowired
    private SiteService siteService;
    @Autowired
    private Commons commons;
    @Autowired
    private ContentService contentService;
    @Autowired
    private CommentService commentService;


    @ApiOperation(value = "跳转到后台主页面", notes = "跳转到后台主页面")
    @GetMapping("/admin/index")
    public String index(Model model) {
        StatisticsDto statistics = siteService.getStatistics();
        List<Content> articles = contentService.getNewArticles(5);
        List<Comment> comments = commentService.getComments(5);
        model.addAttribute("statistics", statistics);
        model.addAttribute("commons", commons);
        model.addAttribute("articles",articles);
        model.addAttribute("comments",comments);
        //todo 需要传入相应的数据
        return "admin/index";
    }

}
