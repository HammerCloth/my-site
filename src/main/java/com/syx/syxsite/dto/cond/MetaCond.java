package com.syx.syxsite.dto.cond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * meta查询条件
 *
 * @author:syx
 * @date:2021/10/13 21:01
 * @version:v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaCond {

    /**
     * meta Name
     */
    private String name;
    /**
     * 类型
     */
    private String type;
}
