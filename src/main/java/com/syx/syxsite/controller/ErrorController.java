package com.syx.syxsite.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:syx
 * @date:2021/10/2 20:26
 * @version:v1.0
 */
@Api(description = "用以替换springboot默认404，500响应")
@Controller
public class ErrorController {

    @ApiOperation(value = "404页面",notes = "404页面")
    @RequestMapping("/404")
    public String notFound(){
        return "error/404";
    }

    @ApiOperation(value = "500页面",notes = "500页面")
    @RequestMapping("/500")
    public String InternalServerError(){
        return "error/500";
    }
}
