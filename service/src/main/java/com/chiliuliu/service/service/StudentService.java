package com.chiliuliu.service.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chiliuliu.common.entity.dto.StudentDto;
import com.chiliuliu.common.entity.po.Student;

/**
 * 学生表(Student)表服务接口
 *
 * @author liuyu
 * @since 2020-12-03 11:15:53
 */
public interface StudentService extends IService<Student> {
    R page(IPage page, StudentDto studentDto);
}