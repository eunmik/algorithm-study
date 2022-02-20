package com.eunmi.algorithm.category.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피보나치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());

        long[] fibonacciList = new long[91];
        fibonacciList[0] = 0;
        fibonacciList[1] = 1;
        for(int i =2; i<=n; i++){
            fibonacciList[i] = fibonacciList[i-1] + fibonacciList[i-2];
        }
        System.out.println(fibonacciList[n]);
    }


}
