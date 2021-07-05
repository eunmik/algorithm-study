package com.eunmi.algorithm.a210705;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/67259
public class RoadBuilding {
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int n;

    public static void main(String[] args){
        RoadBuilding r = new RoadBuilding();
        System.out.println(r.solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
    }
    public int solution (int[][] board){
        int answer = 0;
        n = board.length;
        map = board;

        //초기 방향을 -1로 주는 이유는 시작할 때 오른쪽과 아래로 둘다 이동할 수 있기 때문
        bfs(0, 0, 0, -1);
        answer = min;
        return answer;

    }
    public void bfs(int x, int y, int sum, int dir){
        Queue<Road> q = new LinkedList<>();
        q.add(new Road(x, y, sum, dir));
        map[x][y] = 1; //출발 지점을 1로 바꾸어 탐색에서 제외

        while (!q.isEmpty()) {
            Road temp = q.poll();
            // 목적지에 도착했다면(2,2) 최소비용을 갱신
            if(temp.x == n-1 && temp.y == n-1){
                min = Math.min(min, temp.sum);
                continue;
            }

            for(int i=0; i<4; i++){
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];
                //1이면 벽이기 때문에 가면 안된다.
                if(nextX >= 0 && nextX <n && nextY>=0 && nextY <n && map[nextX][nextY] != 1){
                    int newSum = 0;
                    if(temp.dir == -1 || temp.dir == i){
                        newSum = temp.sum +100;
                    }else {
                        newSum = temp.sum + 600;

                    }
                    //처음 가는 곳인지 판단
                    if(map[nextX][nextY] == 0){
                        map[nextX][nextY] = newSum;
                        q.add(new Road(nextX, nextY, newSum, i));
                    }else if(map[nextX][nextY] >= newSum){
                        map[nextX][nextY] = newSum;
                        q.add(new Road(nextX, nextY, newSum, i));
                    }
                }
            }
        }

    }
    class Road{
        int x,y,sum,dir;
        public Road(int x, int y, int sum, int dir){
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.dir = dir;
        }
    }
}
