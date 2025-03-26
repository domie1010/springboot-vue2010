package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *用户注册：(UserRegistration)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "UserRegistration")
public class UserRegistration implements Serializable {

    //UserRegistration编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_registration_id")
    private Integer user_registration_id;
    // 性别
    @Basic
    private String gender;
    // 姓名
    @Basic
    private String full_name;
    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
