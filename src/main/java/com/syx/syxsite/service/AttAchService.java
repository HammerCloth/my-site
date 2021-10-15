package com.syx.syxsite.service;

import com.github.pagehelper.PageInfo;
import com.syx.syxsite.model.AttAch;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/15 11:15
 * @version:v1.0
 */
public interface AttAchService {
    /**
     * 添加单个附件信息
     * @param attAchDomain
     * @return
     */
    void addAttAch(AttAch attAchDomain);

    /**
     * 批量添加附件信息
     * @param list
     * @return
     */
    void batchAddAttAch(List<AttAch> list);

    /**
     * 根据主键编号删除附件信息
     * @param id
     * @return
     */
    void deleteAttAch(Integer id);

    /**
     * 更新附件信息
     * @param attAchDomain
     * @return
     */
    void updateAttAch(AttAch attAchDomain);

    /**
     * 根据主键获取附件信息
     * @param id
     * @return
     */
    AttAch getAttAchById(Integer id);

    /**
     * 获取所有的附件信息
     * @return
     */
    PageInfo<AttAch> getAtts(int pageNum, int pageSize);
}
