package com.syx.syxsite.utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "将返回的参数封装成类")
@Component //使用spring托管
@Data
@NoArgsConstructor
@Accessors(chain = true) //允许链式编程
public class EasyResponse<T> {
    //返回success信号
    public static final String CODE_SUCCESS = "success";
    //返回失败信号
    public static final String CODE_FAIL = "fail";

    @ApiModelProperty(name = "code",value = "表示返回信号")
    private String code;
    @ApiModelProperty(name = "data",value = "可以携带任意类型的数据")
    private T data;
    @ApiModelProperty(name = "msg",value = "表示返回的信息")
    private String msg;

}
