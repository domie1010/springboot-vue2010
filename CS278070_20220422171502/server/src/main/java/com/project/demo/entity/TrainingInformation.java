package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *培训信息：(TrainingInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "TrainingInformation")
public class TrainingInformation implements Serializable {

    //TrainingInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_information_id")
    private Integer training_information_id;
    // 姓名
    @Basic
    private String full_name;
    // 性别
    @Basic
    private String gender;
    // 身份证
    @Basic
    private String id;
    // 部门名
    @Basic
    private String department_name;
    // 职位名
    @Basic
    private String position_name;
    // 培训时间
    @Basic
    private Timestamp training_time;
    // 培训地点
    @Basic
    private String training_location;
    // 员工
    @Basic
    private Integer staff;
    // 培训内容
    @Basic
    private String training_content;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
