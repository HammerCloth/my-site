package com.syx.syxsite.dao;

import com.syx.syxsite.model.AttAch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Attach表的数据访问
 * @author:syx
 * @date:2021/10/4 17:32
 * @version:v1.0
 */
@Mapper
@Component
public interface AttAchDao {

    /**
     * 获取附件的总数
     * @return 附件总数
     */
    Integer getAttachesCount();

    /**
     * 添加单个附件信息
     * @param attAch
     * @return
     */
    int addAttAch(AttAch attAch);

    /**
     * 批量添加附件信息
     * @param list
     * @return
     */
    int batchAddAttAch(List<AttAch> list);

    /**
     * 根据主键编号删除附件信息
     * @param id
     * @return
     */
    int deleteAttAch(int id);

    /**
     * 更新附件信息
     * @param attAch
     * @return
     */
    int updateAttAch(AttAch attAch);

    /**
     * 根据主键获取附件信息
     * @param id
     * @return
     */
    AttAch getAttAchById(@Param("id") int id);

    /**
     * 获取所有的附件信息
     * @return
     */
    List<AttAch> getAtts();
}
