package com.chiliuliu.service.service.impl;

import com.chiliuliu.service.service.ActivityConsumerService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作流测试Service
 *
 * @Author: liuyu
 * @Date: 2020/11/30 9:04
 **/
@Service("ActivityConsumerServiceImpl")
public class ActivityConsumerServiceImpl implements ActivityConsumerService {
    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    @Override
    public String startByProcessName(String name) {
        //开始已经部署的流程实例-->流程key
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(name);
        return processInstance.getId();
    }

    @Override
    public List<Task> getTask(String uid) {
        // 获取即时任务
        List<Task> list = taskService.createTaskQuery().taskAssignee(uid).list();
        return list;
    }
}
