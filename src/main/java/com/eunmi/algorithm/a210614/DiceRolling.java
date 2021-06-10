package com.eunmi.algorithm.a210614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14499
public class DiceRolling {
    static int N, M;
    static int[] diceLoc;
    static int order;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[] dir;
    static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        diceLoc = new int[2];
        diceLoc[0] = Integer.parseInt(st.nextToken());
        diceLoc[1] = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dir = new int[order];
        for(int i=0; i<N; i++){
            String str = br.readLine().replaceAll(" ","");;

            for(int j=0; j<M; j++){
                char value = str.charAt(j);
                map[i][j] = Integer.parseInt(String.valueOf(value));
            }
        }
        String str = br.readLine().replaceAll(" ","");
        for(int i=0; i<order; i++){
            dir[i] = Integer.parseInt( String.valueOf(str.charAt(i)));
        }

       dice = new int[]{0,0,0,0,0,0};
        //dice = new int[]{1,2,3,4,5,6};
        solution();
    }

    public static void solution() {
        int i = 0;

        while (true) {
            int rr = diceLoc[0];
            int rc = diceLoc[1];

            switch (dir[i]) {
                case 1:
                    rr += dr[3];
                    rc += dc[3];
                    break;
                case 2:
                    rr += dr[2];
                    rc += dc[2];
                    break;
                case 3:
                    rr += dr[0];
                    rc += dc[0];
                    break;
                case 4:
                    rr += dr[1];
                    rc += dc[1];
                    break;
            }
           getDice(dir[i], rr, rc);
           // getDice(1, rr, rc);
            i++;
            if(i >= order) break;
        }
    }
    public static void getDice(int dir, int rr, int rc){
        int tmp =0;
        if(rr >= N || rc >= M || rc < 0 || rr < 0) {
            return;
        }
        switch(dir){
            case 2 :
                //3,2,6,1,5,4
                /*
                [0] -> [3]
                [3] -> [5]
                [5] -> [2]
                [2] -> [0]
                */
                tmp = dice[3];
                dice[3] = dice[0];
                dice[0] = tmp;

                //3,2,4,1,5,6
                tmp = dice[2];
                dice[2] = dice[5];
                dice[5] = tmp;

                tmp = dice[0];
                dice[0] = dice[5];
                dice[5] = tmp;
                break;

            case 1 : //4,2,1,6,5,3 //오른쪽으로
                /*
                * [0] -> [2]
                * [2] -> [5]
                * [5] -> [3]
                * [3] -> [0]
                *
                * */
                tmp = dice[2];
                dice[2] = dice[0];
                dice[0] = tmp;

                tmp = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;

                tmp = dice[5];
                dice[5] = dice[3];
                dice[3] = tmp;

                break;

            case 3 : //위로
                //5,1,3,4,6,2
                /* [0] -> [1]
                 *  [1] -> [5]
                 *  [4] -> [0]
                 *  [5] -> [4]
                 * */
                tmp = dice[1];
                dice[1] = dice[0];
                dice[0] = tmp;

                tmp = dice[4];
                dice[4] = dice[5];
                dice[5] = tmp;

                tmp = dice[5];
                dice[5] = dice[0];
                dice[0] = tmp;
                break;

            case 4 : //아래로 //2,6,3,4,1,5
                /*
                * [5] -> [1]
                * [1] -> [0]
                * [4] -> [5]
                * [0] -> [4]
                * */

                tmp = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;

                tmp = dice[4];
                dice[4] = dice[5];
                dice[5] = tmp;

                tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = tmp;

                break;


        }

        if (map[rr][rc] == 0) {
            map[rr][rc] = dice[5];
        }
        else if (map[rr][rc] != 0) {
            dice[5] = map[rr][rc];
            map[rr][rc] = 0;
        }
        diceLoc[0] = rr;
        diceLoc[1] = rc;

        System.out.println(dice[0]);

    }

}
