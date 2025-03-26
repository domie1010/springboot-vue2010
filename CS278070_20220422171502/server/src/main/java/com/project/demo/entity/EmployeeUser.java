package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *员工用户：(EmployeeUser)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EmployeeUser")
public class EmployeeUser implements Serializable {

    //EmployeeUser编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_user_id")
    private Integer employee_user_id;
    // 姓名
    @Basic
    private String full_name;
    // 性别
    @Basic
    private String gender;
    // 年龄
    @Basic
    private String age;
    // 身份证
    @Basic
    private String id;
    // 部门名
    @Basic
    private String department_name;
    // 职位名
    @Basic
    private String position_name;
    // 入职时间
    @Basic
    private Timestamp entry_time;
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
