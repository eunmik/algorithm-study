package com.eunmi.algorithm.category.sort;

import java.util.Arrays;

/**
 * 푼 날짜 : 2022-01-14
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class H_Index {
    public static void main(String[] args) {
        H_Index h = new H_Index();
        //int[] citations = {3, 0, 6, 1, 5}; //3
        int[] citations = {9,7,6,2,1}; //3
        //int[] citations = {9,9,9};
        System.out.println(h.solution2(citations));

    }

    public int solution(int[] citations){

        int result = 0;
        for(int i = 0; i<=citations.length; i++){
            int cnt = 0;
            for(int j = 0; j < citations.length; j++){

                if(citations[j] >= i) {
                    cnt++;
                }
            }
            if(cnt >= i) {
                result = Math.max(result, i);
            }
        }
        return result;
    }
    //다른 사람 풀이
    public int solution2(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
