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
        List<Integer> prime_list = sieve(1000000);
        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                break;
            }

            int a = 0, b = 0;
            int n = 0;

            for(int i =0; i<prime_list.size()/2; i++){
                int num1 = prime_list.get(i);
                for(int j =i+1; j<prime_list.size()/2; j++){
                    int num2 = prime_list.get(j);
                    int total = num1 + num2;
                    if(total == num){
                            a = num1;
                            b = num2;
                            n = num2 - num1;
                            break;
                    }
                }
                if(n > 0){
                    break;
                }
            }
            System.out.println(num +" = "+a+" + "+b);


        }
    }

    static List<Integer> sieve(int n){
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
        return prime_number;
    }
}
