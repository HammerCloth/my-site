package com.syx.syxsite.dao;

import com.syx.syxsite.dto.cond.MetaCond;
import com.syx.syxsite.model.Meta;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 项目数据访问类
 *
 * @author:syx
 * @date:2021/10/4 17:34
 * @version:v1.0
 */
@Mapper
@Component
public interface MetaDao {

    /**
     * 按照类型获取项目数量
     *
     * @param type
     * @return 项目数量
     */
    Integer getMetasCountByType(@Param("type") String type);

    /**
     * 添加项目
     *
     * @param meta
     * @return
     */
    int addMeta(Meta meta);

    /**
     * 删除项目
     *
     * @param mid
     * @return
     */
    int deleteMetaById(@Param("mid") Integer mid);

    /**
     * 更新项目
     *
     * @param meta
     * @return
     */
    int updateMeta(Meta meta);

    /**
     * 根据编号获取项目
     *
     * @param mid
     * @return
     */
    Meta getMetaById(@Param("mid") Integer mid);


    /**
     * 根据条件查询
     *
     * @param metaCond
     * @return
     */
    List<Meta> getMetasByCond(MetaCond metaCond);


    /**
     * 根据sql查询
     *
     * @param paraMap
     * @return
     */
    List<Meta> selectFromSql(Map<String, Object> paraMap);
}
