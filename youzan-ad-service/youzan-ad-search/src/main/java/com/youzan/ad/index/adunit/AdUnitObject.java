package com.youzan.ad.index.adunit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by baimugudu on 2019/4/2
 * @author
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitObject {

    private Long unitId;

    private Integer unitStatus;

    private Integer positionType;

    private Long planId;

    public void update (AdUnitObject newObject){

        if(null!=newObject.getUnitId()){
            this.unitId = newObject.getUnitId();
        }

        if(null!=newObject.getUnitStatus()){
            this.unitStatus = newObject.getUnitStatus();
        }

        if(null!=newObject.getPositionType()){
            this.positionType = newObject.getPositionType();
        }

        if(null!=newObject.getPlanId()){
            this.planId = newObject.getPlanId();
        }

    }
}
