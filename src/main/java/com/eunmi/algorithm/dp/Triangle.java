package com.eunmi.algorithm.dp;

import java.util.Arrays;

public class Triangle {
    /*
        https://programmers.co.kr/learn/courses/30/lessons/43105
    * 제한사항
      삼각형의 높이는 1 이상 500 이하입니다.
      삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
    * */
    public static void main(String[] args){
        Triangle t = new Triangle();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; //30
        int result = t.solution(triangle);
        System.out.println(result);

    }
    public int solution(int[][] triangle){
        /*
        * 7
        * 3 8
        * 8 1 0
        * 2 7 4 4
        * 4 5 2 6 5
        */
        int answer = 0;


        /*
        * 7  0  0 0 0
        * 10 15 0 0 0
        * 18 0 15 0 0
        * 20 0 0 19 0
        * 24 0 0 0 24
        * */
        int[][] copyTriangle = new int[triangle.length][triangle.length];
        copyTriangle[0][0] = triangle[0][0]; //맨 꼭대기 값을 넣어준다.
        for(int i = 1; i<copyTriangle.length; i++){
            copyTriangle[i][0] = copyTriangle[i - 1][0] + triangle[i][0]; //왼쪽 끝 값
            copyTriangle[i][i] = copyTriangle[i - 1][i - 1] + triangle[i][i]; //오른쪽 끝 값
        }

        /*
        * 7  0  0  0  0
        * 10 15 0  0  0
        * 18 16 15 0  0
        * 20 25 20 19 0
        * 24 30 27 26 24
         */
        //위에서부터 수를 비교해서 최대값을 넣어준다.
        for(int i =2; i < triangle.length; i++){
            for(int j=1; j<i; j++){
                copyTriangle[i][j] = Math.max(copyTriangle[i - 1][j - 1], copyTriangle[i - 1][j]) + triangle[i][j];
            }
        }

        int prev = 0;
        for(int i : copyTriangle[triangle.length-1]){
            answer = Math.max(i, prev);
            prev = answer;
        }


        return answer;
    }

    public int solution_by_others(int[][] triangle){

        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();

    }

}
