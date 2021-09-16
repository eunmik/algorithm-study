package com.eunmi.algorithm.category.floydWarshall;

public class floydWarshall {
    public static void main(String[] args){
        number = 4;
        INF = Integer.MAX_VALUE;
        int[][] a = {{0, 5, INF, 8}, {7, 0, 9, INF}, {2, INF, 0, 4}, {INF, INF, 3, 0}};
        floydWarshall(a);
    }
    static int number;
    static int INF;
    static void floydWarshall(int[][] a){
        //결과 그래프를 초기화 한다.
        int[][] d = new int[number][number];
        for(int i =0; i<number; i++){
            for(int j =0; j<number; j++){
                d[i][j] = a[i][j];
            }
        }

        // K = 거쳐가는 노드
        for(int k = 0; k <number; k++){
            for(int i = 0; i<number; i++){
                for(int j = 0; j<number; j++){
                    //X에서 Y로 가는 최소 비용 VS X에서 노드N으로 가는 비용 + 노드N에서 Y로 가는 비용
                    if(d[i][k] != INF && d[k][j] != INF && d[i][k] + d[k][j] < d[i][j]){
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        //결과를 출력
        for(int i =0; i<number; i++){
            for(int j =0; j<number; j++){
                System.out.print(d[i][j] +" ");
            }
            System.out.println();
        }

    }
}
