package com.eunmi.algorithm.DFS_BFS;

/*
* https://programmers.co.kr/learn/courses/30/lessons/43162
*
* */
public class Network {

    public static void main(String[] args){
        Network network = new Network();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        network.solution(n, computers);
    }
    public int solution(int n, int[][] computers){

        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++) {
                if(i==j){
                    continue;
                }
                //computers[i][j]
            }
        }

        return answer;
    }
}
