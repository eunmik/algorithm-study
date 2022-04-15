package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10815
 */
public class 숫자카드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i< N; i++){
            map.put(st.nextToken(), 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            if (map.containsKey(st.nextToken())) {
                sb.append(1 +" ");
            }else {
                sb.append(0 +" ");
            }
        }
        System.out.println(sb);
    }
    
}
