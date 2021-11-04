package com.eunmi.algorithm.category.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2606

/**
 * 푼 날짜 : 2021-11-04
 * 푼 시간 : 30분!!
 *
 * 12%에서 자꾸 틀렸습니다 나옴. -> 양방향인데 list[a].add(b);만 해주고 list[b].add(a);는 안해주어서 틀렸다.
 */
public class 바이러스 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine()); //컴퓨터 수
        M = Integer.parseInt(br.readLine()); //컴퓨터 쌍의 수
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        System.out.println(cnt);

    }

    public static boolean[] visited;
    public static int N, M;
    public static List<Integer>[] list;
    public static int cnt;
    //dfs
    public static void dfs(int start){
        visited[start] = true;
        for(int j : list[start]){
            if(!visited[j]){
                visited[j] = true;
                dfs(j);
                cnt+=1;
            }
        }
    }
}

