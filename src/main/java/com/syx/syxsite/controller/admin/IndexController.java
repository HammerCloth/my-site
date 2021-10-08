package com.syx.syxsite.controller.admin;

import com.syx.syxsite.dto.StatisticsDto;
import com.syx.syxsite.service.SiteService;
import com.syx.syxsite.utils.Commons;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author:syx
 * @date:2021/10/3 21:02
 * @version:v1.0
 */
@Api(description = "后台基本跳转控制")
@Controller
public class IndexController {
    @Autowired
    private SiteService siteService;
    @Autowired
    private Commons commons;


    @ApiOperation(value = "跳转到后台主页面", notes = "跳转到后台主页面")
    @GetMapping("/admin/index")
    public String index(Model model) {
        StatisticsDto statistics = siteService.getStatistics();
        model.addAttribute("statistics", statistics);
        model.addAttribute("commons", commons);
        //todo 需要传入相应的数据
        return "admin/index";
    }

}
