package com.eunmi.algorithm.category.greedy;

/**
 * 푼 날짜 : 2022-02-03
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 * Level 1
 */
public class 체육복 {
    public static void main(String[] args) {
        체육복 a = new 체육복();
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        System.out.println(a.solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve){
        int j = 0;
        int cnt = 0;
        for(int i =1; i<=n; i++){
            if(j < lost.length && lost[j++] == i) {
                int h = 0;
                while(h < reserve.length){
                    if(reserve[h] == lost[j] -1 || reserve[h] == lost[j] +1){
                        reserve[h] = -1;
                        cnt++;
                        break;
                    }else {
                        h++;
                    }
                }


            }else {
                cnt++;
            }
        }
        return cnt;
    }
}
