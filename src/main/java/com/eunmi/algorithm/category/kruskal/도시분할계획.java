package com.eunmi.algorithm.category.kruskal;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 푼 날짜 : 2021-09-28
 * 푼 시간 : 17:51~18:22 STOP!! 10:12~10:24 약 40분
 * 알고리즘 : 크루스칼
 */

//https://www.acmicpc.net/problem/1647
public class 도시분할계획 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i =0; i< M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, w));
        }

        int[] set = new int[N + 1];
        for(int i =0; i<N+1; i++){
            set[i] = i;
        }
        int sum = 0;
        Queue<Edge> newPq = new LinkedList<>();
        Edge max = new Edge(0, 0, Integer.MIN_VALUE);
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(!findParent(edge.a, edge.b, set)){
                unionParent(edge.a, edge.b, set);
                sum += edge.w;
                if(max.w < edge.w) {
                    max = edge;
                }

            }
        }

        System.out.println(sum - max.w);
    }



    public static int getParent(int x, int[] parents){
        if(parents[x] == x){
            return x;
        }
        return getParent(parents[x], parents);
    }

    public static void unionParent(int a, int b, int[] parents){
        a = getParent(a, parents);
        b = getParent(b, parents);
        if(a > b){
            parents[a] = b;
        }else {
            parents[b] = a;
        }
    }

    public static boolean findParent(int a, int b, int[] parents){
        a = getParent(a, parents);
        b = getParent(b, parents);
        if(a == b){
            return true;
        }else{
            return false;
        }
    }
    public static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        @Override
        public int compareTo(Edge e1){
            return Integer.compare(this.w, e1.w);
        }
    }
}
