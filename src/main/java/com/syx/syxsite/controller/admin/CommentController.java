package com.syx.syxsite.controller.admin;

import com.github.pagehelper.PageInfo;
import com.syx.syxsite.dto.cond.CommentCond;
import com.syx.syxsite.model.Comment;
import com.syx.syxsite.service.CommentService;
import com.syx.syxsite.utils.Commons;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    @Autowired
    private Commons commons;
    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "跳转到评论页面", notes = "跳转到评论页面")
    @GetMapping("/admin/comments")
    public String toCommentsList(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int page,
            @RequestParam(name = "limit", required = false, defaultValue = "15")
                    int limit,
            Model model
    ) {
        PageInfo<Comment> commentsByCond = commentService.getCommentsByCond(new CommentCond(), page, limit);
        model.addAttribute("commons", commons);
        model.addAttribute("comments", commentsByCond);
        return "admin/comment_list";
    }

    // todo 评论的其他动作
}
