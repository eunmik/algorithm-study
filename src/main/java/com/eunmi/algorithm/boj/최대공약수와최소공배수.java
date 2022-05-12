package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2609
 * Hint : 유클리드 호제법 (Euclidean algorithm)
 * 두 수 a,b ∈ Z 이고, r = a mod b (r 은 0<= r <= b, a>= b)
 * a와 b의 최대 공약수가 (a,b)일때 (a,b)의 최대공약수는 (b,r)의 최대 공약수와 같다.
 * GCD(a,b) = GCD(b,r)
 */
public class 최대공약수와최소공배수 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int GCD = 0;
        if(M>= N){
            GCD = getGCD(M, N);
        }else {
            GCD = getGCD(N, M);
        }
        System.out.println(GCD);
        System.out.println(M * N / GCD);
    }

    public static int getGCD(int m, int n){
        if(n==0){
            return m;
        }
        int remainder = m%n;
        if(n != 0){
            return getGCD(n, remainder);
        }
        return 0;
    }



}
