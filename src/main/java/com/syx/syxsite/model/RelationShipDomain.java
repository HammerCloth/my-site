package com.syx.syxsite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章关联信息表
 * Created by winterchen on 2018/4/30.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationShipDomain {

    /**
     * 文章主键编号
     */
    private Integer cid;
    /**
     * 项目编号
     */
    private Integer mid;

}
