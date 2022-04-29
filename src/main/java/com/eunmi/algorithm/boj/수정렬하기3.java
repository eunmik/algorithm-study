package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 https://www.acmicpc.net/problem/10989
 hint : counting sort
 */
public class 수정렬하기3 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //List<Integer> list = new ArrayList<Integer>();
        int[] array = new int[N];
        for(int i =0; i<N; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        //counting sort
        int[] counting = new int[10001];
        int[] sorted = new int[N];

        for(int i =0; i<N; i++){
            counting[array[i]]++;
        }

        for(int i=1; i<counting.length; i++){
            counting[i] += counting[i - 1];
        }

        for(int i=N-1; i >=0; i--){
            int value = array[i]; //10
            counting[value]--; //9
            sorted[counting[value]] = array[i];

        }

        StringBuilder sb = new StringBuilder();
        for(int i : sorted){
            sb.append(i+"\n");
        }

        System.out.println(sb);


    }

}
