package com.eunmi.algorithm.practices.SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/15653
public class MarbleEscape4 {
    static class Ball {
        int redR, redC, blueR, blueC, cnt;

        public Ball() {

        }

        public Ball(int redR, int redC, int blueR, int blueC, int cnt) {
            super();
            this.redR = redR;
            this.redC = redC;
            this.blueR = blueR;
            this.blueC = blueC;
            this.cnt = cnt;
        }

    }

    static int N, M;
    static char[][] map;
    static boolean[][][][] visit;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static Ball ball;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ball = new Ball();
        visit = new boolean[N][M][N][M];
        map = new char[N][M];


        for(int i=0 ; i< N; i++ ){
            String str = br.readLine();
            for(int j=0; j< M; j++){
                if(str.charAt(j) == 'R'){
                    ball.redR = i;
                    ball.redC = j;
                }else if(str.charAt(j) == 'B'){
                    ball.blueR = i;
                    ball.blueC = j;
                }
                map[i][j] = str.charAt(j);
            }
        }
        bfs();

    }
    public static void bfs(){
        Queue<Ball> q = new LinkedList<>();

        q.add(ball);

        visit[ball.redR][ball.redC][ball.blueR][ball.blueC] = true;

        while(!q.isEmpty()){
            Ball cur = q.poll();

            for(int i=0; i<4; i++){
                int rr = cur.redR, rc = cur.redC, br = cur.blueR, bc = cur.blueC;

                boolean isRedBall = false;
                while(map[rr+dr[i]][rc+dc[i]] != '#'){
                    rr += dr[i];
                    rc += dc[i];
                    if(map[rr][rc]=='O'){
                        isRedBall = true;
                        break;
                    }
                }

                boolean isBlueBall = false;
                while(map[br+dr[i]][bc+dc[i]] != '#'){
                    br += dr[i];
                    bc += dc[i];
                    if(map[br][bc]=='O'){
                        isBlueBall = true;
                        break;
                    }
                }
                if(isBlueBall){
                    continue;
                }
                if(isRedBall){
                    System.out.println(cur.cnt+=1);
                    return;
                }

                if (br == rr && bc == rc) {
                    switch (i) { // ????????????
                        case 0: // ???
                            if (cur.redR > cur.blueR) // red??? ?????? blue?????? ?????? ????????? ???
                                rr++; // ???????????? ?????? ????????? ???
                            else
                                br++;
                            break;
                        case 1: // ???
                            if (cur.redR > cur.blueR)
                                br--;
                            else
                                rr--;
                            break;
                        case 2: // ???
                            if (cur.redC > cur.blueC)
                                rc++;
                            else
                                bc++;
                            break;
                        case 3: // ???
                            if (cur.redC > cur.blueC)
                                bc--;
                            else
                                rc--;
                            break;
                    }
                }

                if(!visit[rr][rc][br][bc]){
                    visit[rr][rc][br][bc] = true;
                    q.add(new Ball(rr, rc, br, bc, cur.cnt+1));
                }
            }
        }
        System.out.println("-1");
    }
}
