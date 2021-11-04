package com.eunmi.algorithm.category.DFS_BFS;

//동빈나 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 특정한 지접의 주변 상,하,좌,우를 살펴본 뒤에 주변 지점 중에서 값이 '0'이면서 아직 방문하지 않은 지점이 있다면 해당 지점을 방문한다.
 * 2. 방문한 지점에서 다시 상,하,좌,우를 살펴보면서 방문을 진행하는 과정을 반복하여, 연결된 모든 지점을 방문할 수 있다.
 * 3. 모든 노드에 대하여 1~2번의 과정을 반복하며, 방문하지 않은 지점의 수를 카운트한다.
 4 5
 00110
 00011
 11110
 00000
 *
 *
 * */
public class 음료수얼려먹기 {
    public static int n, m;
    public static int[][] graph = new int[1000][1000];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    //DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y){
        if(x <= -1 || y <= -1 || x >=m || y>=m) {
            return false;
        }
        if(graph[x][y] == 0) {
            graph[x][y] = 1;
            for(int i =0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                    dfs(nextX, nextY);
                }
            return true;
        }
        return false;

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine(),"");
            String flag = st.nextToken();
            for(int j=0; j<m; j++){

                graph[i][j] = flag.charAt(j) - '0';
            }
        }

        //모든 노드에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
