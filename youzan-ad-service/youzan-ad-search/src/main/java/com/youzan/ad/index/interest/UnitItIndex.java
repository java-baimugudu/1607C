package com.youzan.ad.index.interest;

import com.youzan.ad.index.IndexAware;
import com.youzan.ad.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by baimugudu on 2019/4/3
 * 兴趣限制：倒排索引
 */

@Component
@Slf4j
public class UnitItIndex implements IndexAware<String, Set<Long>> {


    private static Map<String, Set<Long>> itTagUnitMap;
    private static Map<Long,Set<String>> unitItTagMap;

    static {
        itTagUnitMap = new ConcurrentHashMap<>();
        unitItTagMap = new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {
        return itTagUnitMap.get(key);
    }

    @Override
    public void add(String key, Set<Long> value) {

        CommonUtils.getorCreate(
                key,
                itTagUnitMap,
                ConcurrentSkipListSet::new
        ).addAll(value);

        value.forEach(
                i->CommonUtils.getorCreate(
                        i,
                        unitItTagMap,
                        ConcurrentSkipListSet::new
                ).add(key)
        );

    }

    @Override
    public void update(String key, Set<Long> value) {

        log.error("no support update");

    }

    @Override
    public void delete(String key, Set<Long> value) {
        CommonUtils.getorCreate(
                key,
                itTagUnitMap,
                ConcurrentSkipListSet::new
        ).removeAll(value);

        value.forEach(
                i->CommonUtils.getorCreate(
                        i,
                        unitItTagMap,
                        ConcurrentSkipListSet::new
                ).remove(key)
        );
    }
}
