package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/6588
 * Hint : 에라토스테네스의 체
 */
public class 골드바흐의추측 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = sieve(1000000);
        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                break;
            }

            for(int i =2; i<=num/2; i++){
                if(!prime[i] && !prime[num-i]){
                    System.out.println(num +" = "+ i +" + "+ (num-i));
                    break;
                }
            }
        }
    }

    static boolean[] sieve(int n){
        boolean prime[] = new boolean[n+1];
        List<Integer> prime_number = new ArrayList<>();
        prime[0] = prime[1] = true;
        for(int i =2; i*i < n; i++){
            if(!prime[i]){
                for(int j = i*i; j<n; j+=i){
                    prime[j] = true;
                }
            }
        }
        for(int i =0; i<n; i++){
            if(!prime[i]) {
                prime_number.add(i);
            }
        }
        return prime;
    }
}
