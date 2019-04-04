package com.youzan.ad.client;

import com.youzan.ad.client.vo.AdPlanGetRequest;
import com.youzan.ad.client.vo.AdPlanResponse;
import com.youzan.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by baimugudu on 2019/4/1
 * @author
 */
@Component
public class SponeorClientHystrix implements  SponeorClient{
    @Override

   // @HystrixCommand(fallbackMethod = "getPlanfallbackMethod")
    public CommonResponse<List<AdPlanResponse>> getPlan(AdPlanGetRequest request) {
        return new CommonResponse(-1,"网络异常",null);
    }

//    public CommonResponse<List<AdPlanResponse>> getPlanfallbackMethod(AdPlanGetRequest request) {
//        return new CommonResponse(-1,"网络异常",null);
//    }
}
