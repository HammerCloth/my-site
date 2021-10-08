package com.syx.syxsite.dao;

import com.syx.syxsite.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author:syx
 * @date:2021/10/8 19:52
 * @version:v1.0
 */
@Mapper
@Component
public interface UserDao {
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
    User getUserInfoByCond(@Param("username") String username, @Param("password") String password);
}
