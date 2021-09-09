package com.eunmi.algorithm.category.dijkstra;

import java.util.*;

/**
 * 우선순위 큐를 사용하여 시간복잡도를 O(N*logN)으로 만들 수 있다.
 */
public class Dijkstra {
    public static void main(String[] args) {
        int V = 5;
        int E  = 6;
        int start = 1;
        adj = new ArrayList[V + 1];
        for(int i = 1; i<=V; i++){
            adj[i] = new ArrayList<>();
        }
        adj[1].add(new Edge(2, 2));
        adj[1].add(new Edge(3, 3));
        adj[2].add(new Edge(3, 4));
        adj[2].add(new Edge(4, 5));
        adj[3].add(new Edge(4, 6));
        adj[5].add(new Edge(1, 1));

        check = new boolean[V + 1];
        dist = new int[V + 1];

        dijkstra(start);
        for(int i = 1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else {
                System.out.println(dist[i]);
            }


        }

    }

    static ArrayList<Edge>[] adj;
    static boolean[] check;
    static int[] dist;

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int destination = edge.destination;
            if(check[destination])
                continue;
            else
                check[edge.destination] = true;
            for(Edge next : adj[destination]) {
                if (dist[next.destination] >= dist[destination] + next.weight) {
                    dist[next.destination] = dist[destination] + next.weight;
                    pq.add(new Edge(next.destination, dist[next.destination]));
                }
            }
        }


    }

    static class Edge implements Comparable<Edge> {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }
}
