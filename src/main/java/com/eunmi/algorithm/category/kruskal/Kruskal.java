package com.eunmi.algorithm.category.kruskal;

import sun.awt.windows.WPrinterJob;

import java.util.*;

public class Kruskal {
    //부모 노드를 가져옴
    static int getParent(int[] parent, int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = getParent(parent, parent[x]);
    }

    //부모 노드를 병합
    static void unionParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a > b){
            parent[a] = b;
        }else {
            parent[b] = a;
        }
    }

    //같은 부모를 가지는 지 확인
    static boolean findParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if( a == b){
            return true;
        }else {
            return false;
        }
    }

    public static class Edge implements Comparable<Edge>{
        int[] node = new int[2];
        int distance;
        public Edge(int a, int b, int distance){
            this.node[0] = a;
            this.node[1] = b;
            this.distance = distance;
        }
        @Override
        public int compareTo(Edge e1){
            return Integer.compare(this.distance, e1.distance);
        }
    }

    public static void main(String[] args){
        int n = 7;
        int m = 11;
//        List<Edge>[] adj = new ArrayList[n];
//        for(int i =0; i<n; i++){
//            adj[i] = new ArrayList<>();
//        }
//
//        adj[1].add(new Edge(1, 7, 12));
//        adj[1].add(new Edge(1, 4, 28));
//        adj[1].add(new Edge(1, 2, 67));
//        adj[1].add(new Edge(1, 5, 17));
//        adj[2].add(new Edge(2, 4, 24));
//        adj[2].add(new Edge(2, 5, 62));
//        adj[3].add(new Edge(3, 5, 20));
//        adj[3].add(new Edge(3, 6, 37));
//        adj[4].add(new Edge(4, 7, 13));
//        adj[5].add(new Edge(5, 6, 45));
//        adj[5].add(new Edge(6, 7, 73));

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 7, 12));
        pq.add(new Edge(1, 4, 28));
        pq.add(new Edge(1, 2, 67));
        pq.add(new Edge(1, 5, 17));
        pq.add(new Edge(2, 4, 24));
        pq.add(new Edge(2, 5, 62));
        pq.add(new Edge(3, 5, 20));
        pq.add(new Edge(3, 6, 37));
        pq.add(new Edge(4, 7, 13));
        pq.add(new Edge(5, 6, 45));
        pq.add(new Edge(6, 7, 73));

        //간선의 비용으로 오름차순 정렬

        //각 정점이 포함된 그래프가 어디인지 저장
        int[] set = new int[n+1];
        for(int i =1; i<n+1; i++){
            set[i] = i;
        }

        int sum = 0;
        for(int i =1; i<m+1; i++){
            Edge edge = pq.poll();
            if(!findParent(set, edge.node[0], edge.node[1])){
                sum += edge.distance;
                unionParent(set, edge.node[0] , edge.node[1]);
            }
        }
        System.out.println(sum);



    }

}
