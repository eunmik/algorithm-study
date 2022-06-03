package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1182
 */
public class 부분수열의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        cnt = 0;
        array = new int[N];
        checked = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        System.out.println(cnt);
    }

    static int cnt;
    static int[] checked;
    static int[] array;
    static int N;
    static int S;

    public static void dfs(int start, int depth, int sum) {
        if (sum == S && depth > 0) {
            cnt++;
        }

        for (int i = start; i < N; i++) {
            checked[i] = 1;
            sum += array[i];
            dfs(i + 1, depth + 1, sum);
            checked[i] = 0;
            sum -= array[i];
        }
    }
}
