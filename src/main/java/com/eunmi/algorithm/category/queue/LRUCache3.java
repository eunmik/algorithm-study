package com.eunmi.algorithm.category.queue;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LRU 캐시를 구현하라.
 * 최대 n개 만큼의 가장 최근에 접근한 데이터를 캐싱하는 LRU(Least Recently Used)
 */
public class LRUCache3 {
    public static void main(String[] args){
        LRUCache3 lruCache = new LRUCache3(3);
        lruCache.query(1);
        lruCache.query(2);
        lruCache.query(3);
        lruCache.query(1);
        lruCache.query(4);
        lruCache.query(5);
        lruCache.query(2);
        lruCache.query(2);
        lruCache.query(1);
        lruCache.print();

    }
    private int cacheSize;
    private Set<Integer> cache;
    public LRUCache3(int cacheSize){
        this.cacheSize = cacheSize;
        this.cache = new LinkedHashSet<>(); //LinkedHashSet은 순서를 보장, 모든 Operation이 O(1)

    }

    //시간 복잡도 O(1)
    private void query(int number){
        if(!cache.contains(number)){
            if(cache.size() == cacheSize){
                Integer firstOne = cache.iterator().next();
                cache.remove(firstOne);
            }
            cache.add(number);
        } else {
            cache.remove(number);
            cache.add(number);
        }

    }


    private void print(){
        System.out.println(cache);
    }

    
}
