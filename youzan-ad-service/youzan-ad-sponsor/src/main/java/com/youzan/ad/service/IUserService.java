package com.youzan.ad.service;

import com.youzan.ad.exception.AdException;
import com.youzan.ad.vo.CreateUserResponse;
import com.youzan.ad.vo.CreateUserResquest;

/**
 * Created by baimugudu on 2019/3/27
 */
public interface IUserService {

    /**
     * 创建广告主用户
     * @param resquest
     * @return
     */
    CreateUserResponse createUser(CreateUserResquest resquest) throws AdException;
}
