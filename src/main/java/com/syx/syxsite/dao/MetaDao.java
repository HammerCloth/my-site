package com.syx.syxsite.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 项目数据访问类
 * @author:syx
 * @date:2021/10/4 17:34
 * @version:v1.0
 */
@Mapper
@Component
public interface MetaDao {

    /**
     * 按照类型获取项目数量
     * @param type
     * @return 项目数量
     */
    Integer getMetasCountByType(@Param("type") String type);
}
