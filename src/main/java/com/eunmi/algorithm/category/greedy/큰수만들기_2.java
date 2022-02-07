package com.eunmi.algorithm.category.greedy;

/**
 * 푼 날짜 : 2022-02-07
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 * Level 2
 * Test10번에서 시간초과남 ㅠ
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class 큰수만들기_2 {
    public static void main(String[] args) {
        큰수만들기_2 a = new 큰수만들기_2();
        String name = "4177252841";
        System.out.println(a.solution(name, 4));
    }
    public String solution(String number, int k){
/**
 *
 1 9 2 4

 1 > 9 = false
 1 지우기  cnt ++

 9 2 4

 9 > 2 = true
 다음 숫자로 넘어가기

 2 > 4 = false
 2 지우기   cnt++

  19 == 4
 */
        Stack<Integer> stack = new Stack();
        for(int i = number.length()-1; i >=0; i-- ){
            stack.push(number.charAt(i)-'0');
        }
        int cnt = 0;

        while(cnt < k && !stack.isEmpty()) {
            int top = stack.pop();
            if(top < stack.peek()) {
                top = stack.pop();
                stack.push(top);
                cnt++;
            }else if(top > stack.peek()){
                stack.pop();
                stack.push(top);
                cnt++;
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();


    }
}
