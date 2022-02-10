package com.chiliuliu.service.service.impl;


import com.aliyun.oss.OSSClient;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiliuliu.common.entity.dto.StudentDto;
import com.chiliuliu.common.entity.po.Student;
import com.chiliuliu.common.utils.DtoEntityUtil;
import com.chiliuliu.common.utils.OSSUtils;
import com.chiliuliu.service.mapper.StudentMapper;
import com.chiliuliu.service.service.MessageService;
import com.chiliuliu.service.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    private StudentMapper studentMapper;
    @Resource
    private MessageService messageService;

    @Resource
    private DtoEntityUtil dtoEntityUtil;

    @Resource
    private OSSUtils ossUtils;

    @Override
    public R page(IPage page, StudentDto studentDto) {
        Student student = dtoEntityUtil.trans(studentDto, Student.class);
        IPage page1 = studentMapper.selectPage(page, new QueryWrapper<>(student));
        messageService.testMessage(student.getName());
        return R.ok(page1);
    }

    @Override
    public R all(StudentDto studentDto) {
        Student student = dtoEntityUtil.trans(studentDto, Student.class);
        OSSClient instance = ossUtils.getInstance();
        List<Student> students = studentMapper.selectList(new QueryWrapper<>(student));
        R r = messageService.testMessage(student.getName());
        return r;
    }
}