package com.eunmi.algorithm.category.DFS_BFS;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 * LEVEL 2
 */

public class 네트워크 {

    public int solution(int n, int[][] computers){
        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i =0; i<n; i++){
            if(!visited[i]) {
                dfs(computers, i, visited);
                result++;
            }

        }

        return result;
    }
    public boolean[] dfs(int[][] computers, int i, boolean[] visited){
        visited[i] = true;

            for(int j = 0; j<computers.length; j++){
                if(i == j) {
                    continue;
                }
                if(!visited[j] && computers[i][j] == 1 && computers[j][i] == 1){
                    visited = dfs(computers, j, visited);
                }
            }
        return visited;

    }

    @Test
    public void 정답() {
        assertEquals(2, solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        assertEquals(1, solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}

