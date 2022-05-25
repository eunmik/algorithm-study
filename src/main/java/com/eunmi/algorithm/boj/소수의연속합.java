package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1644
 */
public class 소수의연속합 {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        List<Integer> prevList = new ArrayList<>();
        for(int i =2; i<=N; i++){
            int result = 0;
            List<Integer> list = new ArrayList<>();

            for(int j=i; j<=N; j++){
                if(isPrime(j)){
                    list.add(j);
                    result+= j;
                }
                if(result == N && !prevList.equals(list)){
                    prevList = new ArrayList<>();
                    for(Integer num : list){
                        prevList.add(num);
                    }
                    cnt++;
                    break;
                }
                if(result > N){
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
    static int cnt;


    static boolean isPrime(int num){
        int result = Integer.MAX_VALUE;
        for(int i=2; i*i<=num; i++){

            int remainder = num%i;
            result = Math.min(remainder, result);
        }
        if(result != 0){
            return true;
        }
        return false;
    }
}
