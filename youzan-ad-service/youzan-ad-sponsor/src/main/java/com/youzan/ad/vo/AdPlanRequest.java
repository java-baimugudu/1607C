package com.youzan.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * Created by baimugudu on 2019/3/27
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanRequest {

    private Long  id;

    private Long userId;

    private String planName;

    private String startTime;

    private String endTime;


    public boolean createPlanValidate(){
        return userId !=null
                && !StringUtils.isEmpty(planName)
                && !StringUtils.isEmpty(startTime)
                && !StringUtils.isEmpty(endTime);
    }


    public boolean updatePlanValidate(){
        return id!=null && userId!=null;
    }



    public boolean deletePlanValidate(){
        return id!=null && userId!=null;
    }
}
