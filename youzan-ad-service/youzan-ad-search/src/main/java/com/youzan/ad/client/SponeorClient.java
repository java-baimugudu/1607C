package com.youzan.ad.client;

import com.youzan.ad.client.vo.AdPlanGetRequest;
import com.youzan.ad.client.vo.AdPlanResponse;
import com.youzan.ad.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by baimugudu on 2019/4/1
 */
//,fallback=SponeorClientHystrix.class
@FeignClient(value = "AD-SPONSOR",fallback=SponeorClientHystrix.class)
public interface SponeorClient {


    @RequestMapping(value = "/ad-sponsor/plan/getPlan",method = RequestMethod.POST)
    CommonResponse<List<AdPlanResponse>> getPlan(
            @RequestBody AdPlanGetRequest request);





}
