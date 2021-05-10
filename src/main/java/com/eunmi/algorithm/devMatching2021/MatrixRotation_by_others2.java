package com.eunmi.algorithm.devMatching2021;

public class MatrixRotation_by_others2 {
    public static void main(String[] args){
        MatrixRotation_by_others2 m = new MatrixRotation_by_others2();
        int row = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,3,6}};
        m.solution(row, columns, queries);
    }
    int[][] map;
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                map[i][j] = (i * columns) + j + 1;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            answer[i] = rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }
        return answer;
    }

    public int rotate(int y1, int x1, int y2, int x2) {
        int rows = y2 - y1 + 1, cols = x2 - x1 + 1;
        int temp = map[y1][x1];
        int min = temp;
        int sy = y1, sx = x1;
        int d = 0, len = 1;

        do {
            map[sy][sx] = map[sy + dir[d][0]][sx + dir[d][1]];
            min = Math.min(min, map[sy][sx]);
            sy += dir[d][0];
            sx += dir[d][1];
            len++;

            if (d % 2 == 0 && len == rows) {
                d++;
                len = 1;
            } else if (d % 2 != 0 && len == cols) {
                d++;
                len = 1;
            }
        } while (!(sy == y1 && sx == x1 + 1));
        map[y1][x1 + 1] = temp;

        return min;
    }
}

