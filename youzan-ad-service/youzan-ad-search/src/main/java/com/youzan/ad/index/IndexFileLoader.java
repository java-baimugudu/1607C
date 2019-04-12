package com.youzan.ad.index;

import com.alibaba.fastjson.JSON;
import com.youzan.ad.dump.DConstant;
import com.youzan.ad.dump.table.*;
import com.youzan.ad.handler.AdLevelDataHandler;
import com.youzan.ad.mysql.constant.OpType;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by baimugudu on 2019/4/11
 *
 * 全量索引加载的实现
 */

@Component
@DependsOn("dataTable")
public class IndexFileLoader {



    @PostConstruct
    public void  init(){
        List<String> adPlanString = loadDumpData(
                String.format(
                        "%s%s",
                        DConstant.DATA_ROOT_DIR,
                        DConstant.AD_PLAN)
        );
        adPlanString.forEach(
                adPlan-> AdLevelDataHandler.handleLevel2(
                        JSON.parseObject(adPlan, AdPlanTable.class)  ,
                        OpType.ADD
                )
        );


        List<String> adCretiveString = loadDumpData(
                String.format(
                        "%s%s",
                        DConstant.DATA_ROOT_DIR,
                        DConstant.AD_CREATIVE
                )
        );

        adCretiveString.forEach(
                adCretive->AdLevelDataHandler.handlevel2(
                        JSON.parseObject(adCretive, AdCreativeTbale.class),
                        OpType.ADD
                )
        );

        List<String> adUnitString = loadDumpData(
                String.format(
                        "%s%s",
                        DConstant.DATA_ROOT_DIR,
                        DConstant.AD_UNIT
                )
        );

        adUnitString.forEach(
                adUnit->AdLevelDataHandler.handlelevel3(
                        JSON.parseObject(adUnit, AdUnitTable.class),
                        OpType.ADD
                )
        );

        List<String> adCreativeUnitString = loadDumpData(
                String.format(
                        "%s%s",
                        DConstant.DATA_ROOT_DIR,
                        DConstant.AD_CREATIVE_UNIT
                )
        );

        adCreativeUnitString.forEach(
                adCreativeUnit->AdLevelDataHandler.handlevel3(
                        JSON.parseObject(adCreativeUnit, AdCreativeUnitTbale.class),
                        OpType.ADD
                )
        );


        List<String> adUnitDistrictString = loadDumpData(
                String.format(
                        "%s%s",
                        DConstant.DATA_ROOT_DIR,
                        DConstant.AD_UNIT_DISTRICT
                )
        );
        adUnitDistrictString.forEach(
                adUnitDistrict->AdLevelDataHandler.handleLevel4(
                        JSON.parseObject(adUnitDistrict, AdUnitDistrictTable.class),
                        OpType.ADD
                )
        );


        List<String> adUnitKeyWordString = loadDumpData(
                String.format(
                        "%s%s",
                        DConstant.DATA_ROOT_DIR,
                        DConstant.AD_UNIT_KEYWORD
                )
        );
        adUnitKeyWordString.forEach(
                adUnitKeyWord->AdLevelDataHandler.handllevel4(
                        JSON.parseObject(adUnitKeyWord,AdUnitKeywordTable.class),
                        OpType.ADD
                )
        );

        List<String> adUnitItString = loadDumpData(
                String.format(
                        "%s%s",
                        DConstant.DATA_ROOT_DIR,
                        DConstant.AD_UNIT_IT
                )
        );

        adUnitItString.forEach(
                adUnitIt->AdLevelDataHandler.handlLevel4(
                        JSON.parseObject(adUnitIt,AdUnitItTable.class),
                        OpType.ADD
                )
        );
    }
    private List<String> loadDumpData(String fileName){
        try(BufferedReader reader =Files.newBufferedReader(
                Paths.get(fileName)
        )){
            return reader.lines().collect(Collectors.toList());
        }catch(Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        }
    }
}
