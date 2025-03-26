package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *简历管理：(ResumeManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ResumeManagement")
public class ResumeManagement implements Serializable {

    //ResumeManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_management_id")
    private Integer resume_management_id;
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
    // 学历
    @Basic
    private String education;
    // 民族
    @Basic
    private String nation;
    // 政治面貌
    @Basic
    private String political_outlook;
    // 年龄
    @Basic
    private String age;
    // 预期薪资
    @Basic
    private String expected_salary;
    // 用户账号
    @Basic
    private Integer user_account;
    // 文件
    @Basic
    private String file;
    // 教育经验
    @Basic
    private String educational_experience;
    // 工作经验
    @Basic
    private String hands_on_background;
    // 面试通知
    @Basic
    private String interview_notice;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
