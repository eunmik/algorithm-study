package com.eunmi.algorithm.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* 미쳐.. .너무 어려워... . . */
public class Nnumber {
    public static void main(String[] args){
        Nnumber n = new Nnumber();
        n.solution(5, 12);

    }
    static int _N;
    static List<Integer>[] dp;//메모이제이션

    public static List<Integer> dp(int n){
        if(dp[n] != null) return dp[n];

        dp[n] = new ArrayList<>();
        dp[n].add(dp[n-1].get(0) * 10 + _N);

        for(int i = 1 ; i < n ; i++) {
            int j = n - i;
            List<Integer> dp1 = dp(i);
            List<Integer> dp2 = dp(j);

            for(int n1 : dp1) {
                for(int n2 : dp2) {
                    dp[n].add(n1 + n2);
                    dp[n].add(n1 - n2);
                    dp[n].add(n1 * n2);
                    if(n2 != 0) dp[n].add(n1 / n2);
                }
            }
        }
        return dp[n];
    }


    public int solution(int N, int number) {

        _N = N;
        int answer = -1;

        dp = new ArrayList[10];
        dp[0] = new ArrayList<>(); //격자를 만들어준다.
        dp[0].add(0);

        for(int n = 1 ; n <= 8 ; n++) {
            dp(n);
            if (dp[n].contains(number)) {
                answer = n;
                break;
            }
        }

        return answer;
    }
}
