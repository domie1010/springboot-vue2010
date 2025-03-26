package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *薪资信息：(SalaryInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SalaryInformation")
public class SalaryInformation implements Serializable {

    //SalaryInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_information_id")
    private Integer salary_information_id;
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
    // 基本工资
    @Basic
    private Integer base_pay;
    // 扣款金额
    @Basic
    private Integer deduction_amount;
    // 奖励金额
    @Basic
    private Integer reward_amount;
    // 总工资
    @Basic
    private String total_salary;
    // 工资月份
    @Basic
    private String salary_month;
    // 员工
    @Basic
    private Integer staff;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
