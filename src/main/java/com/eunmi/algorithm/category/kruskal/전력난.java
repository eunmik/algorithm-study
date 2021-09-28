package com.eunmi.algorithm.category.kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 푼 날짜: 2021-09-28
 * 푼 시간: 10:28~ 11:30 약 1시간
 * 알고리즘: 크루스칼
 *
 * 풀 때 주의할 점 :
 * 입력은 여러 개의 테스트 케이스로 구분되어 있다.
 * 입력의 끝에서는 첫 줄에 0이 2개 주어진다.
 * 각 테스트 케이스마다 한 줄에 걸쳐 절약할 수 있는 최대 비용을 출력한다.
 */
//https://www.acmicpc.net/problem/6497
public class 전력난 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); //집의 수
            int M = Integer.parseInt(st.nextToken()); //길의 수
            if(N == 0 && M == 0){
                break;
            }
            PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
            int total = 0;
            for(int i =0; i<M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.add(new Edge(a, b, w));
                total += w;
            }


            int[] set = new int[N];
            for(int i =0; i<N; i++){
                set[i] = i;
            }
            int sum = 0;
            while(!pq.isEmpty()){
                Edge edge = pq.poll();
                if(!findParent(edge.a, edge.b, set)){
                    unionParent(edge.a, edge.b, set);
                    sum += edge.w;
                }
            }


            System.out.println(total - sum);


        }

    }

    public static int getParent(int x, int[] parents){
        if(parents[x] == x ){
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
        }else {
            return false;
        }
    }
    public static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int w;
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

