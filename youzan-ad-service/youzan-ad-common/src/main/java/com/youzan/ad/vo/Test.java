package com.youzan.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fei
 * @data 2019-04-09 下午 08:19
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test<T> implements Serializable {


    private int code;
    private String desc;
    private T data;

    public Test(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
