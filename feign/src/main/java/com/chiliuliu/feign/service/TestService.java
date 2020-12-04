package com.chiliuliu.feign.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chiliuliu.common.entity.req.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: liuyu
 * @Date: 2020/12/4 10:14
 **/
@FeignClient("service")
public interface TestService {
    @GetMapping(value = "student")
    R selectAll(Page<Student> page, Student student);
}
