package com.syx.syxsite.controller.admin;

import com.github.pagehelper.PageInfo;
import com.syx.syxsite.model.AttAch;
import com.syx.syxsite.service.AttAchService;
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
 * 附件管理页面控制类
 *
 * @author:syx
 * @date:2021/10/10 19:37
 * @version:v1.0
 */
@Api(description = "附件管理页面控制类")
@Controller
public class AttachController {
    @Autowired
    private Commons commons;
    @Autowired
    private AttAchService attAchService;

    @ApiOperation(value = "跳转到附件列表页面", notes = "跳转到附件列表页面")
    @GetMapping("/admin/attach")
    public String toAttach(@RequestParam(name = "page", required = false, defaultValue = "1")
                                       int page,
                           @RequestParam(name = "limit", required = false, defaultValue = "12")
                                       int limit,
                           Model model) {
        PageInfo<AttAch> atts = attAchService.getAtts(page, limit);
        model.addAttribute("commons", commons);
        model.addAttribute("attachs",atts);
        return "admin/attach";
    }

}
