package com.eunmi.algorithm.category.binary_search;

import org.junit.Test;

import java.util.Arrays;
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

    public int solution_by_other(int n, int[] times) {
        Arrays.sort(times);
        return (int) find((long) n, times, (long) times.length, times[0], (long) ((long) times[0] * (long) n));
    }

    public long find(long n, int[] times, long nExamination, long from, long to) {
        long minTime;
        long tmp = n;
        if (from == to) {
            return from;
        }
        else {
            minTime = (from + to) / 2;// + ((from + to) % 2 == 1? 1 : 0);
            for (int i = 0; i < nExamination; i++) {
                tmp -=  minTime / (long) times[i];
            }
            if (tmp > 0) {
                return find(n, times, nExamination, minTime + 1, to);
            }
            else {
                return find(n, times, nExamination, from, minTime);
            }
        }

}

    @Test
    public void 정답() {
       // assertEquals(28, solution_by_other(6, new int[]{7,10}));
       // assertEquals(4, solution_by_other(6, new int[]{1,2,3}));
       // assertEquals(1, solution(3, new int[]{1,1,1}));
        assertEquals(2, solution(3, new int[]{1,2,3}));



    }

}
