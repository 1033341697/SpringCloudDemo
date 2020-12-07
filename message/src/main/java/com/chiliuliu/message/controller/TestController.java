package com.chiliuliu.message.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.chiliuliu.message.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: liuyu
 * @Date: 2020/12/7 10:05
 **/
@RestController
@RequestMapping("message/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private TestService testService;

    @GetMapping("testMessage")
    public R testMessage(@RequestParam("message") String message) {
        logger.info("消息发送服务接口");
        return testService.sendMessage(message);
    }
}
