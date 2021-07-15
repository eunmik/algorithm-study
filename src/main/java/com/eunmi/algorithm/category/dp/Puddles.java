package com.eunmi.algorithm.category.dp;

/*
* https://programmers.co.kr/learn/courses/30/lessons/42898
 */
public class Puddles {
    public static void main(String[] args){
        Puddles p = new Puddles();
        int[][] puddles = {{3, 2}, {2,4}};
        System.out.println(p.solution(4, 4, puddles));
    }

    public int solution(int m, int n, int[][] puddles){

        int answer = 0;
        int[][] map = new int[n+1][m+1];

        for(int i =0; i<puddles.length; i++ ){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        map[1][1] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j] == -1){ //웅덩이 있는 곳은 0
                    map[i][j] = 0;
                }else if(i==1 && j>1){
                    map[i][j] = map[i][j-1] % 1000000007;
                }else if(i> 1 && j>1){
                    map[i][j] = (map[i][j-1]+map[i-1][j]) % 1000000007;
                }else if(i>1 && j==1){
                    map[i][j] = map[i - 1][j] % 1000000007;
                }

            }
        }
        answer = map[n][m] % 1000000007;
        return answer;
    }
}
