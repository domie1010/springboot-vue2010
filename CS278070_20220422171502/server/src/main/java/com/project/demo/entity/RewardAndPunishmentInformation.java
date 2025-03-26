package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *奖惩信息：(RewardAndPunishmentInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RewardAndPunishmentInformation")
public class RewardAndPunishmentInformation implements Serializable {

    //RewardAndPunishmentInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_and_punishment_information_id")
    private Integer reward_and_punishment_information_id;
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
    // 奖惩类型
    @Basic
    private String types_of_rewards_and_punishments;
    // 奖惩时间
    @Basic
    private Timestamp reward_and_punishment_time;
    // 员工
    @Basic
    private Integer staff;
    // 奖惩详情
    @Basic
    private String details_of_rewards_and_punishments;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
