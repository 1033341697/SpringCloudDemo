package com.chiliuliu.common.entity.req;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
 * 用户表(User)实体类
 *
 * @author liuyu
 * @since 2020-11-27 14:30:27
 */
@ApiModel("用户表")
public class User extends Model<User> {

    /**
     * 主键id
     */
    @ApiModelProperty("用户id")
    private String id;

    /**
     * 用户姓名
     */
    @ApiModelProperty("用户姓名")
    @Length(max = 5, message = "用户姓名过长")
    private String name;

    /**
     * 性别
     */
    @ApiModelProperty("用户性别")
    private String sex;

    /**
     * 用户编码
     */
    @ApiModelProperty("用户编码")
    private String code;


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}