package com.youzan.ad.service;

import com.youzan.ad.entity.AdPlan;
import com.youzan.ad.exception.AdException;
import com.youzan.ad.vo.AdPlanGetRequest;
import com.youzan.ad.vo.AdPlanRequest;
import com.youzan.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * Created by baimugudu on 2019/3/27
 */
public interface IAdPlanService {


    /**
     * 创建推广计划
     */

    AdPlanResponse createPlan(AdPlanRequest planRequest) throws AdException;


    /**
     * 更新推广计划
     */
    AdPlanResponse updatePlan(AdPlanRequest planRequest) throws AdException;


    /**
     * 获取推广计划
     */

    List<AdPlan> getPlanByIds(AdPlanGetRequest planGetRequest)throws  AdException;


    /**
     * 删除推广计划
    */
    void deletePlan(AdPlanRequest planRequest) throws  AdException;
}
