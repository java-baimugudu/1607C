package com.youzan.ad.dao;

import com.youzan.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by baimugudu on 2019/3/27
 */
public interface AdUserRepository extends JpaRepository<AdUser,Long> {

    /**
     * 根据用户名查询用户记录
     * @param username：用户名
     * @return
     */
    AdUser findByUsername(String username);
}
