package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1920
 */
public class 수찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, 0);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<M; i++){
            int checkNumber = Integer.parseInt(st.nextToken());
            if(map.containsKey(checkNumber)){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }


    }


}
