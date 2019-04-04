package com.youzan.ad.dao;

import com.youzan.ad.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by baimugudu on 2019/3/27
 */
public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {

    /**
     * 根据广告主查询广告计划
     */
    List<AdPlan> findAllByUserId(Long userId);


    /**
     * 广告主查看广告计划
     */
    AdPlan findByIdAndUserId(Long id,Long userId);

    /**
     * 根据id 和广告主id 查询
     * @param ids
     * @param userId
     * @return
     */
    List<AdPlan>  findAllByIdInAndUserId(List<Long> ids,Long userId);


    /**
     * 根据广告计划查询
     * @param planStatus
     * @return
     */
    List<AdPlan> findAllByPlanStatus(Integer planStatus);


    AdPlan findByUserIdAndAndPlanName(Long userId,String planName);





}
