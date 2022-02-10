package com.chiliuliu.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = " 返回基础类")
public class BaseRespVo<T> {

    @ApiModelProperty(value = "结果")
    private boolean result;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public static <T> BaseRespVo<T> success() {
        BaseRespVo<T> r = new BaseRespVo<T>();
        r.setResult(true);
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMsg());
        return r;
    }

    public static <T> BaseRespVo<T> success(T data) {
        BaseRespVo<T> r = new BaseRespVo<T>();
        r.setResult(true);
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMsg());
        r.setData(data);
        return r;
    }

    public static <T> BaseRespVo<T> success(String msg, T data) {
        BaseRespVo<T> r = new BaseRespVo<T>();
        r.setResult(true);
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

    public static <T> BaseRespVo<T> error(String msg) {
        return error(ResultCodeEnum.ERROR.getCode(), msg);
    }

    public static <T> BaseRespVo<T> error(Integer code, String msg) {
        BaseRespVo<T> r = new BaseRespVo<T>();
        r.setCode(code);
        r.setMessage(msg);
        r.setResult(false);
        return r;
    }
}
