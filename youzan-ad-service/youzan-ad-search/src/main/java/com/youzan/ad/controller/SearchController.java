package com.youzan.ad.controller;

import com.youzan.ad.annotation.IgnoreResponseAdvice;
import com.youzan.ad.client.SponeorClient;
import com.youzan.ad.client.vo.AdPlanGetRequest;
import com.youzan.ad.client.vo.AdPlanResponse;
import com.youzan.ad.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by baimugudu on 2019/4/1
 */

@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

//    @Autowired
//    RestTemplate restTemplate;
//
//   @PostMapping
//   @IgnoreResponseAdvice
//    public CommonResponse<List<AdPlanResponse>>  findPlan(
//         @RequestBody AdPlanGetRequest request
//    ){
//        log.info("ad-serach:findPlan ->{}", JSON.toJSONString(request));
//
//
//        return restTemplate.postForEntity(
//                "http://AD-SPONSOR/ad-sponsor/plan/getPlan",
//                request,
//                CommonResponse.class)
//                .getBody();
//    }

    @Autowired
    SponeorClient sponeorClient;

    @PostMapping
    @IgnoreResponseAdvice
    public CommonResponse<List<AdPlanResponse>> findPlan(
            @RequestBody AdPlanGetRequest request){
        return sponeorClient.getPlan(request);
    }

}
