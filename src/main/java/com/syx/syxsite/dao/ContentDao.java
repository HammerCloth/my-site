package com.syx.syxsite.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Content表的数据访问
 * @author:syx
 * @date:2021/10/4 17:26
 * @version:v1.0
 */
@Mapper
@Component
public interface ContentDao {

    /**
     * 获取文章总数
     * @return 文章数
     */
    Integer getArticleCount();
}
