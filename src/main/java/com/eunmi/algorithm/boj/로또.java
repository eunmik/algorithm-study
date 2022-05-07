package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/6603
 * Hint : 재귀, dfs
 * todo 다시 풀기
 */
public class 로또 {

    static int N;
    static int[] S;
    static StringBuilder sb;
    static int[] result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.MAX_VALUE;
        sb = new StringBuilder();

        while(N != 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            result = new int[N];
            S = new int[N];

            for(int i =0; i<N; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start, int depth){

        if(depth == 6){

            print();
        }
        for(int i = start; i < N; i++){
            result[i] = 1;
            dfs(i + 1, depth + 1);
            result[i] = 0;
        }
    }

    static void print() {
        for(int i =0; i <N; i++){
            if(result[i] == 1){
                sb.append(S[i] + " ");
            }
        }
        sb.append("\n");
    }
}
