package com.youzan.ad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by baimugudu on 2019/3/26
 */

@Entity
@Table(name="ad_creative")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdCreative {


    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "type",nullable = false)
    private Integer type;

    @Column(name = "material_type",nullable = false)
    private Integer materialType;

    @Column(name = "height",nullable = false)
    private Integer height;

    @Column(name = "width",nullable = false)
    private Integer width;

    @Column(name = "size",nullable = false)
    private Long size;

    @Column(name = "duration",nullable = false)
    private Integer duration;

    @Column(name = "audit_status",nullable = false)
    private Integer auditStatus;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "url",nullable = false)
    private String url;

    @Column(name = "create_time",nullable = false)
    private Date createTime;

    @Column(name = "update_time",nullable = false)
    private Date updateTime;



}
