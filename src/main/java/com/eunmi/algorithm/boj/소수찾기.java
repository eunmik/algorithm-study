package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1978
 */
public class 소수찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num != 1 && num % 2 != 0) {
                cnt++;
            }else if(num == 2){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
