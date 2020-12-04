package com.chiliuliu.feign.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chiliuliu.common.entity.ResultCodeEnum;
import com.chiliuliu.common.entity.req.Student;
import com.chiliuliu.feign.service.TestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: liuyu
 * @Date: 2020/12/2 14:46
 **/
@RestController
@RequestMapping("feign")
public class TestController extends ApiController {
    @Resource
    private TestService testService;

    @GetMapping("testFeign")
    public R test() {
        String s = testService.testFeign();
        return success(s);
    }

    @GetMapping
    public R selectAll(Page<Student> page, Student student) {
        System.out.println("ssssssss");
        return this.testService.selectAll(page,student);
    }

}
