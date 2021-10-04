package com.syx.syxsite.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author:syx
 * @date:2021/10/1 16:55
 * @version:v1.0
 */
@Api(description = "用于维持前台网页基本的跳转")
@Controller
public class BaseController {

    @ApiOperation(value="主页面跳转",notes = "主页面跳转的连接")
    @GetMapping("/")
    public String index(){
        return "index";
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

    @ApiOperation(value="主页文章详情页面跳转",notes = "主页文章详情页面跳转的连接")
    @GetMapping("/works/details")
    public String worksDetails(){
        return "works-details";
    }

    @ApiOperation(value="博客文章详情页面跳转",notes = "博客文章详情页面跳转的连接")
    @GetMapping("/blog/details")
    public String blogDetails(){
        return "blog-details";
    }
}
