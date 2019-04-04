package com.youzan.ad.controller;

import com.alibaba.fastjson.JSON;
import com.youzan.ad.entity.AdPlan;
import com.youzan.ad.exception.AdException;
import com.youzan.ad.service.IAdPlanService;
import com.youzan.ad.vo.AdPlanGetRequest;
import com.youzan.ad.vo.AdPlanRequest;
import com.youzan.ad.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by baimugudu on 2019/3/27
 */

@Slf4j
@RestController
@RequestMapping("/plan")
public class AdPlanController {

    @Autowired
    IAdPlanService planService;


    /**
     * 创建推广计划
     * @param planRequest
     * @return
     * @throws AdException
     */
    @PostMapping
    public AdPlanResponse createPlan(@RequestBody  AdPlanRequest planRequest)
            throws AdException {
        log.info("youzan-ad-sponsor: createPlan->{}",
                JSON.toJSONString(planRequest));
       return  planService.createPlan(planRequest);
    }

    /**
     * 修改推广计划
     * @param planRequest
     * @return
     * @throws AdException
     */
    @PutMapping
    public AdPlanResponse updatePlan(@RequestBody  AdPlanRequest planRequest)
            throws  AdException{
        log.info("youzan-ad-sponsor: updatePlan->{}",
                JSON.toJSONString(planRequest));
        return planService.updatePlan(planRequest);
    }

    /**
     * 查询推广计划
     * @param planGetRequest
     * @return
     * @throws AdException
     */
    @PostMapping("/getPlan")
    public List<AdPlan> getPlan( @RequestBody AdPlanGetRequest planGetRequest)
            throws  AdException{
        log.info("youzan-ad-sponsor: getPlan->{}",
                JSON.toJSONString(planGetRequest));
        return planService.getPlanByIds(planGetRequest);
    }

    /**
     * 删除推广计划
     * @param planRequest
     * @throws AdException
     */
    @DeleteMapping
    public void deletePlan(@RequestBody  AdPlanRequest planRequest)
            throws  AdException{
        log.info("youzan-ad-sponsor: deletePlan->{}",
                JSON.toJSONString(planRequest));
         planService.deletePlan(planRequest);
    }


}
