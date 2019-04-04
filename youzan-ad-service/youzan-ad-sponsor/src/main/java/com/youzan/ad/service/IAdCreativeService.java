package com.youzan.ad.service;

import com.youzan.ad.exception.AdException;
import com.youzan.ad.vo.CreativeRequest;
import com.youzan.ad.vo.CreativeResopnse;

/**
 * Created by baimugudu on 2019/3/29
 */
public interface IAdCreativeService {


    /**
     * 创建  创意（物料）
     */


    CreativeResopnse createCreateive (CreativeRequest request) throws AdException, AdException;
}
