package com.syx.syxsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.syx.syxsite.dao.CommentDao;
import com.syx.syxsite.dto.cond.CommentCond;
import com.syx.syxsite.model.Comment;
import com.syx.syxsite.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/9 16:50
 * @version:v1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getComments(int limit) {
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        PageHelper.startPage(1, limit);
        List<Comment> comments = commentDao.getCommentsByCond(new CommentCond());
        return comments;
    }
}
