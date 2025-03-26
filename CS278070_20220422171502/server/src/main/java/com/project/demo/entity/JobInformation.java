package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *职务信息：(JobInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "JobInformation")
public class JobInformation implements Serializable {

    //JobInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_information_id")
    private Integer job_information_id;
    // 职位编号
    @Basic
    private String position_number;
    // 职位名
    @Basic
    private String position_name;
    // 职位人数
    @Basic
    private String number_of_positions;
    // 职位简介
    @Basic
    private String job_profile;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
