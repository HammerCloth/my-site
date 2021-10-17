package com.syx.syxsite.service;

import com.github.pagehelper.PageInfo;
import com.syx.syxsite.dto.cond.ContentCond;
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
     *
     * @param content
     */
    void addArticle(Content content);

    /**
     * 通过条件来获取文章并分页
     *
     * @param contentCond
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Content> getArticlesByCond(ContentCond contentCond, int pageNum, int pageSize);

    /**
     * 根据编号删除文章
     *
     * @param cid
     * @return
     */
    void deleteArticleById(Integer cid);

    /**
     * 更新文章
     *
     * @param content
     * @return
     */
    void updateArticleById(Content content);

    /**
     * 根据编号获取文章
     *
     * @param cid
     * @return
     */
    Content getArticleById(Integer cid);
}
