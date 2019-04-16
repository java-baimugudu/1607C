package com.youzan.ad.index;

/**
 * Created by baimugudu on 2019/4/2
 */
public interface IndexAware<K,V> {

   V get(K key);
   void add(K key,V value);
   void update(K key,V value);
   void delete(K key,V value);


}
