package com.syx.syxsite.service;

import com.syx.syxsite.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息服务类
 * @author:syx
 * @date:2021/10/8 19:56
 * @version:v1.0
 */
public interface UserService {

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 根据用户id来获取用户信息
     * @param uId
     * @return
     */
    User getUserInfoById(@Param("uid") Integer uId);

    /**
     * 根据用户名和密码来获取用户信息
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username") String username, @Param("password") String password);
}
