package com.youzan.ad.vo;

import com.youzan.ad.constant.CommonStatus;
import com.youzan.ad.entity.AdCreative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by baimugudu on 2019/3/29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeRequest {


    private String name;


    private Integer type;


    private Integer materialType;


    private Integer height;


    private Integer width;

    private Long size;

    private Integer duration;

    private Long userId;


    private String url;



    public AdCreative toEntity(){
        AdCreative creative = new AdCreative();
        creative.setName(name);
        creative.setDuration(duration);
        creative.setHeight(height);
        creative.setSize(size);
        creative.setMaterialType(materialType);
        creative.setType(type);
        creative.setUrl(url);
        creative.setCreateTime(new Date());
        creative.setAuditStatus(CommonStatus.VALID.getStatus());
        creative.setUpdateTime(creative.getCreateTime());
        creative.setUserId(userId);
        return creative;
    }



}
