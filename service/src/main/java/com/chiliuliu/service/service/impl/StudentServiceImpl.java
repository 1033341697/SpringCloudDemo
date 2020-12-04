package com.chiliuliu.service.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiliuliu.common.entity.req.Student;
import com.chiliuliu.service.mapper.StudentMapper;
import com.chiliuliu.service.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 学生表(Student)表服务实现类
 *
 * @author liuyu
 * @since 2020-12-03 11:15:53
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    /**
     * 服务对象
     */
    @Resource
    private StudentMapper StudentServiceImpl;

}