package com.syx.syxsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syx.syxsite.constant.Types;
import com.syx.syxsite.dao.ContentDao;
import com.syx.syxsite.dao.MetaDao;
import com.syx.syxsite.dto.cond.ContentCond;
import com.syx.syxsite.model.Content;
import com.syx.syxsite.model.Meta;
import com.syx.syxsite.service.ContentService;
import com.syx.syxsite.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/8 20:48
 * @version:v1.0
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentDao contentDao;
    @Autowired
    private MetaService metaService;

    @Override
    public List<Content> getNewArticles(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        PageHelper.startPage(1, limit);
        List<Content> articles = contentDao.getArticlesByCond(new ContentCond());
        return articles;
    }

    @Override
    public void addArticle(Content content) {
        // 在保存文章的同时还需要将tags和categories存储在表中
        String tags = content.getTags();
        String categories = content.getCategories();
        contentDao.addArticle(content);
        Integer cid = content.getCid();// 在插入数据库后，自动在插入对象中封装自增主键的值
        metaService.saveOrUpdate(cid, categories, Types.CATEGORY.getType());
        metaService.saveOrUpdate(cid, tags, Types.TAG.getType());
    }

    @Override
    public PageInfo<Content> getArticlesByCond(ContentCond contentCond, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Content> articles = contentDao.getArticlesByCond(contentCond);
        return new PageInfo(articles);
    }

    @Override
    public void deleteArticleById(Integer cid) {
        contentDao.deleteArticleById(cid);
        // todo 还需要删除对应的评论，和标签和分类的关联
    }

    @Override
    public void updateArticleById(Content content) {
        contentDao.updateArticleById(content);
    }

    @Override
    public Content getArticleById(Integer cid) {
        return contentDao.getArticleById(cid);
    }
}
