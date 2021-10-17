package com.syx.syxsite.service;

import com.github.pagehelper.PageInfo;
import com.syx.syxsite.dto.cond.CommentCond;
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

    /**
     * 根据条件获取评论列表
     * @param commentCond 查询条件
     * @param pageNum 分页参数 第几页
     * @param pageSize 分页参数 每页条数
     * @return
     */
    PageInfo<Comment> getCommentsByCond(CommentCond commentCond, int pageNum, int pageSize);
}
