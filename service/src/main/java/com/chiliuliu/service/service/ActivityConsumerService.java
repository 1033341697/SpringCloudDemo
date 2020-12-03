package com.chiliuliu.service.service;

import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @Author: liuyu
 * @Date: 2020/11/30 9:05
 **/
public interface ActivityConsumerService {
    String startByProcessName(String name);

    List<Task> getTask(String uid);
}
