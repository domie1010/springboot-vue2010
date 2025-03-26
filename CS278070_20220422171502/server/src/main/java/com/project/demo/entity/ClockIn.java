package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *考勤打卡：(ClockIn)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ClockIn")
public class ClockIn implements Serializable {

    //ClockIn编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clock_in_id")
    private Integer clock_in_id;
    // 打卡类型
    @Basic
    private String punch_in_type;
    // 打卡日期
    @Basic
    private Timestamp punch_in_date;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
