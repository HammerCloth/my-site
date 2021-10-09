package com.syx.syxsite.dto.cond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章查询条件
 * @author:syx
 * @date:2021/10/9 16:07
 * @version:v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentCond {
    //标签
    private String tag;
    //类别
    private String category;
    //状态
    private String status;
    //标题
    private String title;
    //内容
    private String content;
    //文章类型
    private String type;
    //开始时间戳
    private Integer startTime;
    //结束时间戳
    private Integer endTime;
}
