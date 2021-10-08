package com.syx.syxsite.utils;


import org.springframework.stereotype.Component;

/**
 * 用于页面的公共函数
 * @author:syx
 * @date:2021/10/8 19:33
 * @version:v1.0
 */
@Component
public class Commons {

    /**
     * 返回github头像地址
     *
     * @param email
     * @return
     */
    public static String gravatar(String email) {
        String avatarUrl = "https://github.com/identicons/";
        if (StringUtils.isBlank(email)) {
            email = "user@hanshuai.xin";
        }
        String hash = TaleUtils.MD5encode(email.trim().toLowerCase());
        return avatarUrl + hash + ".png";
    }
}
