package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueenAgain {
    static int N;
    static int cnt;
    static int[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        cnt = 0;
        dfs(0);
        System.out.println(cnt);

    }

    private static void dfs(int depth){
        if(depth == N){
            cnt++;
            return;
        }
        for(int i =0; i<N; i++){
            map[depth] = i;
            if(possible(depth)){
                dfs(depth+1);
            }
        }

    }

    private static boolean possible(int depth){
        for(int i =0; i<depth; i++){
            if(map[depth] == map[i]){
                return false;
            }

            if(Math.abs(i-depth) == Math.abs(map[depth] - map[i])){
                return false;
            }
        }
        return true;
    }
}
