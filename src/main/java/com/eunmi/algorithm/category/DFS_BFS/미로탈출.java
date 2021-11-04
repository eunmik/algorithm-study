package com.eunmi.algorithm.category.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//동빈나 문제

/**
 5 6
 101010
 111111
 000001
 111111
 111111
 *
 * BFS는 시작 지점에서 가까운 노드부터 차례대로 모든 노드를 탐색한다.
 * 상, 하, 좌, 우로 연결된 모든 노드로의 거리가 1로 동일하다.
 * 따라서 (1,1) 지점부터 BFS를 수행하여 모든 노드의 최단 거리 값을 기록하면 해결 할 수 있다.
 *
 */
public class 미로탈출 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String monster = st.nextToken();
            for(int j=0; j<M; j++){
                map[i][j] = monster.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));


    }

    public static int N, M;
    public static int[][] map;
    public static int[] dy = {0, 0, 1, -1};
    public static int[] dx = {-1, 1, 0, 0};
    public static boolean[][] visited;

    public static int bfs(int x, int y){
        int result = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y, 1});
        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            int cnt = current[2];
            if(currentX == N-1 && currentY == M-1){
                result = Math.min(result, cnt);
            }
            for(int i =0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX >= N || nextY >= M || nextX <= -1 || nextY <= -1){
                    continue;
                }else if(map[nextX][nextY] == 1){
                    map[nextX][nextY] = 0;
                    q.offer(new int[]{nextX, nextY, cnt+1});
                }
            }
        }
        return result;
    }


}
