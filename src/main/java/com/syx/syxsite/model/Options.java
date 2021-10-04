package com.syx.syxsite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网站配置项
 * Created by winterchen on 2018/4/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Options {

    /**
     * 名称
     */
    private String name;
    /**
     * 内容
     */
    private String value;
    /**
     * 备注
     */
    private String description;
}
