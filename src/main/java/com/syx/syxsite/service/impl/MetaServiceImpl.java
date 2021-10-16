package com.syx.syxsite.service.impl;

import com.syx.syxsite.dao.MetaDao;
import com.syx.syxsite.dto.cond.MetaCond;
import com.syx.syxsite.model.Meta;
import com.syx.syxsite.service.MetaService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public void saveMeta(String type, String name, Integer mid) {
        if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(name)){
            MetaCond cond = new MetaCond();
            cond.setType(type);
            cond.setName(name);
            List<Meta> metas = getMetas(cond);
            if (metas==null||metas.isEmpty()){ // 确保不重复
                Meta meta = new Meta();
                meta.setName(name);
                meta.setType(type);
                Meta metaById = metaDao.getMetaById(mid);
                if (metaById!=null){
                    updateMeta(meta); // 存在则更新
                }else{
                    addMeta(meta); // 不存在则添加
                }
            }else{
                throw new RuntimeException("repeat");
            }
        }else{
            throw new RuntimeException("blank");
        }
    }

    @Override
    public void addMetas(Integer cid, String names, String type) {
        if (StringUtils.isNotBlank(names) && StringUtils.isNotBlank(type)) {
            String[] nameArr = StringUtils.split(names, ",");
            for (String name : nameArr) {
                this.saveOrUpdate(cid, name, type);
            }
        }
    }

    @Override
    public void saveOrUpdate(Integer cid, String name, String type) {
        MetaCond metaCond = new MetaCond();
        metaCond.setName(name);
        metaCond.setType(type);
        List<Meta> metas = this.getMetas(metaCond);
        if (metas==null||metas.isEmpty()){ // 确保不重复
            Meta meta = new Meta();
            meta.setName(name);
            meta.setType(type);
            addMeta(meta); // 不存在则添加
            Integer mid = meta.getMid();
            //todo 加入相应的关联
        }
    }

}
