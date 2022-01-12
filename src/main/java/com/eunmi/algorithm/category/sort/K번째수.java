package com.eunmi.algorithm.category.sort;

import java.util.Arrays;

/**
 * 푼 날짜 : 2022-01-11
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class K번째수 {
    public static void main(String[] args) {
        K번째수 k = new K번째수();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = k.solution(array, commands);
        for(int i : result){
            System.out.print(i +", ");
        }
    }
    public int[] solution(int[] array, int[][] commands){
        int[] result = new int[commands.length];
        int i= 0;
        for(int[] command : commands){
            int[] tmpArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(tmpArray);
            result[i++] = tmpArray[command[2] - 1];
        }
        return result;
    }
}
