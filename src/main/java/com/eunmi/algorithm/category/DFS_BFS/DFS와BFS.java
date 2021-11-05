package com.eunmi.algorithm.category.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 푼 날짜 : 2021-11-05
 * 푼 시간 : 30분..이지만 sort하는 걸 블로그를 찾아 봄 ㅠ
 *
 * 12%에서 틀렸는데 Collections.sort로 해결
 */
//https://www.acmicpc.net/problem/1260
public class DFS와BFS {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //정점 갯수
        int M = Integer.parseInt(st.nextToken()); //간선 갯수
        int V = Integer.parseInt(st.nextToken()); //시작할 정점의 번호

        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        //방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문 하라는 조건....
        //이거 때문에 시간 너무 오래 걸렸다 ㅠㅠ
        for(int i=1; i<N+1; i++){
            Collections.sort(list[i]);
        }

        dfs(V);
        System.out.println();
        bfs(V);
    }

    public static List<Integer>[] list;
    public static boolean[] visited;
    public static void dfs(int V){
        if(!visited[V]) {
            visited[V] = true;
            System.out.print(V+" ");

            for (int i : list[V]) {
                dfs(i);
            }
        }
        return;
    }

    public static void bfs(int V){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(visited, false);
        q.offer(V);
        visited[V] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now+" ");
            for(int next : list[now]){
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

    }
}
