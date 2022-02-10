package com.chiliuliu.common.exception;


import com.chiliuliu.common.entity.ResultCodeEnum;

/**
 * 系统自定义异常，继承RuntimeException，进行全局统一处理（Exception捕获不到）
 *
 * @Author: liuyu
 * @Date: 2020/11/24 15:39
 **/
public class ResultException extends RuntimeException {
    private Integer code;
    private String message;

    public ResultException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
