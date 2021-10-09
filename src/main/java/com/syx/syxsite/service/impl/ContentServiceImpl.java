package com.syx.syxsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.syx.syxsite.dao.ContentDao;
import com.syx.syxsite.dto.cond.ContentCond;
import com.syx.syxsite.model.Content;
import com.syx.syxsite.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/8 20:48
 * @version:v1.0
 */
@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    private ContentDao contentDao;

    @Override
    public List<Content> getNewArticles(int limit) {
        if (limit<0||limit>10){
            limit = 10;
        }
        PageHelper.startPage(1,limit);
        List<Content> articles = contentDao.getArticlesByCond(new ContentCond());
        return articles;
    }
}
