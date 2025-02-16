package com.syx.syxsite.service;

import com.syx.syxsite.dto.cond.MetaCond;
import com.syx.syxsite.model.Meta;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/14 19:42
 * @version:v1.0
 */
public interface MetaService {

    /**
     * 根据条件来查询项目列表
     * @param metaCond
     * @return
     */
    List<Meta> getMetas(MetaCond metaCond);

    /**
     * 修改项目
     * @param meta
     */
    void updateMeta(Meta meta);

    /**
     * 根据id删除项目
     * @param mid
     */
    void delMetaById(Integer mid);

    /**
     * 保存项目
     * @param meta
     */
    void addMeta(Meta meta);

    /**
     * 保存项目的同时，进行查重
     */
    void saveMeta(String type,String name,Integer mid);

    /**
     * 批量添加
     * @param cid
     * @param names
     * @param type
     */
    void addMetas(Integer cid, String names, String type);

    /**
     * 添加或者更新
     * @param cid
     * @param name
     * @param type
     */
    public void saveOrUpdate(Integer cid, String name, String type);
}
