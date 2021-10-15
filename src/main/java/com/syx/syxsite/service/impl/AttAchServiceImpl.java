package com.syx.syxsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syx.syxsite.dao.AttAchDao;
import com.syx.syxsite.model.AttAch;
import com.syx.syxsite.service.AttAchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/15 11:17
 * @version:v1.0
 */
@Service
public class AttAchServiceImpl implements AttAchService {
    @Autowired
    private AttAchDao attAchDao;
    @Override
    public void addAttAch(AttAch attAchDomain) {

    }

    @Override
    public void batchAddAttAch(List<AttAch> list) {

    }

    @Override
    public void deleteAttAch(Integer id) {

    }

    @Override
    public void updateAttAch(AttAch attAchDomain) {

    }

    @Override
    public AttAch getAttAchById(Integer id) {
        return null;
    }

    @Override
    public PageInfo<AttAch> getAtts(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttAch> atts = attAchDao.getAtts();
        return new PageInfo<>(atts);
    }
}
