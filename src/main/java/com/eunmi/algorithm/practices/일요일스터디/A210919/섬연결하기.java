package com.eunmi.algorithm.practices.일요일스터디.A210919;

//https://programmers.co.kr/learn/courses/30/lessons/42861

import java.util.PriorityQueue;

/**
 * 푼 날짜 : 2021-09-14
 * 푼 시간 : 16:08~ 16:51 공부했던거라 빨리 풀었땅!!!
 */
public class 섬연결하기 {
    public static void main(String[] args){
        섬연결하기 s =  new 섬연결하기();
        //int n =4;
        //int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}; //4
        int n = 5;
        int[][] costs = {{0, 1, 5},{1, 2, 3},{2, 3, 3},{3, 1, 2},{3, 0, 4},{2, 4, 6},{4, 0, 7}}; //15
        System.out.println(s.solution(n, costs));

    }

    public int solution(int n, int[][] costs) {

        int result = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[n];
        for(int i =0; i<n; i++){
            dist[i] = i;
        }

        for(int i =0; i < costs.length; i++){
            pq.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(!find(dist, edge.node[0], edge.node[1])){
                result += edge.weight;
                unionParent(dist, edge.node[0], edge.node[1]);
            }

        }

        return result;
    }

    static boolean find(int[] set, int a, int b){
        a = getParent(set, a);
        b = getParent(set, b);
        if(a==b){
            return true;
        }else {
            return false;
        }

    }

    static int getParent(int[] set, int x){
        if(set[x] == x){
            return x;
        }
        return set[x] = getParent(set, set[x]);
    }

    static void unionParent(int[] set, int a, int b){
        a = getParent(set, a);
        b = getParent(set, b);
        if( a > b){
            set[a] = b;
        }else {
            set[b] = a;
        }
    }

    static class Edge implements Comparable<Edge>{
        int[] node = new int[2];
        int weight;
        public Edge(int a, int b, int weight){
            this.node[0] = a;
            this.node[1] = b;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e1){
            return Integer.compare(this.weight, e1.weight);
        }
    }



}
