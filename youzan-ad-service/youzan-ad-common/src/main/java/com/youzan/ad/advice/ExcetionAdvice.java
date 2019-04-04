package com.youzan.ad.advice;

import com.youzan.ad.exception.AdException;
import com.youzan.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by baimugudu on 2019/3/26
 * @author
 * 统一处理异常
 */


@RestControllerAdvice
public class ExcetionAdvice {

   @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerException(AdException ad){
        CommonResponse commonResponse = new CommonResponse<String>(-1,"业务繁忙");
        commonResponse.setData(ad.getMessage());
        return commonResponse;

    }
}
