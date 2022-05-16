package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또Again {
    static int N;
    static int[] lotto;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            if(N == 0){
                break;
            }
            lotto = new int[N];
            visited = new boolean[N];

            for(int i =0; i<N; i++){
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int index, int depth){
        if(depth == 6){
            for(int i =0; i<N; i++){
                if(visited[i]){
                    sb.append(lotto[i]+" ");
                }
            }
            sb.append("\n");
        }
        for(int i = index; i<N; i++){
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }
}
