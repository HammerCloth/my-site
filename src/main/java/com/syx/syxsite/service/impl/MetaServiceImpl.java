package com.syx.syxsite.service.impl;

import com.syx.syxsite.dao.MetaDao;
import com.syx.syxsite.dto.cond.MetaCond;
import com.syx.syxsite.model.Meta;
import com.syx.syxsite.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/14 19:43
 * @version:v1.0
 */

@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaDao metaDao;

    @Override
    public List<Meta> getMetas(MetaCond metaCond) {
       return  metaDao.getMetasByCond(metaCond);
    }

    @Override
    public void updateMeta(Meta meta) {
        metaDao.updateMeta(meta);
    }

    @Override
    public void delMetaById(Integer mid) {
        metaDao.deleteMetaById(mid);
        // todo 还需要把相关的资源删除
    }

    @Override
    public void addMeta(Meta meta) {
        metaDao.addMeta(meta);
    }
}
