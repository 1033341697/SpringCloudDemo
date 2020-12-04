package com.chiliuliu.feign.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chiliuliu.common.entity.req.Student;
import com.chiliuliu.feign.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: liuyu
 * @Date: 2020/12/2 14:46
 **/
@RestController
@RequestMapping("feign")
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("getStudentService")
    public R getStudentService(Page<Student> page, Student student) {
        return testService.selectAll(page, student);
    }
}
