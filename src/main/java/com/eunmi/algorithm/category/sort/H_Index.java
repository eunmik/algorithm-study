package com.eunmi.algorithm.category.sort;

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
        System.out.println(h.solution(citations));

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
}
