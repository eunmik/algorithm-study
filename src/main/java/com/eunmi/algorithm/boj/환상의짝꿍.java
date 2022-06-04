package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15711
 * Hint : 골드바흐의 추측, 에라토스테네스의 체
 */
public class 환상의짝꿍 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] prime = sieve();
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int num = a + b;
            if (num % 2 == 0 && num >= 4) { //골드바흐의 추측에 따르면 4이상의 짝수는 두 소수의 합으로 이루어진다. 그러므로 4 이상의 짝수는 YES
                sb.append("YES");
            } else if (num < 4) {
                sb.append("NO");
            } else { //홀수 일 때
                boolean isTrue = false;
                for (int i = 2; i < num / 2; i++) {
                    if (!prime[i] && !prime[num - i]) {
                        System.out.println(i + " : " + (num - i));
                        isTrue = true;
                        break;
                    }
                }
                if(isTrue){
                    sb.append("YES");
                }else {
                    sb.append("NO");
                }
            }
            N--;
        }
        System.out.println(sb);
    }

    static boolean[] sieve() {
        int n = 2000000;
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i < n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = true;
                }
            }
        }
        return prime;
    }
}
