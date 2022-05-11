package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1037
 * 약수는 영어로 divisor
 */
public class 약수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] divisor = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<N; i++){
            divisor[i] = Integer.parseInt(st.nextToken());
        }

        int result = divisor[0] * divisor[N-1];
        System.out.println(result);
    }
}
