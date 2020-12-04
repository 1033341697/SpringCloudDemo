package com.chiliuliu.common.entity.req;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 学生表(Student)实体类
 *
 * @author liuyu
 * @since 2020-12-03 11:15:53
 */
public class Student extends Model<Student> {

    /**
     * id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学号
     */
    private String code;

    private String userId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}