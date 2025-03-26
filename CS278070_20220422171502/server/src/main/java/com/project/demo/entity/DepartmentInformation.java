package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *部门信息：(DepartmentInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DepartmentInformation")
public class DepartmentInformation implements Serializable {

    //DepartmentInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_information_id")
    private Integer department_information_id;
    // 部门编号
    @Basic
    private String department_number;
    // 部门名
    @Basic
    private String department_name;
    // 部门人数
    @Basic
    private String number_of_departments;
    // 部门简介
    @Basic
    private String department_profile;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
