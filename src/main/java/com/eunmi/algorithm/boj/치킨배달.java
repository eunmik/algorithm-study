package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/15686
 */
public class 치킨배달 {
    static class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static List<Location> chickenList;
    static boolean[] visited;
    static List<Location> houseList;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        map = new int[N][N];
        chickenList = new ArrayList<>();
        houseList = new ArrayList<>();


        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 2){
                    chickenList.add(new Location(i, j));
                }else if (num == 1){
                    houseList.add(new Location(i, j));
                }
            }
        }
        visited = new boolean[chickenList.size()];
        dfs(0, 0);
        System.out.println(result);

    }

    static void dfs(int index, int depth) {
        if(depth == M){
            int min = getChickenDistance();
            result = Math.min(min, result);
            return;
        }
        for(int i=index; i<chickenList.size(); i++){
            visited[i] = true;
            dfs(i +1, depth+1);
            visited[i] = false;
        }
    }

    static int getChickenDistance(){
        int result = 0;
        for(int i =0; i<houseList.size(); i++){

            Location house = houseList.get(i);
            int min = Integer.MAX_VALUE;
            for(int j=0; j<chickenList.size(); j++){
                if(visited[j]) {
                    Location chicken = chickenList.get(j);
                    min = Math.min(Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y), min);
                }
            }
            result += min;
        }
        return result;
    }
}
