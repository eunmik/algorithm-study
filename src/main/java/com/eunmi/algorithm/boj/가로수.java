package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2485
 * todo 다시풀기 220521
 */
public class 가로수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        int[] distances = new int[N - 1];
        for(int i =0; i<N; i++){
            trees[i] = Integer.parseInt(br.readLine());
        }
        //1. 정렬한다.
        Arrays.sort(trees);
        //2. 나무 사이 간격을 구한다.
        for(int i=0; i<N-1; i++){
            distances[i] = trees[i+1] - trees[i];
        }
        //3. 최대공약수를 구한다. 유클리드 호제법. GCD
        int gcd = 0;
        for(int i =0; i<distances.length; i++){
            gcd = getGCD(gcd, distances[i]);
        }
        //4. 간격마다 트리 심기
        int result = 0;
        for(int i =0; i<distances.length; i++){
            result += (distances[i] / gcd) -1;
        }

        System.out.println(result);

    }
    static int getGCD(int a, int b){
        if(b == 0){
            return a;
        }
        int remainder = a%b;
        return getGCD(b, remainder);

    }
}
