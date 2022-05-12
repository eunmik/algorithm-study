package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1929
 */
public class 소수구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for(int i = M;i<=N; i++){
            if(isPrimeNumber(i)){
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isPrimeNumber(int num){
        int result = Integer.MAX_VALUE;
        for(int i =2; i*i<=num; i++){
            int tmp = num%i;
            result = Math.min(tmp, result);
        }
        if(result != 0){
            return true;
        }
        return false;
    }
}
