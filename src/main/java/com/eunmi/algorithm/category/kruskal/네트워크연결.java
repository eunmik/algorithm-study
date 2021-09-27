package com.eunmi.algorithm.category.kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 푼 날짜 : 2021-09-27
 * 푼 시간: 17:36~17:50
 * 알고리즘 : 크루스칼
 */
//https://www.acmicpc.net/problem/1922
public class 네트워크연결 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, w));

        }
        int[] set = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            set[i] = i;
        }

        int sum = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(!findParent(edge.a, edge.b,set)){
                unionParent(edge.a, edge.b, set);
                sum += edge.w;
            }
        }

        System.out.println(sum);

    }

    static int N; //컴퓨터의 수
    static int M; //선의 수

    public static int getParent(int x, int[] parents){
        if(parents[x] == x){
            return x;
        }
        return getParent(parents[x], parents);
    }

    public static void unionParent(int a, int b, int[] parents){
        a = getParent(a, parents);
        b = getParent(b, parents);
        if( a> b){
            parents[a] = b;
        }else{
            parents[b] = a;
        }
    }
    public static boolean findParent(int a, int b, int[] parents){
        a = getParent(a, parents);
        b = getParent(b, parents);
        if( a== b){
            return true;
        }else{
            return false;
        }
    }

    public static class Edge implements  Comparable<Edge>{
        int w;
        int a;
        int b;
        public Edge(int a, int b, int w){
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
