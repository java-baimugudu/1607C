package com.youzan.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by baimugudu on 2019/3/25
 * @author baimugudu
 */

@Slf4j
@Component
public class PreQequestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        //再请求之前 获取当前请求对象 并且设置参数startTime
        RequestContext context = RequestContext.getCurrentContext();
        context.set("startTime",System.currentTimeMillis());

        return null;
    }
}
