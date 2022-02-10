package com.chiliuliu.service.service;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 消息服务调用
 *
 * @Author: liuyu
 * @Date: 2020/12/7 10:15
 **/
@FeignClient(name = "message")
public interface MessageService {
    @GetMapping("message/test/testMessage")
    R testMessage(@RequestParam("message") String message);
}
