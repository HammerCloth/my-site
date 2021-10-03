package com.syx.syxsite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评论
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDomain {

    //comment表主键
    private Integer coid;
    //评论对应的contents的id；
    private Integer cid;
    //评论生成时的GMT unix时间戳
    private Integer created;
    //评论者的名字
    private String author;
    //评论者的用户id
    private Integer authorId;
    //被评论的content的作者的id；
    private Integer ownerId;
    //评论者的邮件
    private String mail;
    //评论者的网址
    private String url;
    //评论者的ip地址
    private String ip;
    //评论者的客户端
    private String agent;
    //评论类型
    private String type;
    //评论状态
    private String status;
    //父级评论
    private Integer parent;
    //评论内容
    private String content;
}
