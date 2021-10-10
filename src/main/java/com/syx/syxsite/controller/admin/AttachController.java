package com.syx.syxsite.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @ApiOperation(value = "跳转到附件列表页面", notes = "跳转到附件列表页面")
    @GetMapping("/admin/attach")
    public String toAttach() {
        // todo 传递相关的数据
        return "admin/attach";
    }

}
