package com.eunmi.algorithm.practices.a210705;

import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/64061
public class CraneGame {
    public static void main(String[] args){
        CraneGame c = new CraneGame();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(c.solution(board, moves));
    }
    public int solution(int[][] board, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();


        for(int move : moves){

            for(int i=0; i<board.length; i++){
                if(board[i][move-1] != 0){
                    int tmp = board[i][move - 1];
                    board[i][move-1] = 0;
                    if(!stack.isEmpty() && tmp == stack.peek()){
                        stack.pop();
                        answer+= 2;
                    }else {
                        stack.add(tmp);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
