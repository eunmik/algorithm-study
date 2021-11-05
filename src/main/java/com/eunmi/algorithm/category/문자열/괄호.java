package com.eunmi.algorithm.category.문자열;

//https://www.acmicpc.net/problem/9012

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 푼 날짜 : 2021-11-05
 * 푼 시간 : 12분!!
 */
public class 괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 테스트 데이터 개수

        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            System.out.println((isVPS(st.nextToken())?"YES":"NO"));
        }

    }

    public static boolean isVPS(String parenthesis){
        Stack s = new Stack<>();
        char[] array = parenthesis.toCharArray();
        for(char c : array){
            if(s.isEmpty()){
                s.push(c);
            }else if(s.peek().equals('(') && c == ')' ) {
                s.pop();
            }else {
                s.push(c);
            }
        }
        if(s.isEmpty()) return true;
        return false;
    }
}
