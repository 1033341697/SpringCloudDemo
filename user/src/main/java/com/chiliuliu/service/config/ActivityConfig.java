package com.chiliuliu.service.config;

import org.activiti.engine.impl.cfg.IdGenerator;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;

import java.util.UUID;

/**
 * @Author: liuyu
 * @Date: 2020/11/28 11:53
 **/
public class ActivityConfig implements ProcessEngineConfigurationConfigurer {
    @Override
    public void configure(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        springProcessEngineConfiguration.setIdGenerator(new MyIdGenerator());
    }

    public class MyIdGenerator implements IdGenerator {
        @Override
        public String getNextId() {
            return UUID.randomUUID().toString().replaceAll("-", "");
        }
    }
}
