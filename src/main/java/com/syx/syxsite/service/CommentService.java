package com.syx.syxsite.service;

import com.syx.syxsite.model.Comment;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/9 16:49
 * @version:v1.0
 */
public interface CommentService {
    /**
     * 获取评论列表
     * @param limit 获取评论的个数
     * @return
     */
    List<Comment> getComments(int limit);
}
