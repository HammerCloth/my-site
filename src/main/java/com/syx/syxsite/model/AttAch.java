package com.syx.syxsite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网站图片相关的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttAch {

    //主键编号
    private Integer id;
    //文件名
    private String fname;
    //文件类型
    private String ftype;
    //文件存储的地址
    private String fkey;
    //文件创建人的id
    private Integer authorId;
    // 创建的时间戳
    private Integer created;

}
