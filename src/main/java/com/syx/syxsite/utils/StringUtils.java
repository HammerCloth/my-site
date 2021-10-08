package com.syx.syxsite.utils;

/**
 * @author:syx
 * @date:2021/10/8 19:44
 * @version:v1.0
 */
public class StringUtils {
    public static boolean isBlank(String str){
        if (str.equals("")||str==null) {
            return true;
        }
        return false;
    }
}
