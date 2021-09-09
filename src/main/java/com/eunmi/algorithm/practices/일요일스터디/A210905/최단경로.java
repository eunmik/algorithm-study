package com.eunmi.algorithm.practices.일요일스터디.A210905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 푼 날짜 : 2021-09-07
 * 푼 시간 : 20:38 ~
 * 문제 유형 : 다익스트라 알고리즘
 */
//https://www.acmicpc.net/problem/1753
public class 최단경로 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        d = new int[V + 1];
        checked = new boolean[V + 1];
        adj = new ArrayList[V+1];
        for(int i =0; i<V+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i =0; i<E; i++){

            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Edge(v, w));

        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<d.length; i++){
            if(d[i] == Integer.MAX_VALUE){
                sb.append("INF\n");
            }else {
                sb.append(d[i]+"\n");
            }

        }
        System.out.println(sb.toString());



    }
    static ArrayList<Edge>[] adj;
    static int[] d;
    static boolean[] checked;
    static void dijkstra(int start){
        Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int destination = current.destination;

            if(checked[destination])
                continue;
            else
                checked[destination] = true;

            for(Edge next : adj[destination]){
                if(d[next.destination] >= d[destination] + next.weight){
                    d[next.destination] = d[destination] + next.weight;
                    pq.add(new Edge(next.destination, d[next.destination]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int destination;
        int weight;

        public Edge(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e1){
            return Integer.compare(this.weight, e1.weight); //Integer.compare(e1.eight, this.weight)를 하니깐 틀렸음. 오름차순, 내림차순 차이
        }

    }
}


