package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2580
 * Hint :스도쿠의 빈 칸이 존재하면, 그 인덱스를 배열에 저장.
 * 그 자리에 숫자를 놓아보고 놓을 수 있는지 검사후 놓을 수 있으면 다음 빈칸 검사, 놓을 수 없으면 backtracking
 */
public class 스도쿠 {
    static int N;
    static int[][] map;
    static List<int[]> zeros;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 9;
        map = new int[N][N];
        zeros = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 0) { //1. 빈칸이 존재하면
                    zeros.add(new int[]{i, j}); //2. 그 인덱스를 배열에 저장
                }
            }
        }

        dfs(0, 0);
    }
    static void dfs(int x, int y){
        if(y == 9){
            dfs(x + 1, 0);
            return;
        }
        if(x == 9){
            print();
        }
        if(map[x][y] == 0){
            for(int i =1; i<=N; i++) {
                if(possible(x, y, i)){
                    map[x][y] = i;
                    dfs(x, y+1);
                }
            }
            map[x][y] = 0;
            return;
        }
        dfs(x, y+1);


    }
    static void print(){
        for(int i =0; i<N; i++){
            for(int j =0; j<N; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static boolean possible(int x, int y, int num){
        for(int i =0; i<N; i++){ //가로에 존재하는지
            if(map[x][i] == num){
                return false;
            }
        }

        for(int i =0; i<N; i++){ //세로에 존재하는지
            if(map[i][y] == num){
                return false;
            }
        }

        int row = (x / 3) * 3;
        int col = (y / 3) * 3;
        for(int i =row; i<row+3; i++){ //3x3에 존재하는지
            for(int j =col; j<col+3;y++){
                if(map[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
