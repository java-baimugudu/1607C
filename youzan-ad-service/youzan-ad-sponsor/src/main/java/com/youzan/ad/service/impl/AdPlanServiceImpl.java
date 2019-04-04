package com.youzan.ad.service.impl;

import com.youzan.ad.constant.CommonStatus;
import com.youzan.ad.constant.Constants;
import com.youzan.ad.dao.AdPlanRepository;
import com.youzan.ad.dao.AdUserRepository;
import com.youzan.ad.entity.AdPlan;
import com.youzan.ad.entity.AdUser;
import com.youzan.ad.exception.AdException;
import com.youzan.ad.service.IAdPlanService;
import com.youzan.ad.utils.CommonUtils;
import com.youzan.ad.vo.AdPlanGetRequest;
import com.youzan.ad.vo.AdPlanRequest;
import com.youzan.ad.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by baimugudu on 2019/3/27
 * @author
 */

@Service
public class AdPlanServiceImpl implements IAdPlanService {
    @Autowired
    AdUserRepository userRepository;

    @Autowired
    AdPlanRepository planRepository;

    @Override
    @Transactional
    public AdPlanResponse createPlan(AdPlanRequest planRequest) throws AdException {

        //验证参数是否合法
        if(!planRequest.createPlanValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETERS_ERROR);
        }


        //查询当前的广告主是否存在
        final Optional<AdUser> adUser = userRepository.findById(planRequest.getUserId());
        if(!adUser.isPresent()){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_USER);
        }

        //查询当前的广告主是否已经有相同的推广计划
        final AdPlan byUserIdAndAndPlanName = planRepository.
                findByUserIdAndAndPlanName(planRequest.getUserId(),
                        planRequest.getPlanName());

        if(null!= byUserIdAndAndPlanName){
            throw new AdException(Constants.ErrorMsg.THE_PLAN_ALREADY_EXISTS);
        }

        //保存
        AdPlan newPlan =  planRepository.save(
                new AdPlan(
                        planRequest.getUserId(),
                        planRequest.getPlanName(),
                        CommonUtils.parseStringDate( planRequest.getStartTime()),
                        CommonUtils.parseStringDate( planRequest.getEndTime()))
        );



        return new AdPlanResponse(newPlan.getId(),
                newPlan.getPlanName());
    }

    @Override
   @Transactional
    public AdPlanResponse updatePlan(AdPlanRequest planRequest) throws AdException {

        //验证参数是否合法
        if(!planRequest.updatePlanValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETERS_ERROR);
        }


        //查询要修改的推广计划是否存在
         AdPlan plan = planRepository.findByIdAndUserId(
                planRequest.getId(),
                planRequest.getUserId()
        );

        if(null==plan){
            throw  new AdException(Constants.ErrorMsg.CAN_NOT_FIND_PLAN);
        }


        if(null!=planRequest.getPlanName()){
            plan.setPlanName(planRequest.getPlanName());
        }

        if(null!=planRequest.getStartTime()){
            plan.setStartTime(CommonUtils.parseStringDate(
                    planRequest.getStartTime()));
        }

        if(null!=planRequest.getEndTime()){
            plan.setEndTime(
                    CommonUtils.parseStringDate(planRequest.getEndTime())
            );
        }

        plan.setUpdateTime(new Date());

        plan = planRepository.save(plan);


        return new AdPlanResponse(plan.getId(),plan.getPlanName());
    }

    @Override
    public List<AdPlan> getPlanByIds(AdPlanGetRequest planGetRequest) throws AdException {

        if(!planGetRequest.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETERS_ERROR);
        }
        return planRepository.findAllByIdInAndUserId(
                planGetRequest.getIds(),
                planGetRequest.getUserId()
        );
    }

    @Override
    @Transactional
    public void deletePlan(AdPlanRequest planRequest) throws AdException {


        if(!planRequest.deletePlanValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAMETERS_ERROR);
        }


        //查询要删除的推广计划是否存在
        AdPlan plan = planRepository.findByIdAndUserId(
                planRequest.getId(),
                planRequest.getUserId()
        );

        if(null==plan){
            throw  new AdException(Constants.ErrorMsg.CAN_NOT_FIND_PLAN);
        }


        plan.setPlanStatus(CommonStatus.INVALID.getStatus());

        plan.setUpdateTime(new Date());

        planRepository.save(plan);


    }
}
