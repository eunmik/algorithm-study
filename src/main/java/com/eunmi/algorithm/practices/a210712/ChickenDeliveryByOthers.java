package com.eunmi.algorithm.practices.a210712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15686
public class ChickenDeliveryByOthers {
    static int M, N;
    static int[][] map;
    static List<House> chickens;
    static List<House> houses;
    static Stack<House> selectChicken;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M + 1][M + 1];

        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        selectChicken = new Stack<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    houses.add(new House(i, j));
                } else if (map[i][j] == 2){
                    chickens.add(new House(i, j));
                }
            }
        }
        select(0, 0);
        System.out.println(minDist);

    }

    static void select(int start, int count){
        if(count == N){
            calcDist();
            return;
        }

        for(int i=start; i < chickens.size(); i++){
            selectChicken.push(chickens.get(i));
            select(i + 1, count + 1);
            selectChicken.pop();
        }

    }

    static void calcDist(){
        int sum = 0;
        for (House house : houses){
            int min = Integer.MAX_VALUE;
            for (House chicken : selectChicken) {
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                min = Math.min(min, dist);
            }
            sum += min;

            if(sum > minDist){
                return;
            }
        }
        minDist = Math.min(sum, minDist);
    }

    static class House {
        int x;
        int y;

        public House(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

