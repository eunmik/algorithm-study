package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2609
 */
public class 최대공약수와최소공배수 {
    static List<Integer> divisorN;
    static List<Integer> divisorM;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        List<Integer> divisorsM = getDivisors(N, new ArrayList<>());
        List<Integer> divisorsN = getDivisors(M, new ArrayList<>());

        int result1 = getGreatestCommonFactor(divisorsN, divisorsM);
        System.out.println(result1);


    }

    public static List<Integer> getDivisors(int num, List<Integer> divisors){

        for(int i =2; i*i<=num; i++){
            int tmp = num/i;
            if(tmp != 1 && num%i == 0){
                divisors.add(i);
                return getDivisors(num/i, divisors);
            }else if(tmp == 0){
                divisors.add(i);
            }
        }
        divisors.add(num);
        return divisors;
    }

    public static int getGreatestCommonFactor(List<Integer> divisorsN, List<Integer> divisorsM){
        //Collections.sort(divisorsN);
        //Collections.sort(divisorsM);
        int length = Math.min(divisorsM.size(), divisorsN.size());
        int n = divisorsN.get(0);
        int m = divisorsM.get(0);
        for(int i =1; i< length; i++){
            n = n * divisorsN.get(i);
            m = m * divisorsM.get(i);
            if(n == m){
                return n;
            }
        }
        return 0;

    }

}
