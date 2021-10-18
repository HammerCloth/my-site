package com.syx.syxsite.controller;

import com.github.pagehelper.PageInfo;
import com.syx.syxsite.constant.Types;
import com.syx.syxsite.dto.cond.ContentCond;
import com.syx.syxsite.model.Content;
import com.syx.syxsite.service.ContentService;
import com.syx.syxsite.utils.Commons;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author:syx
 * @date:2021/10/1 16:55
 * @version:v1.0
 */
@Api(description = "用于维持前台网页基本的跳转")
@Controller
public class BaseController {
    @Autowired
    private Commons commons;
    @Autowired
    private ContentService contentService;

    @ApiOperation(value="主页面跳转",notes = "主页面跳转的连接")
    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "limit",defaultValue = "12") Integer limit){
        model.addAttribute("commons",commons);
        ContentCond contentCond = new ContentCond();
        contentCond.setType(Types.PHOTO.getType());
        PageInfo<Content> articlesByCond = contentService.getArticlesByCond(contentCond, 1, limit);
        model.addAttribute("archives",articlesByCond);
        return "index";
    }

    @ApiOperation(value="主页作品详情页面跳转",notes = "主页作品详情页面跳转的连接")
    @GetMapping("/photo/article/{cid}")
    public String article(@PathVariable Integer cid,Model model){
        Content article = contentService.getArticleById(cid);
        // todo 更新文章的点击量
        model.addAttribute("commons",commons);
        model.addAttribute("archive",article);
        return "works-details";
    }

    @ApiOperation(value="about页面跳转",notes = "about跳转的连接")
    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @ApiOperation(value="blog页面跳转",notes = "blog跳转的连接")
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @ApiOperation(value="contact页面跳转",notes = "contact跳转的连接")
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @ApiOperation(value="博客文章详情页面跳转",notes = "博客文章详情页面跳转的连接")
    @GetMapping("/blog/details")
    public String blogDetails(){
        return "blog-details";
    }
}
