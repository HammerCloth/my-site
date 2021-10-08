package com.syx.syxsite.service.impl;

import com.syx.syxsite.dao.UserDao;
import com.syx.syxsite.model.User;
import com.syx.syxsite.service.UserService;
import com.syx.syxsite.utils.StringUtils;
import com.syx.syxsite.utils.TaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:syx
 * @date:2021/10/8 19:58
 * @version:v1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int updateUserInfo(User user) {
        // todo user为空的异常处理
        return userDao.updateUserInfo(user);
    }

    @Override
    public User getUserInfoById(Integer uId) {
        return userDao.getUserInfoById(uId);
    }

    @Override
    public User login(String username, String password) {
        if (StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            // todo 对应的异常处理
        }
        String pwd = TaleUtils.MD5encode(username+password);
        User user = userDao.getUserInfoByCond(username, pwd);
        if (user==null){
            // todo 对应的异常处理
        }
        return user;
    }


}
