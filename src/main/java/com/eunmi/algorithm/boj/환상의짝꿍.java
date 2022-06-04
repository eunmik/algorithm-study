package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15711
 * Hint : 골드바흐의 추측, 에라토스테네스의 체
 */
public class 환상의짝꿍 {
    static boolean[] prime;
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        sieve();
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int num = a + b;
            if (num % 2 == 0 && num >= 4) { //골드바흐의 추측에 따르면 4이상의 짝수는 두 소수의 합으로 이루어진다. 그러므로 4 이상의 짝수는 YES
                sb.append("YES\n");
            } else if (num < 4) {
                sb.append("NO\n");
            } else { //홀수 일 때
                if(check(num)){
                    sb.append("YES\n");
                }else {
                    sb.append("NO\n");
                }
            }
            N--;
        }
        System.out.println(sb);
    }

    public static boolean check(long x) {
        if (x <= 2_000_000) return !prime[(int) x];

        for (int i = 0; i < list.size(); i++) {
            if (x % list.get(i) == 0) {
                return false;
            }
        }

        return true;
    }

    static void sieve() {
        int n = 2000000;
        prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i < n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = true;
                }
            }
        }
        for(int i =0; i<prime.length; i++){
            if(!prime[i]) {
                list.add(i);
            }
        }

    }
}
