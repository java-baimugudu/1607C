package com.youzan.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by baimugudu on 2019/3/25
 * @author baimugudu
 */


@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {


    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
