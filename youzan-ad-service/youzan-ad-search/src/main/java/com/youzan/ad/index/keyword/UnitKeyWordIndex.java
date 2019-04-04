package com.youzan.ad.index.keyword;

import com.youzan.ad.index.IndexAware;
import com.youzan.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by baimugudu on 2019/4/2
 * 关键词的限制：倒排索引
 */

@Component
@Slf4j
public class UnitKeyWordIndex implements IndexAware<String, Set<Long>> {

    private static Map<String, Set<Long>> keyWordUnitMap;

    private static Map<Long, Set<String>> unitKeyWordMap;

    static {
        keyWordUnitMap = new ConcurrentHashMap<>();
        unitKeyWordMap = new ConcurrentHashMap<>();
    }


    @Override
    public Set<Long> get(String key) {

        if (StringUtils.isEmpty(key)) {
            return Collections.emptySet();
        }

        Set<Long> set = keyWordUnitMap.get(key);
        if (null == set) {
            return Collections.emptySet();
        }

        return set;
    }

    @Override
    public void add(String key, Set<Long> value) {

        Set<Long> set = CommonUtils.getorCreate(key, keyWordUnitMap,
                ConcurrentSkipListSet::new
        );
        set.addAll(value);

        for (Long unitId : value) {
            Set<String> keyWordSet = CommonUtils.getorCreate(unitId, unitKeyWordMap,
                    ConcurrentSkipListSet::new
            );
            keyWordSet.add(key);

        }


//      Set<Long> set =  keyWordUnitMap.get(key);
//      if(null==set){
//           set =  new ConcurrentSkipListSet<>();
//      }
//      set.addAll(value);
//
//      for(Long unitId:value){
//         Set<String> setStr =  unitKeyWordMap.get(unitId);
//         if(null==setStr){
//             setStr =  new ConcurrentSkipListSet<>();
//         }
//          setStr.add(key);
//      }

    }

    @Override
    public void update(String key, Set<Long> value) {
        log.error("no support update");
    }

    @Override
    public void delete(String key, Set<Long> value) {
        Set<Long> set = CommonUtils.getorCreate(key, keyWordUnitMap,
                ConcurrentSkipListSet::new
        );
        set.removeAll(value);

//        value.forEach(unitId ->  CommonUtils.getorCreate(unitId, unitKeyWordMap,
//                ConcurrentSkipListSet::new
//        ).remove(key));

        for (Long unitId : value) {
            Set<String> keyWordSet = CommonUtils.getorCreate(unitId, unitKeyWordMap,
                    ConcurrentSkipListSet::new
            );
            keyWordSet.remove(key);

        }


    }
}
