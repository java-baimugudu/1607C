package com.youzan.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by baimugudu on 2019/3/25
 */


@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = context.getRequest();
        Long startTime = (Long)context.get("startTime");
        String uri =  httpServletRequest.getRequestURI();
        Long cha =  System.currentTimeMillis()- startTime;
        log.info("uri:"+uri+";时间差:"+cha/100+"ms");
        return null;
    }
}
