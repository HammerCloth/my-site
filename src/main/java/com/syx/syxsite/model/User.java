package com.syx.syxsite.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:syx
 * @date:2021/10/2 19:40
 * @version:v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //用户id
    private Integer uid;
    //用户名
    private String username;
    private String password;
    private String email;
    private String homeUrl;
    private String screenName;
    private Integer created;
    private Integer activated;
    private Integer logged;
    private String groupName;
}
