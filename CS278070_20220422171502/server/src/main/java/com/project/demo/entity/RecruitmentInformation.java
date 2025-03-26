package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *招聘信息：(RecruitmentInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RecruitmentInformation")
public class RecruitmentInformation implements Serializable {

    //RecruitmentInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruitment_information_id")
    private Integer recruitment_information_id;
    // 招聘编号
    @Basic
    private String recruitment_no;
    // 招聘职位
    @Basic
    private String recruitment_position;
    // 招聘人数
    @Basic
    private Integer number_of_recruits;
    // 招聘时间
    @Basic
    private String recruitment_time;
    // 年龄要求
    @Basic
    private String age_requirements;
    // 工资预计
    @Basic
    private String salary_forecast;
    // 学历要求
    @Basic
    private String educational_requirements;
    // 经验要求
    @Basic
    private String experience_requirements;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
