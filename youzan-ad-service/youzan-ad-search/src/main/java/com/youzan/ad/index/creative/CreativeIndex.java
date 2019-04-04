package com.youzan.ad.index.creative;

import com.youzan.ad.index.IndexAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by baimugudu on 2019/4/2
 * 创意：正向索引
 */
@Component
public class CreativeIndex implements IndexAware<Long,CreativeObject> {

    private static Map<Long,CreativeObject> obejctMap;

    static {
        obejctMap = new ConcurrentHashMap<>();
    }

    @Override
    public CreativeObject get(Long key) {
        return obejctMap.get(key);
    }

    @Override
    public void add(Long key, CreativeObject value) {
        obejctMap.put(key,value);

    }

    @Override
    public void update(Long key, CreativeObject value) {
        CreativeObject creativeObject =  obejctMap.get(key);
        if(null==creativeObject){
            obejctMap.put(key,value);
        }else{
            creativeObject.update(value);
        }

    }

    @Override
    public void delete(Long key, CreativeObject value) {
        obejctMap.remove(key);
    }
}
