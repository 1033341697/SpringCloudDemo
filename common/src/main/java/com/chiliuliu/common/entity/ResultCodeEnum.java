package com.chiliuliu.common.entity;

/**
 * @Author: liuyu
 * @Date: 2020/11/24 14:04
 **/
public enum ResultCodeEnum {
    ERROR(500, "失败"),
    SUCCESS(200, "成功");

    private Integer code;

    private String msg;

    public Integer getCode() {
        return 0;
    }

    public String getMsg() {
        return null;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
