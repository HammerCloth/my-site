package com.syx.syxsite.service;

import com.syx.syxsite.dto.StatisticsDto;

/**
 * 负责站点相关的服务
 * @author:syx
 * @date:2021/10/4 17:18
 * @version:v1.0
 */
public interface SiteService {

    /**
     * 统计本站点的数据并返回
     * @return StatisticsDto 统计数据传输对象
     */
    StatisticsDto getStatistics();
}
