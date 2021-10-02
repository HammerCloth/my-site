package com.syx.syxsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author:syx
 * @date:2021/10/1 16:55
 * @version:v1.0
 */
@Controller
public class BaseController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/works/details")
    public String worksDetails(){
        return "works-details";
    }

    @GetMapping("/blog/details")
    public String blogDetails(){
        return "blog-details";
    }
}
