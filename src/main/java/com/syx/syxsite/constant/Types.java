package com.syx.syxsite.constant;

import lombok.Data;

/**
 * @author:syx
 * @date:2021/10/4 20:19
 * @version:v1.0
 */

public enum Types {

    TAG("tag"),//标签
    CATEGORY("category"),//分类
    ARTICLE("post"),
    PUBLISH("publish"),
    PAGE("page"),
    DRAFT("draft"),//草稿
    LINK("link"),//连接
    IMAGE("image"),//图片
    FILE("file"),//文件
    CSRF_TOKEN("csrf_token"),//令牌
    COMMENTS_FREQUENCY("comments:frequency"),//评论频率
    PHOTO("photo"),//照片
    /**
     * 附件存放的URL，默认为网站地址，如集成第三方则为第三方CDN域名
     */
    ATTACH_URL("attach_url"),
    /**
     * 网站要过滤，禁止访问的ip列表
     */
    BLOCK_IPS("site_block_ips");


    // 定义类
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //构造函数
    Types(String type) {
        this.type = type;
    }
}
