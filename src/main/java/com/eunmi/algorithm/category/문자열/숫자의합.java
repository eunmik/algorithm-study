package com.eunmi.algorithm.category.문자열;

//https://www.acmicpc.net/problem/11720

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 푼 날짜 : 2021-11-05
 * 푼 시간 : 4분!! 너무 쉬운거 풀었네 히히
 */
public class 숫자의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //숫자의 개수
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        int result = 0;
        String token = st.nextToken();
        for(int i=0; i<N; i++){
            result += token.charAt(i) - '0';
        }

        System.out.println(result);


    }

}
