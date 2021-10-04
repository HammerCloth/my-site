package com.syx.syxsite.dto;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 表示后台首页的数据传输对象
 * @author:syx
 * @date:2021/10/4 16:54
 * @version:v1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true) //个人比较喜欢链式函数，感觉比较直观
public class StatisticsDto {
    //文章数
    private Integer articles;
    //评论数
    private Integer comments;
    //连接数
    private Integer links;
    //附件数
    private Integer attaches;
}
