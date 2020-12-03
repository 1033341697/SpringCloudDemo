package com.chiliuliu.feign.controller;

import com.chiliuliu.common.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuyu
 * @Date: 2020/12/2 14:46
 **/
@RestController
@RequestMapping("feign")
public class TestController {

    @GetMapping("user")
    public User getUser() {
        User user = new User();
        user.setCode("777888");
        return user;
    }
}
