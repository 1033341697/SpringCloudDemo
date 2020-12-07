package com.chiliuliu.feign.service.hystrix;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chiliuliu.common.entity.ResultCodeEnum;
import com.chiliuliu.common.entity.po.Student;
import com.chiliuliu.feign.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @Author: liuyu
 * @Date: 2020/12/4 10:15
 **/
@Component
public class TestServiceHystrix implements TestService {
    @Override
    public String testFeign() {
        return "服务繁忙，请稍后重试";
    }

    @Override
    public R selectAll(Page<Student> page, Student student) {
        System.out.println("TestServiceHystrix--------------------------");
        return R.failed(ResultCodeEnum.SERVICE_BUSY);
    }
}
