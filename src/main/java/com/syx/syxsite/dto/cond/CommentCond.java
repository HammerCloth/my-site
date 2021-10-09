package com.syx.syxsite.dto.cond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评论筛选条件
 * @author:syx
 * @date:2021/10/9 16:45
 * @version:v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCond {
    //评论状态 approved(审核通过) not_audit(未审核)
    private String status;
    //评论开始时间戳
    private Integer startTime;
    //评论结束时间戳
    private Integer endTime;
    //父评论编号
    private Integer parent;
}
