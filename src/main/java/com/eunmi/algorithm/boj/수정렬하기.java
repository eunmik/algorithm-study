package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    https://www.acmicpc.net/problem/2750
 */
public class 수정렬하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for(int i =0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            array[i] = num;
        }
        Arrays.sort(array);

        for(int i : array){
            System.out.println(i);
        }

    }
}