package com.syx.syxsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:syx
 * @date:2021/10/2 20:26
 * @version:v1.0
 */
@Controller
public class ErrorController {

    @RequestMapping("/404")
    public String notFound(){
        return "error/404";
    }

    @RequestMapping("/500")
    public String InternalServerError(){
        return "error/500";
    }
}
