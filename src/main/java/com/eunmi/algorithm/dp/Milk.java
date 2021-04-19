package com.eunmi.algorithm.dp;

/* https://www.acmicpc.net/problem/14720 */
public class Milk {
    public static void main(String[] args){
        Milk m = new Milk();
        int[] stores = {0,1,2,0,1,2,0};
        System.out.println(m.solution(7, stores));
    }
    public int solution(int size, int[] stores){
        int[][] map = new int[size][3];

        for(int i=0; i<stores.length; i++) {

            if (stores[i] == 0 && i ==0) { // 딸기우유면
                map[i][0] += 1;
            } else if (stores[i] == 1) {//초코우유면
                map[i][1] += map[i - 1][0]+1;
            } else if (stores[i] == 2) {
                map[i][2] += map[i - 1][1]+1;
            } else if (stores[i] ==0 && i !=0 ){
                map[i][0] += map[i-1][2]+1;
            }
        }
        int answer = 0;
        int prev = 0;
        for(int i : map[size-1]){
            answer = Math.max(i, prev);
            prev = answer;
        }
        return answer;
    }
}
