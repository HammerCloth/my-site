package com.syx.syxsite.dao;

import com.syx.syxsite.dto.cond.CommentCond;
import com.syx.syxsite.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 新增评论
     * @param comment
     * @return
     */
    int addComment(Comment comment);

    /**
     * 删除评论
     * @param coid
     * @return
     */
    int deleteComment(@Param("coid") Integer coid);

    /**
     * 更新评论的状态
     * @param coid
     * @return
     */
    int updateCommentStatus(@Param("coid") Integer coid, @Param("status") String status);

    /**
     * 获取单条评论
     * @param coid
     * @return
     */
    Comment getCommentById(@Param("coid") Integer coid);


    /**
     * 根据文章编号获取评论列表
     * @param cid
     * @return
     */
    List<Comment> getCommentsByCId(@Param("cid") Integer cid);


}
