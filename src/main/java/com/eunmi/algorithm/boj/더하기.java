package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9095
 * Hint : DP
 * Todo 다시 풀기
 */
public class 더하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] array = new int[11];

        while(T > 0){
            int n = Integer.parseInt(br.readLine());
            array[0] = 0;
            array[1] = 1;  // [1]
            array[2] = 2;  // [1+1], [2]
            array[3] = 4;  // [1+1+1], [1+2], [2+1], [3]

            //4 = [1+1+1+1], [1+1+2], [1+2+1], [3+1], [2+1+1], [2+2], [1+3] 7

            for(int i =4; i<=n; i++){
                array[i] = array[i-1] + array[i-2] + array[i-3];
            }
            System.out.println(array[n]);

            T--;
        }
    }

}
