package com.youzan.ad.handler;

import com.youzan.ad.dump.table.*;
import com.youzan.ad.index.DataTable;
import com.youzan.ad.index.IndexAware;
import com.youzan.ad.index.adplan.AdPlanIndex;
import com.youzan.ad.index.adplan.AdPlanObject;
import com.youzan.ad.index.adunit.AdUnitIndex;
import com.youzan.ad.index.adunit.AdUnitObject;
import com.youzan.ad.index.creative.CreativeIndex;
import com.youzan.ad.index.creative.CreativeObject;
import com.youzan.ad.index.creativeunit.CreativeUnitIndex;
import com.youzan.ad.index.creativeunit.CreativeUnitObject;
import com.youzan.ad.index.district.UnitDistrictIndex;
import com.youzan.ad.index.district.UnitDistrictObject;
import com.youzan.ad.index.interest.UnitItIndex;
import com.youzan.ad.index.interest.UnitItObject;
import com.youzan.ad.index.keyword.UnitKeyWordIndex;
import com.youzan.ad.index.keyword.UnitKeyWordObject;
import com.youzan.ad.mysql.constant.OpType;
import com.youzan.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by baimugudu on 2019/4/3
 */

@Slf4j
public class AdLevelDataHandler {



    public static void handleLevel2(AdPlanTable adPlanTable,OpType type){
        AdPlanObject adPlanObject = new AdPlanObject(
                adPlanTable.getPlanId(),
                adPlanTable.getUserId(),
                adPlanTable.getPlanStatus(),
                adPlanTable.getStartDate(),
                adPlanTable.getEndDate()
        );
        handleBinLongEvent(
                DataTable.of(AdPlanIndex.class),
                adPlanObject.getPlanId(),
                adPlanObject,
                type
        );
    }
    public static void handlevel2(AdCreativeTbale adCreativeTbale,OpType type){
        CreativeObject creativeObject = new CreativeObject(
                adCreativeTbale.getAdId(),
                adCreativeTbale.getName(),
                adCreativeTbale.getType(),
                adCreativeTbale.getMaterialType(),
                adCreativeTbale.getHeight(),
                adCreativeTbale.getWidth(),
                adCreativeTbale.getAuditStatus()
        );

        handleBinLongEvent(DataTable.of(CreativeIndex.class),
                creativeObject.getAdId(),
                creativeObject,
                type
                );
    }


    public static  void handlelevel3(AdUnitTable adUnitTable,OpType type){
        AdPlanObject adPlanObject = DataTable.of(AdPlanIndex.class).
                get(adUnitTable.getPlanId());

        if(null==adPlanObject){
            log.error("this planId id invalidate");
            return;
        }

        AdUnitObject adUnitObject =  new AdUnitObject(
                adUnitTable.getUnitId(),
                adUnitTable.getUnitStatus(),
                adUnitTable.getPositionType(),
                adUnitTable.getPlanId()
        );

        handleBinLongEvent(
                DataTable.of(AdUnitIndex.class),
                adUnitObject.getUnitId(),
                adUnitObject,
                type
        );
    }


    public static  void  handlevel3(AdCreativeUnitTbale adCreativeUnitTbale,
                                    OpType type){

        if(OpType.UPDATE==type){
            log.error("no support update");
            return;
        }

        AdUnitObject adUnitObject = DataTable.of(AdUnitIndex.class)
                .get(adCreativeUnitTbale.getUnitId());

        if(null==adUnitObject){
            log.error("this unitId is invalidate");
            return ;
        }


        CreativeObject creativeObject = DataTable.of(CreativeIndex.class)
                .get(adCreativeUnitTbale.getAdId());

        if(null==creativeObject){
            log.error("this.adId id invalidate");
            return;
        }


        CreativeUnitObject unitObject = new CreativeUnitObject(
                adCreativeUnitTbale.getUnitId(),
                adCreativeUnitTbale.getAdId()
        );

        handleBinLongEvent(
                DataTable.of(CreativeUnitIndex.class),
                CommonUtils.stringConcat(
                        unitObject.getAdId().toString(),
                        unitObject.getUnitId().toString()
                ),
                unitObject,
                type

        );

    }


    public  static  void handleLevel4(AdUnitDistrictTable adUnitDistrictTable,
                                      OpType type){

        if(type==OpType.UPDATE){
            log.error(" no support update");
            return ;
        }


        AdUnitObject adUnitObject = DataTable.of(AdUnitIndex.class).
                get(adUnitDistrictTable.getUnitId());

        if(null==adUnitObject){
            log.error("this  unitid is invalidate ");
            return;
        }

        UnitDistrictObject unitDistrictObject = new UnitDistrictObject(
                 adUnitDistrictTable.getUnitId(),
                 adUnitDistrictTable.getProvince(),
                 adUnitDistrictTable.getCity()
         );




        handleBinLongEvent(
                DataTable.of(UnitDistrictIndex.class),
                CommonUtils.stringConcat(
                        unitDistrictObject.getProvince(),
                        unitDistrictObject.getCity()
                ),
                new HashSet<>(
                        Collections.singleton(
                                adUnitDistrictTable.getUnitId()
                        )
                ),
                type

        );



    }



    public static  void handlLevel4(AdUnitItTable adUnitItTable,
                                    OpType type){

        if(type==OpType.UPDATE){
            log.error(" no support update");
            return ;
        }

         AdUnitObject adUnitObject =   DataTable.of(AdUnitIndex.class).get(
                adUnitItTable.getUnitId()
        );

        if(null==adUnitObject){
            log.error("this unitid is invalidate");
            return;
        }

        UnitItObject unitItObject = new UnitItObject(
                adUnitItTable.getUnitId(),
                adUnitItTable.getItTag()
        );

        handleBinLongEvent(
                DataTable.of(UnitItIndex.class),
                unitItObject.getItTag(),
                new HashSet<>(
                        Collections.singleton(
                                unitItObject.getUnitId()
                        )
                ),
                type

        );

    }


    public static  void handllevel4(AdUnitKeywordTable adUnitKeywordTable,
                                    OpType type){
        if(type==OpType.UPDATE){
            log.error(" no support update");
            return ;
        }

        AdUnitObject adUnitObject = DataTable.of(AdUnitIndex.class).
                get(adUnitKeywordTable.getUnitId());

        if(null==adUnitObject){
            return;
        }

        UnitKeyWordObject unitKeyWordObject = new UnitKeyWordObject(
                adUnitKeywordTable.getUnitId(),
                adUnitKeywordTable.getKeyword()
        );

        handleBinLongEvent(
                DataTable.of(UnitKeyWordIndex.class),
                unitKeyWordObject.getKeyword(),
                new HashSet<>(
                        Collections.singleton(
                                unitKeyWordObject.getUnitId()
                        )
                ),
                type
        );
    }







    private static <K,V> void handleBinLongEvent(
            IndexAware<K,V> index,
            K key,
            V value,
            OpType type
    ){

        switch (type){
            case ADD:
                index.add(key, value);
                break;
            case UPDATE:
                index.update(key, value);
                break;
            case DELETE:
                index.delete(key, value);
                break;
            default:
                break;
        }

    }
}
