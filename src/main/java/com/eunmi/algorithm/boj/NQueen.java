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
            map[depth] = i;
            if(possible(depth)){
                dfs(depth + 1);
            }
        }
    }

    static boolean possible(int depth){
        for(int i =0; i<depth; i++){

            if(map[depth] == map[i]){ //same row
                return false;
            }

            else if(Math.abs(depth - i) == Math.abs(map[depth] - map[i])){//same diagonal
                //[0,0]의 대각선은 [1,1][2,2],[3,3]
                //y가 1일 때 [0,1,0,0]
                // Math.abs(1 - 0) == Math.abs(map[1] - map[0])
                //[1,2]의 대각선은 [0,1][2,1],[3,0],[2,3]
                //y가 2일 때 [0,2,3,0]
                // Math.abs(2 - 0) != Math.abs(map[2] - map[0])   2 = 3
                // Math.abs(2 - 1) == Math.abs(map[2] - map[1])   1 = 1

                return false;
            }

        }
        return true;
    }
}