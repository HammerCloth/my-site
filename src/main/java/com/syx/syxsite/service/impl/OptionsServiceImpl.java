package com.syx.syxsite.service.impl;

import com.syx.syxsite.dao.OptionsDao;
import com.syx.syxsite.model.Options;
import com.syx.syxsite.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:syx
 * @date:2021/10/14 22:00
 * @version:v1.0
 */
@Service
public class OptionsServiceImpl implements OptionsService {

    @Autowired
    private OptionsDao optionsDao;

    @Override
    public void deleteOptionByName(String name) {

    }

    @Override
    public void updateOptionByName(String name, String value) {

    }

    @Override
    public Options getOptionByName(String name) {
        return null;
    }

    @Override
    public List<Options> getOptions() {
        return optionsDao.getOptions();
    }
}
