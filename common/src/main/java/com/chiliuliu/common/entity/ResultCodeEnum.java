package com.chiliuliu.common.entity;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

/**
 * @Author: liuyu
 * @Date: 2020/11/24 14:04
 **/
public enum ResultCodeEnum implements IErrorCode {
    ERROR(5000L, "失败"),
    ERROR_INSERT(5001L, "新增失败"),
    REDIS_INSERT_ERROR(5002L, "插入缓存失败"),
    MESSAGE_SEND_ERROR(5005L, "消息发送失败"),
    ARGUMENT_NOT_VALID(422L, "参数验证失败");


    private Long code;

    private String msg;

    @Override
    public long getCode() {
        return 0;
    }

    @Override
    public String getMsg() {
        return null;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    ResultCodeEnum(Long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 全局异常处理
     *
     * @param code
     * @param msg
     * @author: liuyu
     * @return: com.chiliuliu.common.entity.ResultCodeEnum
     * @date: 2020/12/3 14:06
     */
    public static ResultCodeEnum getResultCodeEnum(Long code, String msg) {
        ResultCodeEnum error = ResultCodeEnum.ERROR;
        error.setCode(code);
        error.setMsg(msg);
        return error;
    }
}
