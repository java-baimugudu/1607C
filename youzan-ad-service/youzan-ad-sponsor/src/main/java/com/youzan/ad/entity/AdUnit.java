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
 * 推广单元表
 */

@Entity
@Table(name="ad_unit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnit {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plan_id",nullable = false)
    private Long planId;

    @Column(name = "unit_name",nullable = false)
    private String unitName;

    @Column(name = "unit_status",nullable = false)
    private Integer unitStatus;

    /**
     * 广告位类型
     */
    @Column(name = "position_type",nullable = false)
    private Integer positionType;

    /**
     * 预算
     */
    @Column(name = "budget",nullable = false)
    private Long budget;

    @Column(name = "create_time",nullable = false)
    private Date createTime;

    @Column(name = "update_time",nullable = false)
    private Date updateTime;

    public AdUnit(Long planId,
                  String unitName,
                  Integer positionType,
                  Long budget){

        this.planId = planId;
        this.budget = budget;
        this.createTime = new Date();
        this.positionType = positionType;
        this.unitName = unitName;
        this.unitStatus = CommonStatus.VALID.getStatus();
        this.updateTime = new Date();

    }


}
