package com.eunmi.algorithm.category.stack_queue;

import java.util.*;

public class Stocks {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42584
     */
    public static void main(String[] args){
        Stocks s = new Stocks();
        int[] prices = {1,2,3,2,3};
        int[] answers = s.solution(prices);
        for(int answer : answers)
            System.out.println(
                answer
            );

    }
    public int[] solution(int[] prices) {
        Stack q = new Stack();
        int[] answer = new int[prices.length];
        int cnt=0;

        for(int i = 0; i < prices.length; i++){ //비교 하기 위해 중첩 for문을 돌린다.
            //cnt++;
            q.push(prices[i]); //q에 넣는다
            for (int j = i+1; j < prices.length; j++) {

                    if (prices[i] <= prices[j]) { //비교가 필요한대상보다 크거나 같으면 q에 넣는ㄷㅏ.
                        cnt++;
                        q.push(prices[j]);
                    } else if (prices[i] > prices[j]) {
                        cnt++;
                        break;
                    }
            }

            answer[i]=cnt;
            q.clear();
            cnt=0;
        }
            return answer;

        }
}