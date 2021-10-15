package com.syx.syxsite.utils;


import com.github.pagehelper.PageInfo;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

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
    /**
     * 格式化unix时间戳为日期
     *
     * @param unixTime
     * @return
     */
    public static String fmtdate(Integer unixTime) {
        return fmtdate(unixTime, "yyyy-MM-dd");
    }

    /**
     * 格式化unix时间戳为日期
     *
     * @param unixTime
     * @param patten
     * @return
     */
    public static String fmtdate(Integer unixTime, String patten) {
        if (null != unixTime && StringUtils.isNotBlank(patten)) {
            return DateKit.formatDateByUnixTime(unixTime, patten);
        }
        return "";
    }

    /**
     * 英文格式的日期
     * @param unixTime
     * @return
     */
    public static String fmtdate_en(Integer unixTime){
        String fmtdate = fmtdate(unixTime, "d,MMM,yyyy");
        String[] dateArr = fmtdate.split(",");
        String rs = "<span>" + dateArr[0] + "</span> " + dateArr[1] + "  " + dateArr[2];
        return rs;
    }


    /**
     * 英文格式的日期-月，日
     * @param unixTime
     * @return
     */
    public static String fmtdate_en_m(Integer unixTime){
        return fmtdate(unixTime,"MMM d");
    }

    /**
     * 日期-年
     * @param unixTime
     * @return
     */
    public static String fmtdate_en_y(Integer unixTime){
        return fmtdate(unixTime,"yyyy");
    }

    /**
     * 将中文的yyyy年MM月 - > yyyy
     * @param date
     * @return
     */
    public static String parsedate_zh_y_m(String date){
        if (StringUtils.isNotBlank(date)){
            Date d = DateKit.dateFormat(date, "yyyy年MM月");
            return DateKit.dateFormat(d, "yyyy");
        }
        return null;
    }

    /**
     * 字符串转Date
     * @param date
     * @return
     */
    public static Date fmtdate_date(String date){
        if (StringUtils.isNotBlank(date)){
            return DateKit.dateFormat(date, "yyyy年MM月");
        }
        return null;
    }

    /**
     * 根据nuix时间戳获取Date
     * @param nuixTime
     * @return
     */
    public static Date fmtdate_unxtime(Integer nuixTime){
        if (null != nuixTime){
            return DateKit.getDateByUnixTime(nuixTime);
        }
        return  null;
    }

    /**
     * 显示文章内容，转换markdown为html
     *
     * @param value
     * @return
     */
    public static String article(String value) {
        if (StringUtils.isNotBlank(value)) {
            value = value.replace("<!--more-->", "\r\n");
            value = value.replace("<!-- more -->", "\r\n");
            return TaleUtils.mdToHtml(value);
        }
        return "";
    }

    /**
     * An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!
     * <p>
     * 这种格式的字符转换为emoji表情
     *
     * @param value
     * @return
     */
    public static String emoji(String value) {
        return EmojiParser.parseToUnicode(value);
    }

    /**
     * 判断分页中是否有数据
     *
     * @param paginator
     * @return
     */
    public static boolean is_empty(PageInfo paginator) {
        return paginator == null || (paginator.getList() == null) || (paginator.getList().size() == 0);
    }

    /**
     * 截取字符串
     *
     * @param str
     * @param len
     * @return
     */
    public static String substr(String str, int len) {
        if (str.length() > len) {
            return str.substring(0, len);
        }
        return str;
    }
}
