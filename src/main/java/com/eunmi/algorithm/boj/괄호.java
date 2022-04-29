package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9012
 * Hint : Stack
 */
public class 괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for(int i =0; i<N; i++){
            char[] list = br.readLine().toCharArray();
            for(int j =0; j<list.length; j++){
                char item = list[j];
                if(stack.isEmpty()){
                    stack.push(item);
                }else{
                    if(isVPS(item, stack.peek())){
                        stack.pop();
                    }else {
                        stack.push(item);
                    }
                }
            }


            if(stack.isEmpty()){
                sb.append("YES" + "\n");
            }else {
                sb.append("NO" + "\n");
                stack.removeAllElements();
            }

        }
        System.out.println(sb);
    }

    public static boolean isVPS(Character value, Character peek)
    {
        if ((value.equals(')') && peek.equals('('))) {
            return true;
        }
        return false;
    }
}
