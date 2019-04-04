package com.youzan.ad.entity;

import com.youzan.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by baimugudu on 2019/3/26
 */

@Entity
@Table(name="ad_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUser {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "token",nullable = false)
    private String token;


    @Column(name = "user_status",nullable = false)
    private Integer userStatus;


    @Column(name = "create_time",nullable = false)
    private Date createTime;


    @Basic
    @Column(name = "update_time",nullable = false)
    private Date updateTime;


    public AdUser(String username,String token){
        this.username = username;
        this.token = token;
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updateTime = new Date();

    }
}
