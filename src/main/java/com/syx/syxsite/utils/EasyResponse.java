package com.syx.syxsite.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

/**
 * 将返回的参数封装成类
 * @author:syx
 * @date:2021/10/3 21:41
 * @version:v1.0
 */
@Component //使用spring托管
@Data
@NoArgsConstructor
@Accessors(chain = true) //允许链式编程
public class EasyResponse<T> {
    //返回success信号
    public static final String CODE_SUCCESS = "success";
    //返回失败信号
    public static final String CODE_FAIL = "fail";

    private String code;
    private T data;
    private String msg;

}
