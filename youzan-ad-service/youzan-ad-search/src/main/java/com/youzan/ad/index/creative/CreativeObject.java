package com.youzan.ad.index.creative;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by baimugudu on 2019/4/2
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeObject {

    private Long adId;

    private String name;

    private Integer type;

    private Integer materialType;

    private Integer height;

    private Integer width;

    private Integer auditStatus;


    public void update(CreativeObject newObject){

        if(null!=newObject.getAdId()){
            this.adId = newObject.getAdId();
        }

        if(null!=newObject.getName()){
            this.name = newObject.getName();
        }

        if(null!=newObject.getType()){
            this.type = newObject.getType();
        }
        if(null!=newObject.getMaterialType()){
            this.materialType = newObject.getMaterialType();
        }

        if(null!=newObject.getHeight()){
            this.height = newObject.getHeight();
        }

        if(null!=newObject.getWidth()){
            this.width = newObject.getWidth();
        }

        if(null!=newObject.getAuditStatus()){
            this.auditStatus = newObject.getAuditStatus();
        }

    }

}
