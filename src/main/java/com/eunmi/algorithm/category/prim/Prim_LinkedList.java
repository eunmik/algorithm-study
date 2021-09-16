package com.eunmi.algorithm.category.prim;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//인접행렬로 구현한 프림 알고리즘의 시간복잡도는 O(N^2)
public class Prim_LinkedList {
    public static void main(String[] args) {
        int N = 5; //정점의 갯수
        int[][] graph = new int[N][N]; //정점 간 가중치 저장
        boolean[] visited = new boolean[N]; //정점 방문 여부
        int[] minWeight = new int[N]; //정점에 도착할 수 있는 가장 작은 가중치

        //값 초기화, 모두 정수 최대값으로 초기화, 최대값을 경우 길이 없다는 것을 의미
        for (int[] arr :graph){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        Arrays.fill(minWeight, Integer.MAX_VALUE);


        //가중치 추가
        graph[0][2] = 3;
        graph[2][0] = 3;
        graph[0][3] = 5;
        graph[3][0] = 5;
        graph[1][2] = 4;
        graph[2][1] = 4;
        graph[1][3] = 4;
        graph[3][1] = 4;
        graph[2][4] = 2;
        graph[4][2] = 2;
        graph[3][4] = 1;
        graph[4][3] = 1;

        int index = 0; //시작 정점
        minWeight[index] = 0;

        while (index != -1) {
            if (!visited[index]) {
                visited[index] = true;
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && graph[index][i] != Integer.MAX_VALUE) { //방문한 적이 없고 현재 정점에서 간선이 존재할 경우
                        minWeight[i] = Math.min(minWeight[i], graph[index][i]);
                    }
                }
                System.out.println("선택된 정점: " + index);
                System.out.println("현재 정점 별 최솟값: " + Arrays.toString(minWeight));

                index = -1; //아래 for문을 지나도 index가 -1일 경우 갈 수있는 다음 정점이 없음
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && minWeight[i] != Integer.MAX_VALUE) {//방문한 적이 없고 현재 정점으로 갈 수 있는 최소 가중치 값이 존재할 경우
                        if (index == -1) {
                            index = i;
                        } else { //다음 정점이 이미 저장 되어 있는 경우
                            if (minWeight[index] > minWeight[i]) { //index로 선택된 정점과 비교했을 떄 더 작은 가중치를 가질 경우
                                index = i;
                            }
                        }

                    }
                }

                }
            }

    int sumWeight = 0; //가중치의 합 초기화
    for(int i =0; i<N; i++){
        sumWeight += minWeight[i];
    }
        System.out.println("MST를 만드는 최소 가중치 값: "+sumWeight);
    }

}

