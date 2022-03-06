package com.eunmi.algorithm.category.binary_search;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 푼 날짜 2022.02.23
 * LEVEL 3
 */

import static org.junit.Assert.assertEquals;

public class 입국심사 {
    public long solution(int n, int[] times){
        //n = 6, times = {7,10}
        Map<Integer, Long> map = new HashMap<>();
        for(int i =0; i<times.length; i++){
            map.put(times[i], (long) times[i]);
        }

        return binarySearch(n-times.length, map); //4
    }

    public long binarySearch(int n, Map<Integer, Long> map){
        if(n == 0) {
            long result = 0;
            for(long value : map.values()){
                if(value >= result) result = value;
            }

            return result;
        }
        Iterator<Integer> it = map.keySet().iterator();
        long minTime = Integer.MAX_VALUE;
        int worker = 0;
        while(it.hasNext()){
            int currentWorker = it.next();
            if(map.get(currentWorker)+currentWorker < minTime){
                minTime = map.get(currentWorker)+currentWorker;
                worker = currentWorker;
            }
        }
        map.put(worker, map.get(worker) + worker);
        return binarySearch(n - 1, map);
    }

    @Test
    public void 정답() {
        assertEquals(28, solution(6, new int[]{7,10}));
        assertEquals(4, solution(6, new int[]{1,2,3}));

    }

}
