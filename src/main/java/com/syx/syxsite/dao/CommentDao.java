package com.syx.syxsite.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

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
}
