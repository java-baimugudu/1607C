package com.youzan.ad.entity;

import com.youzan.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by baimugudu on 2019/3/26
 * @author
 * 推广计划表
 *
 */

@Entity
@Table(name="ad_plan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlan {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "plan_name",nullable = false)
    private String planName;

    @Column(name = "plan_status",nullable = false)
    private Integer planStatus;

    @Column(name = "create_time",nullable = false)
    private Date createTime;

    @Column(name = "update_time",nullable = false)
    private Date updateTime;

    @Column(name = "start_date",nullable = false)
    private  Date startTime;

    /**
     * 推广计划得结束时间
     */
    @Column(name = "end_date",nullable = false)
    private Date endTime;


    public AdPlan(Long userId,String planName,
                  Date startTime,Date endTime){
        this.userId = userId;
        this.planName  = planName;
        this.planStatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updateTime = new Date();
        this.startTime = startTime;
        this.endTime = endTime;

    }


}
