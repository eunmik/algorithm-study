package com.eunmi.algorithm.category.greedy;

import java.util.Stack;

public class 큰수만들기_by_others {
    public static void main(String[] args) {
        큰수만들기_by_others a = new 큰수만들기_by_others();
        System.out.println(a.solution("1231234", 3));

    }
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
