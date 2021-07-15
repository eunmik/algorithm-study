package com.eunmi.algorithm.category.sort;

import java.util.Arrays;
public class Locations_by_others {
    public static void main(String[] args) {
        Locations_by_others lbo = new Locations_by_others();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = lbo.solution(array, commands);

        for(int r:result) {
            System.out.println(r);
        }
    }


        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i=0; i<commands.length; i++){
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); //Copies the specified range of the specified array into a new array.

                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }

            return answer;
        }

}
