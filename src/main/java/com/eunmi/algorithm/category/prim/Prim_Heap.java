package com.eunmi.algorithm.category.prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Prim_Heap {
    public static void main(String[] args){
        int N = 5; //정점의 갯수
        List<Edge>[] graph = new ArrayList[N]; //정점 간 가중치 저장
        boolean[] visited = new boolean[N]; //정점 방문 여부
        int[] minWeight = new int[N]; //정점에 도착할 수 있는 가장 작은 가중치

        for(int i =0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        //값 초기화, 모두 정수 최대값으로 초기화, 최대값을 경우 길이 없다는 것을 의미
        Arrays.fill(minWeight, Integer.MAX_VALUE);


        //가중치 추가
        graph[0].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 3));
        graph[0].add(new Edge(3, 5));
        graph[3].add(new Edge(0, 5));
        graph[1].add(new Edge(2, 4));
        graph[2].add(new Edge(1, 4));
        graph[1].add(new Edge(3, 4));
        graph[3].add(new Edge(1, 4));
        graph[2].add(new Edge(4, 2));
        graph[4].add(new Edge(2, 2));
        graph[3].add(new Edge(4, 1));
        graph[4].add(new Edge(3, 1));


        //힙으로 구현된 우선순위 큐
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(0,0)); //0번 정점을 장분하기 위해 필요한 가중치는 0

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int destination = edge.destination;
            if(!visited[destination]){ //방문하지 않은 정점일 경우
                visited[destination] = true;
                minWeight[destination] = edge.weight; //최소 가중치 저장
                for(int i =0; i<graph[destination].size(); i++){
                    Edge next = graph[destination].get(i);
                    if(minWeight[next.destination] == Integer.MAX_VALUE){
                        pq.add(next);
                    }
                }
            }
        }
        int sumWeight = 0; //가중치의 합 초기화
        for(int i : minWeight){
            sumWeight += i;
        }
        System.out.println("MST를 만드는 최소 가중치 값: "+sumWeight);

    }

    static class Edge implements Comparable<Edge>{
        int destination;
        int weight;
        public Edge(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e1){ //가중치가 작은 순서대로 정렬
            return Integer.compare(this.weight, e1.weight);
        }
    }
}
