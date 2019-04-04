package com.youzan.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by baimugudu on 2019/3/25
 * @author baimugudu
 */

@SpringBootApplication
@EnableZuulProxy
public class ZuulGateWayApplication {


    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayApplication.class,args);
    }
}
