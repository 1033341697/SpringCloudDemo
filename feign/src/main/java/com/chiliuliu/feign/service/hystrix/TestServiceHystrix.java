package com.chiliuliu.feign.service.hystrix;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chiliuliu.common.entity.ResultCodeEnum;
import com.chiliuliu.common.entity.req.Student;
import com.chiliuliu.feign.service.TestService;

/**
 * @Author: liuyu
 * @Date: 2020/12/4 10:15
 **/
public class TestServiceHystrix implements TestService {
    @Override
    public R selectAll(Page<Student> page, Student student) {
        return R.failed(ResultCodeEnum.SERVICE_BUSY);
    }
}
