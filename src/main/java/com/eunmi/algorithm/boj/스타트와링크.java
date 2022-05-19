package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14889
 * Todo 다시 풀어보기 22-05-19
 * Hint : 백트랙킹
 */
public class 스타트와링크 {
    static int min;
    static int N;
    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        StringTokenizer st;
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine(),  " ");
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(min);

    }

    static void dfs(int index, int depth){
        if(depth == N / 2 ){
            diff();
        }
        for(int i = index; i < N; i++){
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;

        }
    }

    static void diff(){
        int starTeam = 0;
        int linkTeam = 0;
        for(int i =0; i<N; i++){
            for(int j =i; j<N; j++){
                if(visited[i] && visited[j]) {
                    starTeam += map[i][j];
                    starTeam += map[j][i];
                }else if (!visited[i] && !visited[j]){
                    linkTeam += map[i][j];
                    linkTeam += map[j][i];
                }

            }
        }

        min = Math.min(Math.abs(starTeam - linkTeam), min);

    }
}
