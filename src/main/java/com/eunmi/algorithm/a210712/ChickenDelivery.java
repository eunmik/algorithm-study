package com.eunmi.algorithm.a210712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15686
public class ChickenDelivery {

    static int[][] map;
    static int Min;
    static int N;
    static int M;
    static List<int[]> chickens, houses;
    static List<int[]> cases; // {{1,2}, {2,3}, {4,5}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); //맵 정보
        N = Integer.parseInt(st.nextToken()); //치킨 집 정보
        Min = Integer.MAX_VALUE;
        map = new int[M+1][M+1];
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        cases = new ArrayList<>();
        for(int i=0; i<M; i++){
            String info = br.readLine().replaceAll(" ","");
            for(int j=0; j<M; j++){
                if(info.charAt(j) == '2'){
                    chickens.add(new int[]{i+1, j+1});
                }
                if(info.charAt(j) == '1'){
                    houses.add(new int[]{i+1, j+1});
                }
               map[i+1][j+1] = Integer.parseInt(String.valueOf(info.charAt(j)));
            }
        }
        //경우의 수 구하기
        boolean[] visited = new boolean[chickens.size()];
        int[] numOfChickens = new int[chickens.size()];
        for(int i =0; i<chickens.size(); i++){
            numOfChickens[i] = i;
        }

        combination(numOfChickens, visited, 0, N);
        bfs();
        System.out.println(Min);
    }
    static void combination(int[] arr, boolean[] visited, int depth, int r){
        if(r==0){
            int[] tmp = new int[N];
            int j = 0;
            for(int i = 0; i < arr.length; i++) {
                if(visited[i] == true){
                    tmp[j] = arr[i];
                    j++;
                    if(j>= N) break;
                }
            }
            cases.add(tmp);
            return;
        }
        if(depth == arr.length){
            return;
        } else {
            visited[depth] = true;
            combination(arr, visited, depth+1, r-1);

            visited[depth] = false;
            combination(arr, visited, depth+1, r);
        }
    }

    /**
     * chicken[1,2], [4,1] 인 경우
     * house [1,4] - chicken[1,2] = 2 <-
     * house [1,4] - chicken[4,1] = 6
     *
     * house [2,1] - chicken[1,2] = 2 <-
     * house [2,1] - chicken[4,1] = 2
     *
     * house [2,3] - chicken[1,2] = 2 <-
     * house [2,3] - chicken[4,1] = 4
     *
     * house [4,4] - chicken[1,2] = 5
     * house [4,4] - chicken[4,1] = 3 <-
     *
     * house [4,5] - chicken[1,2] = 6
     * house [4,5] - chicken[4,1] = 4 <-
     *
     * house [5,4] - chicken[1,2] = 6
     * house [5,4] - chicken[4,1] = 4 <-
     *
     * total = 17
     */
    static void bfs() {

        for (int k = 0; k < cases.size(); k++) {
            int total = 0;
            int[] c = cases.get(k);

            for (int i = 0; i < houses.size(); i++) {
                int[] house = houses.get(i);
                int houseToChicken = Integer.MAX_VALUE;
                for (int j = 0; j < c.length; j++) {
                    int[] chicken = chickens.get(c[j]);
                    int between = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    if (houseToChicken > between) {
                        houseToChicken = between;
                    }
                }
                total += houseToChicken;
            }
            if(total < Min){
                Min = total;
            }
        }

    }




}
