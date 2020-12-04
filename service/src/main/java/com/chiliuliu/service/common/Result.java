package com.chiliuliu.service.common;

import com.baomidou.mybatisplus.extension.api.R;
import com.chiliuliu.common.entity.ResultCodeEnum;

import java.io.Serializable;

/**
 * @Author: liuyu
 * @Date: 2020/12/4 16:39
 **/
public class Result implements Serializable {
    private static final R r = new R();

    public static R error(ResultCodeEnum resultCodeEnum) {
        r.setCode(resultCodeEnum.getCode());
        r.setMsg(resultCodeEnum.getMsg());
        return r;
    }

    public static R error(Long code, String msg) {
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
