package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *打卡记录：(PunchInRecord)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PunchInRecord")
public class PunchInRecord implements Serializable {

    //PunchInRecord编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "punch_in_record_id")
    private Integer punch_in_record_id;
    // 打卡类型
    @Basic
    private String punch_in_type;
    // 打卡日期
    @Basic
    private String punch_in_date;
    // 打卡时间
    @Basic
    private Timestamp clock_in_time;
    // 姓名
    @Basic
    private String full_name;
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
