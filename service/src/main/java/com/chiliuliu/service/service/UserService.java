package com.chiliuliu.service.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chiliuliu.service.entity.req.User;

/**
 * 用户表(User)表服务接口
 *
 * @author liuyu
 * @since 2020-11-27 14:30:39
 */
public interface UserService extends IService<User> {
    IPage list(IPage page, Wrapper<User> userWrapper);

    Boolean insert(User user);
}