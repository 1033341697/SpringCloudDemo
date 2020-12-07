package com.chiliuliu.message.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.chiliuliu.message.service.TestService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: liuyu
 * @Date: 2020/12/7 9:35
 **/
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_ONE = "amq.direct";
    private static final String EXCHANGE_TWO = "amq.fanout";
    private static final String ROUTING_KEY_ONE = "student_message";
    private static final String ROUTING_KEY_TWO = "test_direct";
    private static final String ROUTING_KEY_THREE = "user_message";

    @Override
    public R sendMessage(String message) {
        Object o = rabbitTemplate.convertSendAndReceive(EXCHANGE_ONE, ROUTING_KEY_TWO, message);
        R<Object> ok = R.ok(o);
        return ok;
    }
}
