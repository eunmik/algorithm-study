package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1978
 */
public class 소수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num != 1) {
                if (isPrimeNumber(num)) {
                    cnt++;
                }
            }

        }
        System.out.println(cnt);
    }

    static boolean isPrimeNumber(int num) {
        int result = Integer.MAX_VALUE;
        for (int i = 2; i * i <= num; i++) {
            int tmp = num % i;
            result = Math.min(tmp, result);
        }
        if (result != 0) {
            return true;
        }
        return false;
    }
}
