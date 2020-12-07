package com.chiliuliu.message.listener;

import com.chiliuliu.common.entity.po.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * RabbitMq监听器，监听Rabbitmq服务
 *
 * @Author: liuyu
 * @Date: 2020/11/27 11:52
 **/
@Component
@RabbitListener(queues = "student_message")
public class RabbitMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMessageListener.class);


    /**
     * 监听消息类型为String的消息
     *
     * @param message
     * @author: liuyu
     * @return: void
     * @date: 2020/12/3 17:36
     */
    @RabbitHandler
    public void handleMessage(String message) {
        logger.info("消费消息String:{}", message);
    }

    @RabbitHandler
    public void handleMessage(Message message) {
        byte[] body = message.getBody();
        logger.info("消费消息{}", body);
    }

    @RabbitHandler
    public void handleMessage(Student student) {
        logger.info("消费消息{}", student);
    }

    @RabbitHandler
    public void handleMessage(List list) {
        logger.info("消费消息{}", list);
    }

    @RabbitHandler
    public void handleMessage(Map map) {
        logger.info("消费消息{}", map);
    }

}
