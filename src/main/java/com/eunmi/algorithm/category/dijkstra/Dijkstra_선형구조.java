package com.eunmi.algorithm.category.dijkstra;

/**
 * 아래같은 경우에는 선형 구조로
 * 시간 복잡도가 O(N^2) 이 된다.
 */
public class Dijkstra_선형구조 {
    public static void main(String[] args){
        Dijkstra_선형구조 dijkstra = new Dijkstra_선형구조();
        INF = Integer.MAX_VALUE; //무한대 값
        a = new int[][]{
                {0, 2, 5, 1, INF, INF},
                {2, 0, 3, 2, INF, INF},
                {5, 3, 0, 3, 1, 5},
                {1, 2, 3, 0, 1, INF},
                {INF, INF, 1, 1, 0, 2},
                {INF, INF, 5, INF, 2, 0}
        };
        v = new boolean[number]; //방문한 노드
        d = new int[number]; //거리

        dijkstra(0);
        for(int i = 0; i<number; i++){
            System.out.println(d[i]);
        }
    }
    static int INF;
    static boolean[] v;
    static int[] d;
    static int number = 6;
    static int[][] a;

    //가장 최소 거리를 가지는 정점을 반환
    //현재 남아있는 노드에서 인접한 노드들을 다 확인하여 가장 적은 비용으로 갱신
    public static int getSmallIndex(){
        int min = INF;
        int index = 0;
        for(int i =0; i<number; i++){
            if(d[i] < min && !v[i]){ //방문하지 않은 노드이고 min값보다 비용이 적으면
                min = d[i];  //min값을 갱신한다
                index = i;
            }
        }
        return index;

    }

    //다익스트라를 수행하는 함수
    //특정한 정점에서 부터 (start) 다른 정점으로 가는 최소 비용을 구해주는 함수
    static void dijkstra(int start){
        for(int i =0; i<number; i++){
            d[i] = a[start][i]; //d 배열은 결과적으로 가지는 최소 비용이 담기는 배열 //[0,2,5,1,INF,INF]
        }
        v[start] = true; //시작점을 방문했다고 방문 처리
       for(int i =0; i<number -2; i ++){
           int current = getSmallIndex(); //현재 방문하지 않은 노드 중에서 빠르게 도착할 수 있는 (최소비용인) 노드를 가져온다.
           v[current] = true; //그 노드를 방문 처리
           for(int j =0; j<6; j++){ //그 노드의 인접한 모든 노드를 하나 씩 확인
               if(!v[j]) { //그 노드를 방문하지 않았다면
                   //그 노드 까지의 최소 비용 (d[current]에서 그 노드를 거쳐서 그 노드의 인접한 노드로 가는 비용(a[current][j] 를 더한 값이
                   //현재 그 노드로 가는 최소 비용d[j]보다 더 작다면 갱신
                   if(a[current][j] != INF&& d[current] + a[current][j] < d[j]){
                    //TODO INF 값일 때 플러스를 하면 - MIN.VALUE로 바뀜 ㅠㅠ

                       d[j] = d[current] + a[current][j];


                   }
               }
           }
        }
    }
}
