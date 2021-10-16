package com.syx.syxsite.service;

import com.syx.syxsite.model.Content;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/8 20:47
 * @version:v1.0
 */
public interface ContentService {
    /**
     * 获取最新的文章
     *
     * @param limit
     * @return
     */
    List<Content> getNewArticles(int limit);

    /**
     * 保存文章
     * @param content
     */
    void addArticle(Content content);
}
