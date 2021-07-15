package com.eunmi.algorithm.practices.SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13460
 * 입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.
 */
public class MarbleEscape2_BFS {
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
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M][N][M];
        ball = new Ball();
        ball.cnt = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    ball.redR = i;
                    ball.redC = j;
                }
                else if (map[i][j] == 'B') {
                    ball.blueR = i;
                    ball.blueC = j;
                }
            }
        }

        bfs();

    }

    private static void bfs() {
        Queue<Ball> q = new LinkedList<Ball>();
        q.add(ball);
        visit[ball.redR][ball.redC][ball.blueR][ball.blueC] = true;

        while (!q.isEmpty()) {
            Ball cur = q.poll();
            if (cur.cnt >= 10) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                // step 1. 파랑이 먼저 굴려서 확인
                int br = cur.blueR, bc = cur.blueC;
                boolean isBlueHole = false;
                while (map[br + dr[i]][bc + dc[i]] != '#') {
                    br += dr[i];
                    bc += dc[i];

                    if (map[br][bc] == 'O') {
                        isBlueHole = true;
                        break;
                    }
                }

                // step 2. 빨강이 굴리기
                int rr = cur.redR, rc = cur.redC;
                boolean isRedHole = false;
                while (map[rr + dr[i]][rc + dc[i]] != '#') {
                    rr += dr[i];
                    rc += dc[i];

                    if (map[rr][rc] == 'O') {
                        isRedHole = true;
                        break;
                    }
                }

                // 파란이 구멍에 빠졌는지 확인 => 빠지면 안됨
                if (isBlueHole)
                    continue;

                // 빨강만 빠지면 정답
                if (isRedHole) {
                    System.out.println(cur.cnt + 1);
                    return;
                }

                // 파랑 빨강 구슬 위치가 같다면 위치 조정
                if (br == rr && bc == rc) {
                    switch (i) { // 상하좌우
                        case 0: // 상
                            if (cur.redR > cur.blueR) // red이 크면 blue보다 밑에 있다는 뜻
                                rr++; // 더하는게 밑에 있다는 뜻
                            else
                                br++;
                            break;
                        case 1: // 하
                            if (cur.redR > cur.blueR)
                                br--;
                            else
                                rr--;
                            break;
                        case 2: // 좌
                            if (cur.redC > cur.blueC)
                                rc++;
                            else
                                bc++;
                            break;
                        case 3: // 우
                            if (cur.redC > cur.blueC)
                                bc--;
                            else
                                rc--;
                            break;
                    }
                }

                if (!visit[rr][rc][br][bc]) {
                    visit[rr][rc][br][bc] = true;
                    q.add(new Ball(rr, rc, br, bc, cur.cnt + 1));
                }
            }
        }
        System.out.println(-1);
    }



}

