package com.eunmi.algorithm.practices.a210614;

//https://programmers.co.kr/learn/courses/30/lessons/70128
public class DotProduct {
    public static void main(String[] args){
        DotProduct dp = new DotProduct();
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        System.out.println(dp.solution(a, b));
    }
    public int solution(int[] a, int[] b){
        int answer = 0;

        for(int i=0; i<a.length; i++){
            answer += a[i]*b[i];
        }
        return answer;
    }
}
