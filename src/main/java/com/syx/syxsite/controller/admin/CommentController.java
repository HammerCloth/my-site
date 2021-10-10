package com.syx.syxsite.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 评论页面控制器
 *
 * @author:syx
 * @date:2021/10/10 19:23
 * @version:v1.0
 */
@Api(description = "评论页面控制器")
@Controller
public class CommentController {

    @ApiOperation(value = "跳转到评论页面", notes = "跳转到评论页面")
    @GetMapping("/admin/comments")
    public String toCommentsList() {
        // todo 传递数据
        return "admin/comment_list";
    }
}
