package com.eunmi.algorithm.category.graph;

import java.util.Iterator;
import java.util.LinkedList;

//DFS는 싸이클이 있는 경우 반례 유의, BFS는 싸이클 유무 상관 없음
public class Farthest {
    public static void main(String[] args){
        Farthest f = new Farthest();
        int[][] vertices = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(f.solution(6, vertices));
    }
    static int cnt = 0;

    public int solution(int n, int[][] vertices){

        boolean[] visited = new boolean[n+1];
        LinkedList<Integer> list[] = new LinkedList[n+1];
        for(int i=0; i<vertices.length; i++){
            list[i] = new LinkedList<>();
        }
        for(int i =0; i<vertices.length; i++){
            list[vertices[i][0]].add(vertices[i][1]);
        }

        for(int i=1; i<n; i++){
            if(!visited[i]) {
                //DFS(list, i, visited);
                BFS(list, i);
            }
        }

        int answer = cnt;
        return answer;
    }

    public void DFS(LinkedList<Integer> vertices[], int v, boolean[] visited){
        visited[v] = true;

        Iterator i = vertices[v].listIterator();
        if(!i.hasNext()) cnt++;
        if(vertices[v].size()==1 && (int)i.next() < v) cnt++;
        while(i.hasNext()){
            int n = (int)i.next();

            if(!visited[n]){
                DFS(vertices, n, visited);
            }
        }
    }

    public void BFS(LinkedList<Integer> vertices[], int s){
        boolean visited[] = new boolean[vertices.length];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s]=true;
        while(queue.size() != 0){
            s = queue.poll();
            Iterator<Integer> i = vertices[s].listIterator();

            if(!i.hasNext()) cnt++;
            if(vertices[s].size()==1 && i.next() < s) cnt++;

            while(i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
