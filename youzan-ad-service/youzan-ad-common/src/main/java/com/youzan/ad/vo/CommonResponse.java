package com.youzan.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by baimugudu on 2019/3/26
 * @author baimugudu
 * 统一返回（响应）对象
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> implements Serializable {

    /**
     * 业务状态码
     * 0：成功
     * -1：失败
     *
     */
    private Integer code;


    /**
     * 业务得描述信息
     */
    private String message;

    /**
     * 返回对象
     */
    private T data;


    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
