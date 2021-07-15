package com.eunmi.algorithm.category.heap;

import java.util.PriorityQueue;

public class Scoville {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42626
     * 런타임 에러.... -> 제한사항에 대한 코드가 없을떄
     *
     * scoville의 길이는 2 이상 1,000,000 이하입니다.
     * K는 0 이상 1,000,000,000 이하입니다.
     * scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
     * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
     */
    public static void main(String[] args){
        Scoville s = new Scoville();
        //int[] scoville = {1, 2, 3, 9, 10, 12};
        int[] scoville = {0, 0};
        int answer = s.solution(scoville, 2);
        System.out.println(answer);

    }
    public int solution(int[] scoville, int K){

        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        //제한사항
        for(int i =0; i < scoville.length; i++){ //scoville의 원소는 각각 0 이상 1,000,000 이하이다.
            if(scoville[i] < 0 || scoville[i] > 1000000) return -1;
        }

        if(2 > scoville.length || scoville.length > 1000000 || K > 1000000000 || K < 0 ){ //scoville의 길이는 2 이상 1,000,000 이하이다, K는 0이상 1,000,000,000 이하이다.
            return -1;
        }
        for(int s:scoville){ //heap에 집어 넣는다
            minHeap.offer(s);
        }

        while(minHeap.peek()<K) //가장 맵지 않은 음식의 스코빌 지수 K보다 작을 동안
        {

            int afterMix = minHeap.poll() + (minHeap.poll() * 2);   //scoville 방식 가장 맵지 않은 음식의 스코빌 지수 + (두번재로 맵지 않은 음식의 스코빌 지수 * 2)
            if(minHeap.isEmpty() && afterMix < K){ //모든 음식의 스코빌 지수를 K 이상으로 만들 수 없을 때
                return -1;
            }
            minHeap.offer(afterMix);
            answer++;
        }

        return answer;
    }
}
