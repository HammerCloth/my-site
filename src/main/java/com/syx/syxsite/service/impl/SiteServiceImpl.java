package com.syx.syxsite.service.impl;

import com.syx.syxsite.constant.Types;
import com.syx.syxsite.dao.AttAchDao;
import com.syx.syxsite.dao.CommentDao;
import com.syx.syxsite.dao.ContentDao;
import com.syx.syxsite.dao.MetaDao;
import com.syx.syxsite.dto.StatisticsDto;
import com.syx.syxsite.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 负责站点相关的服务实现类
 * @author:syx
 * @date:2021/10/4 17:21
 * @version:v1.0
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private AttAchDao attAchDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ContentDao contentDao;
    @Autowired
    private MetaDao metaDao;

    /**
     * 统计本站点的数据并返回
     * @return StatisticsDto 统计数据传输对象
     */
    @Override
    public StatisticsDto getStatistics() {
        //获取文章数
        Integer articleCount = contentDao.getArticleCount();
        //获取评论数
        Integer commentsCount = commentDao.getCommentsCount();
        //获取连接数
        Integer linksCount = metaDao.getMetasCountByType(Types.LINK.getType());
        //获取附件数
        Integer attachesCount = attAchDao.getAttachesCount();
        //链式设置参数并返回
        StatisticsDto statistics = new StatisticsDto();
        return statistics.
                setArticles(articleCount).
                setComments(commentsCount).
                setLinks(linksCount).
                setAttaches(attachesCount);
    }
}
