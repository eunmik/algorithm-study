package com.eunmi.algorithm.practices.devMatching2021;

import java.util.ArrayList;
import java.util.List;

public class MatrixRotation {
    public static void main(String[] args){
        int row = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,3,6}};
        MatrixRotation m = new MatrixRotation();
        System.out.println(m.solution(row, columns, queries));
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows+1][columns+1];
        List<Integer> list = new ArrayList<>();
        for(int[] query : queries){
            int smallest = 10000;
            for(int i=query[0]; i<=query[2]; i++) {
                if(i==query[0] || i==query[2]){ //제일 첫째줄과 마지막줄
                    for(int j=query[1]; j<=query[3];j++){

                        if (i == query[0] && j == query[1]) { //[2,2] 일 때
                            int value = ((i + 1) - 1) * columns + j;
                            if(value < smallest){
                                smallest = value;
                            }
                            matrix[i][j] = value;

                        } else if (i == query[0]) { //[2,3],[2,4]
                            int value = (i - 1) * columns + (j - 1);
                            if(value < smallest){
                                smallest = value;
                            }
                            matrix[i][j] = value;

                        } else if (i == query[2] && j == query[3]) { //[5,4]
                            int value = ((i - 1) - 1) * columns + j;
                            if(value < smallest){
                                smallest = value;
                            }
                            matrix[i][j] =  value;

                        } else if (i == query[2]) {//[5,2],[5,3]
                            int value = (i - 1) * columns + (j + 1);
                            if(value < smallest){
                                smallest = value;
                            }
                            matrix[i][j] = value;
                        }
                    }
                }else{
                    int j =query[1];
                    while(j<=query[3]){

                        if (j == query[1]) { //[3,2], [4,2]
                            int value = ((i + 1) - 1) * columns + j;
                            if(value < smallest){
                                smallest = value;
                            }
                            matrix[i][j] = value;

                        } else if (j == query[3]) { //[3,4], [4,4]
                            int value =  ((i - 1) - 1) * columns + j;
                            if(value < smallest){
                                smallest = value;
                            }
                            matrix[i][j] = value;
                        }
                        j++;
                    }
                }
                list.add(smallest);
            }
        }
        int[] answer = {};
        return answer;
    }
}
