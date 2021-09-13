package com.eunmi.algorithm.category.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 푼 날짜 : 2021-09-09
 * 꼭 다시 풀어 보기!!! --> 2021.09.13
 */
//https://www.acmicpc.net/problem/1504
public class 특정한최단경로 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken())+1;
        E = Integer.parseInt(st.nextToken())+1;

        list = new ArrayList[N];
        dist = new int[N];
        checked = new boolean[N];
        for(int i = 0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =1; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int V1 = Integer.parseInt(st.nextToken());
        int V2 = Integer.parseInt(st.nextToken());
        int result = 0;
        int min1 = dijkstra(1,V1);
        min1 += dijkstra(V1, V2);
        min1 += dijkstra(V2, N-1);

        int min2 = dijkstra(1, V2);
        min2+= dijkstra(V2, V1);
        min2 += dijkstra(V1, N-1);

        result = Math.min(min1, min2);
        /**
         * INF가 int의 범위를 넘습니다. int의 자릿수를 넘는 부분을 자르고 표현하면 145176241이 되는데 dist 배열에는 그렇게 잘려서 들어가므로 INF와 비교해도 INF를 넘을 수가 없습니다.
         * 그리고 정점 번호가 800번까지 있으니 MAX_V는 최소한 801 이상이 되어야 합니다.
         */
        if(result <=-1 || result >= 801){ // result >= Integer.MAX_VALUE로 했는데 91%에서 실패
            System.out.println(-1);
        }else {
            System.out.println(result);
        }


    }
    static int N;
    static int E;
    static List<Edge>[] list;
    static int[] dist;
    static boolean[] checked;

    static int dijkstra(int start, int end){
        Arrays.fill(dist, Integer.MAX_VALUE);
        //Arrays.fill(checked, false);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, dist[start]));
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int destination = edge.destination;

//            if(checked[destination]){
//               continue;
//            }else {
//                checked[destination] = true;
                for(Edge next : list[destination]){
                    if(dist[next.destination] > edge.weight + next.weight ){
                        dist[next.destination] = edge.weight + next.weight;
                        pq.add(new Edge(next.destination, dist[next.destination]));
                    }
                }
            //}

        }
        return dist[end];

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
            return Integer.compare(this.weight, e1.weight);
        }
    }
}
