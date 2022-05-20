package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * https://www.acmicpc.net/problem/2661
 * Hint : 백트랙킹
 * Todo 다시 풀기 220520
 */
public class 좋은수열 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backtracking("");

    }
    static void backtracking(String result){
        if (result.length() == N) {
            System.out.println(result);
            //가장 첫번째로 나오는 백트래킹 알고리즘의 결과가 가장 작은 수 이기 때문에
            //최초 출력 후 강제 종료 한다.
            System.exit(0);

        }
        for(int i =1; i<=3; i++){
            if(isGoodSequence(result+i)){
                backtracking(result + i);
            }
        }

    }
    static boolean isGoodSequence(String s){

        int length = s.length() / 2;
        for(int i = 1; i<= length; i++){
            //마지막 1개와 그 앞의 1개의 수가 동일 한지  ex: [3 2 1 2 1] 마지마1과 그 앞의 2가 동일한지
            //마지막 2개와 그 앞의 2개의 수가 동일 한지  ex: [3 2 1 2 1] 마지막 2 1 과 그 앞의 2 1이 동일한지
            if(s.substring(s.length() - i).equals(
                    s.substring(s.length() -2*i, s.length() -i)
            )){
                return false;
            }
        }
        return true;
    }
}
