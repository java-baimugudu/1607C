package com.youzan.ad.controller;

import com.alibaba.fastjson.JSON;
import com.youzan.ad.exception.AdException;
import com.youzan.ad.service.IAdUnitService;
import com.youzan.ad.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baimugudu on 2019/3/29
 */

@RestController
@Slf4j
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    IAdUnitService unitService;


    @PostMapping
    public AdUnitResponse createUnit(@RequestBody AdUnitRequest request)
            throws AdException {

        log.info("youzan-ad-sponsor: createUnit->{}",
                JSON.toJSONString(request));
        return unitService.createUnit(request);
    }

    @PostMapping("/createUnitKeyWords")
    public AdUnitKeywordResponse createUnitKeyWords(@RequestBody AdUnitKeyWordRequest request) {
        log.info("youzan-ad-sponsor: createUnitKeyWords->{}",
                JSON.toJSONString(request));
        return unitService.createUnitKeyWord(
                request
        );

    }

    @PostMapping("/createAdUnitDistrict")
    public AdUnitDistrictResponse createAdUnitDistrict(@RequestBody AdUnitDistrictRequest request) {

        log.info("youzan-ad-sponsor: createAdUnitDistrict->{}",
                JSON.toJSONString(request));
        return unitService.createAdUnitDistrict(request);

    }

    @PostMapping("/createAdUnitIt")
    public AdUnitItResponse createAdUnitIt(AdUnitItRequest request) {

        log.info("youzan-ad-sponsor: createAdUnitIt->{}",
                JSON.toJSONString(request));
        return unitService.createUnitIt(request);

    }

    @PostMapping("/createCreativeUnit")
    public CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) {

        log.info("youzan-ad-sponsor: createCreativeUnit->{}",
                JSON.toJSONString(request));
        return unitService.createCreativeUnit(request);

    }

}
