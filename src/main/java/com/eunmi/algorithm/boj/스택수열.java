package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1874
 1 + [1]
 2 + [2,1]
 3 + [3,2,1]
 4 + [4,3,2,1]
 4 - [3,2,1] [4]
 3 - [2,1] [4][3]
 5 + [5,2,1]
 6 + [6,5,2,1]
 6 - [5,2,1] [4][3][6]
 7 + [7,5,2,1]
 8 + [8,7,5,2,1]
 8 - [7,5,2,1] [4][3][6][8]
 7 - [5,2,1] [4][3][6][8][7]
 5 - [2,1] [4][3][6][8][7][5]
 2 - [1] [4][3][6][8][7][5][2]
 1 - [4][3][6][8][7][5][2][1]

 */
public class 스택수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = Integer.parseInt(br.readLine());
        int i = 1;
        stack.push(i++);
        sb.append("+" + "\n");
        while(true){
            if(i > N && (stack.isEmpty() || stack.peek() != num)){
                break;
            }

            if(i <= N && (stack.isEmpty() || stack.peek() !=num)){
                stack.push(i++);
                sb.append("+" + "\n");
                //System.out.println("+");
            } else {
                stack.pop();
                sb.append("-" + "\n");
                //System.out.println("-");
                String line = br.readLine();
                if(line == null || line.equals("")){
                    break;
                }
                num = Integer.parseInt(line);
            }
        }

        if(!stack.isEmpty()){
            System.out.println("NO");
        }else {
            System.out.println(sb);
        }


    }
}
