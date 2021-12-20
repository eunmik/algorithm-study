package com.eunmi.algorithm.category.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LRU 캐시를 구현하라.
 * 최대 n개 만큼의 가장 최근에 접근한 데이터를 캐싱하는 LRU(Least Recently Used)
 */
public class LRUCache {
    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(3);
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
    private Deque<Integer> cache;
    public LRUCache(int cacheSize){
        this.cacheSize = cacheSize;
        this.cache = new LinkedList<>();
    }

    //캐시(Queue)안에 들어있는 데이터를 조회거나 삭제할 떄 O(N)이 소요된다.
    //시간 복잡도 = O(N)
    //contains() = O(N), size() = O(1), addFirst() = O(1), remove() = O(N)
    //적절한 솔루션이 아니다.
    private void query(int number){
        if (!cache.contains(number)) {
            if( cache.size() == this.cacheSize){
                cache.removeLast();
            }
            cache.addFirst(number);
        } else {
            cache.remove(number);
            cache.addFirst(number);
        }
    }
    private void print(){
        System.out.println(cache);
    }

}
