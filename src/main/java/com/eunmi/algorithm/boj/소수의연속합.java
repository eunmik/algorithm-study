package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * https://www.acmicpc.net/problem/1644
 * Hint : 에라토스테네스의 체
 */
public class 소수의연속합 {

    static int N;
    static boolean prime[] = new boolean[4000001];
    static ArrayList<Integer> prime_numbers = new ArrayList<>();
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        에라토스테네스의체();

        for (int i = 0; i < prime_numbers.size(); i++) {
            int total = 0;
            for (int j = i; j < prime_numbers.size(); j++) {
                total += prime_numbers.get(j);
                if (total == N) {
                    cnt++;
                    break;
                } else if (total > N) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    static void 에라토스테네스의체() {
        //소수는 false
        //1은 수소가 아니므로 제외
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            if (!prime[i]) {
                prime_numbers.add(i);
            }
        }
    }
}
