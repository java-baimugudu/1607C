package com.youzan.ad.index.adunit;

import com.youzan.ad.index.IndexAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by baimugudu on 2019/4/2
 * 推广单元：正向索引
 */

@Component
public class AdUnitIndex implements IndexAware<Long,AdUnitObject> {

    private static Map<Long,AdUnitObject> objectMap;

    static {
        objectMap = new ConcurrentHashMap<>();
    }

    @Override
    public AdUnitObject get(Long key) {
        return objectMap.get(key);
    }

    @Override
    public void add(Long key, AdUnitObject value) {
        objectMap.put(key,value);
    }

    @Override
    public void update(Long key, AdUnitObject value) {
        AdUnitObject adUnitObject =  objectMap.get(key);
        if(null==adUnitObject){
            objectMap.put(key,value);
        }else{
            adUnitObject.update(value);
        }


    }

    @Override
    public void delete(Long key, AdUnitObject value) {
        objectMap.remove(key);
    }
}
