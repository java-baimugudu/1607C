package com.youzan.ad;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by baimugudu on 2019/4/1
 */
public class Java8Map {
    public Map<String,Object> map1= new HashMap<>();
    public Map<String, AtomicInteger>  map2= new HashMap<>();
    public Map<String, List<String>>  map3= new HashMap<>();
    List<String> list = Lists.newArrayList("1", "2", "3","2","3","2");
    //1、业务逻辑：如果key的value值为null，则在map中放入该key和设置相应的value值
    @Test
    public void testMap1(){
        //java8之前，从map中根据key获取value操作可能会有下面的操作
       Object value =  map1.get("key");
       if(null==value){
           value = new Object();
           map1.put("key",value);
       }else {
           //如果有值的话，执行其他的
       }
       //java8之后，上面的操作可以简化为一行，若key对应的value为空，会将第二个参数的返回值存入并返回
        Object key2 = map1.computeIfAbsent("key1", k -> new Object());
        System.out.println(map1);
    }

    //统计List出现相同字符串的个数
    @Test
    public void  map2() {
        //这里虽然只有一行代码但信息量很大，首先它采用量java的新特性lambda表达式来遍历list集合
        // 这里表示如果map中的key对应的value值为null，则该key对应value值为new AtomicInteger()并执行自增加1，
        // 如果key已经存在，则直接value值自增1
        list.forEach( str-> map2.computeIfAbsent(str, k -> new AtomicInteger()).incrementAndGet());
        System.out.println(map2);        //输出：{1=1, 2=3, 3=2}
    }

    //如果key对应的value不存在，则创建新List并放入数据，存在则往直接往list放入数据
    @Test
    public void  map3() {
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("apple");
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("orange");
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("pear");
        map3.computeIfAbsent("zhangsan", k -> genValue(k)).add("banana");
        map3.computeIfAbsent("lisi", k -> genValue(k)).add("water");

        System.out.println(map3);
        //输出结果：{lisi=[water], zhangsan=[apple, orange, pear, banana]}
    }

    static List<String> genValue(String str){
        return new ArrayList<String>();
    }




}
