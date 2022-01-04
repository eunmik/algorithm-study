package com.eunmi.algorithm.category.heap;

import java.util.*;

/**
 * 푼 날짜 : 2022-01-04
 */
public class 더맵게 {
    public static void main(String[] args) {
        더맵게 a = new 더맵게();
//        int[] scoville = {1, 2, 3, 9, 10, 12};
//        int K = 7;
        int[] scoville = {1,1};
        int K = 3;
        System.out.println(a.solution(scoville, K));
    }
    public int solution(int[] scoville, int K) {
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        /**
         * 1. 가장 맵지 않는 지수를 찾기 위해 오름차순 정렬을 해준다.
         * 2. 가장 첫번째와 그다음 번 째 음식으로 스코빌 지수를 구한다.
         * 3. 다시 정렬을 하고 첫번째 지수가 K 미만이면 1번부터 다시 반복한다.
         */
        PriorityQueue<Integer> queue = new PriorityQueue();
        int cnt = 0;
        for(int s : scoville){
            queue.add(s);
        }
        if(queue.contains(0)){
            return -1;
        }
        while(!queue.isEmpty() && queue.peek() < K && queue.size() > 1){
            cnt++;
            int mixed = queue.poll() + (queue.poll() * 2);
            queue.add(mixed);

        }
        if(queue.peek() < K){
            return -1;
        }
        return cnt;

    }

}
