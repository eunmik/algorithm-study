package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9663
 */
public class NQueen {
    static int N;
    static int cnt;
    static int[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N]; //index = x, value = y ex) map[1] = 3 -> [1, 3]
        cnt = 0;
        dfs(0);
        System.out.println(cnt);


    }
    static void dfs(int depth){
        if(depth == 4){
            cnt++;
            return;
        }

        for(int i =0; i<N; i++){
            //System.out.println("map["+depth+"] = "+map[depth]);
            map[depth] = i;
            if(possible(depth)){
                dfs(depth + 1);
            }
        }
    }

    static boolean possible(int y){
        for(int i =0; i<y; i++){

            if(map[y] == map[i]){ //same row
                System.out.println("map["+y+"] : "+map[y]+" map["+i+"] : "+map[i]);
                return false;
            }

            else if(Math.abs(y - i) == Math.abs(map[y] - map[i])){ //same diagonal
                return false;
            }

        }
        return true;
    }
}
