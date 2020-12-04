package com.chiliuliu.feign.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chiliuliu.common.entity.req.Student;
import com.chiliuliu.feign.service.hystrix.TestServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: liuyu
 * @Date: 2020/12/4 10:14
 **/
@FeignClient(name = "service", fallback = TestServiceHystrix.class)
public interface TestService {

    @GetMapping("student/testFeign")
    String testFeign();

    @GetMapping("student")
    R selectAll(@SpringQueryMap Page<Student> page, @SpringQueryMap Student student);
}
