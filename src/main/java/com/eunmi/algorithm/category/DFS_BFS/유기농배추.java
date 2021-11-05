package com.eunmi.algorithm.category.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 푼 날짜 : 2021-11-04
 * 푼 시간 :
 * 동빈나 문제 얼음 얼리기랑 비슷 한 듯
 */

//https://www.acmicpc.net/problem/1012
public class 유기농배추 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        while(T>0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); //배추 밭의 가로길이
            N = Integer.parseInt(st.nextToken()); //배추 밭의 세로길이
            int K = Integer.parseInt(st.nextToken()); //심어져있는 배추 개수
            int cnt = 0;
            map = new int[M][N];
            visited = new boolean[M][N];
            for(int i =0; i<K; i++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for(int i =0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(dfs(i, j)){
                        cnt+=1;
                    }
                }
            }

            System.out.println(cnt);
            T--;

        }

    }

    public static int M, N;
    public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] map;

    public static boolean dfs (int x, int y){
        if(x >= M || y >= N || x<= -1 || y <= -1){
            return false;
        }
        if(map[x][y] == 1){
            map[x][y] = 0;
            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                dfs(nextX,nextY);
            }
            return true;
        }
        return false;

    }
}
