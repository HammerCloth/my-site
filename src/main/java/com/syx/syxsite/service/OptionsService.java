package com.syx.syxsite.service;

import com.syx.syxsite.model.Options;

import java.util.List;
import java.util.Map;

/**
 * @author:syx
 * @date:2021/10/14 21:58
 * @version:v1.0
 */
public interface OptionsService {

    /**
     * 删除网站配置
     * @param name
     * @return
     */
    void deleteOptionByName(String name);

    /**
     * 更新网站配置
     * @param name
     * @param value
     * @return
     */
    void updateOptionByName(String name, String value);

    /***
     * 根据名称获取网站配置
     * @param name
     * @return
     */
    Options getOptionByName(String name);

    /**
     * 获取全部网站配置
     * @return
     */
    List<Options> getOptions();

    /**
     * 保存网站配置
     * @param options
     */
    void saveOptions(Map<String, String> options);
}
