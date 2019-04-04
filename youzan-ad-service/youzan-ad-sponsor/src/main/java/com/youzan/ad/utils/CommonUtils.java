package com.youzan.ad.utils;

import com.youzan.ad.exception.AdException;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jcajce.provider.digest.MD5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by baimugudu on 2019/3/27
 */
public class CommonUtils {

    /**
     * 获取字符串的MD5值
     * @param str
     * @return
     */
    public  static  String md5(String str){
        return DigestUtils.md5Hex(str).toUpperCase();
    }


    /**
     * 将时间字符串类型转化为data类型
     * @param dateStr
     * @return
     */
    public static Date parseStringDate(String dateStr) throws AdException{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw  new AdException(e.getMessage());
        }

    }
}
