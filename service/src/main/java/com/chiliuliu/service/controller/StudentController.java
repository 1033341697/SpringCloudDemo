package com.chiliuliu.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chiliuliu.common.entity.ResultCodeEnum;
import com.chiliuliu.common.entity.req.Student;
import com.chiliuliu.common.exception.MyException;
import com.chiliuliu.service.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 学生表(Student)表控制层
 *
 * @author liuyu
 * @since 2020-12-03 11:15:53
 */
@RestController
@RequestMapping("student")
public class StudentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 分页查询所有数据
     *
     * @param student 查询实体
     * @return 所有数据
     */
    @PostMapping()
    public R selectAll(Page<Student> page, Student student) {
        if (student.getId().equals("1")) {
            try {
                Thread.sleep(100040L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new MyException(ResultCodeEnum.ERROR);
            }
        }
        return success(this.studentService.page(page, new QueryWrapper<>(student)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.studentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param student 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public R insert(@RequestBody Student student) {
        return success(this.studentService.save(student));
    }

    /**
     * 修改数据
     *
     * @param student 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Student student) {
        return success(this.studentService.updateById(student));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.studentService.removeByIds(idList));
    }

    @GetMapping("testFeign")
    public String testFeign() {
        return "我是service服务返回的数据";
    }
}