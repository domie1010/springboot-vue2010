package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *录用结果：(EmploymentResults)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EmploymentResults")
public class EmploymentResults implements Serializable {

    //EmploymentResults编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employment_results_id")
    private Integer employment_results_id;
    // 招聘编号
    @Basic
    private String recruitment_no;
    // 招聘职位
    @Basic
    private String recruitment_position;
    // 姓名
    @Basic
    private String full_name;
    // 性别
    @Basic
    private String gender;
    // 身份证
    @Basic
    private String id;
    // 用户账号
    @Basic
    private Integer user_account;
    // 是否录用
    @Basic
    private String whether_to_employ;
    // 录用意见
    @Basic
    private String employment_opinions;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
