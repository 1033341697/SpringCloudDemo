package com.chiliuliu.service.listener;

import com.chiliuliu.service.entity.req.Student;
import com.chiliuliu.service.service.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * RabbitMq监听器，监听Rabbitmq服务
 *
 * @Author: liuyu
 * @Date: 2020/11/27 11:52
 **/
@Component
@RabbitListener(queues = "q_test_01")
public class RabbitMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMessageListener.class);

    @Resource
    private WebSocketServer webSocketServer;

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
        try {
            webSocketServer.sendMessage(message);
            logger.info("消费消息String:{}", message);
        } catch (IOException e) {
            // 向客户端推送消息异常，序列化消息，稍后进行推送
            e.printStackTrace();
        }
    }

    @RabbitHandler
    public void handleMessage(Message message) {
        MessageProperties messageProperties = message.getMessageProperties();
        byte[] body = message.getBody();
        try {
            webSocketServer.sendMessage(body.toString());
            logger.info("消费消息{}", body);
        } catch (IOException e) {
            // 向客户端推送消息异常，序列化消息，稍后进行推送
            e.printStackTrace();
        }
    }

    @RabbitHandler
    public void handleMessage(Student student) {
        try {
            webSocketServer.sendMessage(student.toString());
            logger.info("消费消息{}", student);
        } catch (IOException e) {
            // 向客户端推送消息异常，序列化消息，稍后进行推送
            e.printStackTrace();
        }
    }

    @RabbitHandler
    public void handleMessage(List list) {
        try {
            webSocketServer.sendMessage(list.toString());
            logger.info("消费消息{}", list);
        } catch (IOException e) {
            // 向客户端推送消息异常，序列化消息，稍后进行推送
            e.printStackTrace();
        }
    }

    @RabbitHandler
    public void handleMessage(Map map) {
        try {
            webSocketServer.sendMessage(map.toString());
            logger.info("消费消息{}", map);
        } catch (IOException e) {
            // 向客户端推送消息异常，序列化消息，稍后进行推送
            e.printStackTrace();
        }
    }

}
