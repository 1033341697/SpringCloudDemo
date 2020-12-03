package com.chiliuliu.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiliuliu.service.common.MyException;
import com.chiliuliu.service.common.ResultCodeEnum;
import com.chiliuliu.service.mapper.UserDao;
import com.chiliuliu.service.entity.req.User;
import com.chiliuliu.service.service.UserService;
import com.chiliuliu.service.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表(User)表服务实现类
 *
 * @author liuyu
 * @since 2020-11-27 14:30:39
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Resource
    private RedisUtils redisUtils;

    @Override
    public IPage list(IPage page, Wrapper<User> userWrapper) {
        page = this.baseMapper.selectPage(page, userWrapper);
        boolean users = redisUtils.lSet("users", page.getRecords(), 100);
        if (!users) {
            throw new MyException(ResultCodeEnum.REDIS_INSERT_ERROR);
        }
        return page;
    }

    @Override
    public Boolean insert(User user) {
        int insert = this.baseMapper.insert(user);
        return null;
    }
}