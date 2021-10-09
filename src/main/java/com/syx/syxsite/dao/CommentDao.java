package com.syx.syxsite.dao;

import com.syx.syxsite.dto.cond.CommentCond;
import com.syx.syxsite.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Comment表的数据访问
 * @author:syx
 * @date:2021/10/4 17:27
 * @version:v1.0
 */
@Mapper
@Component
public interface CommentDao {

    /**
     * 获取评论总数
     * @return 获取评论总数
     */
    Integer getCommentsCount();

    /**
     * 根据条件获取评论列表
     * @param commentCond
     * @return
     */
    List<Comment> getCommentsByCond(CommentCond commentCond);
}
