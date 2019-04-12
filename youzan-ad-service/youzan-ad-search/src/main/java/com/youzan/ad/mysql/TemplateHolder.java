package com.youzan.ad.mysql;

import com.alibaba.fastjson.JSON;
import com.youzan.ad.mysql.dto.ParseTemplate;
import com.youzan.ad.mysql.dto.Template;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by baimugudu on 2019/4/11
 */
public class TemplateHolder {

    private ParseTemplate parseTemplate;

    private JdbcTemplate jdbcTemplate;

    public void loadJson(String path){

        InputStream resourceAsStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(path);


        try {
            Template template =  JSON.parseObject(
                    resourceAsStream, Template.class
            );
            this.parseTemplate = ParseTemplate.parse(template);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }





}
