package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2661
 * Hint :
 */
public class 좋은수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        sequence = new int[N];
        dfs(0, 0, 1);
        System.out.println(result);
    }
    static int N;
    static int result;
    static int[] sequence;

    static void dfs(int index, int depth, int num){
        if(depth == N){
            for(int i =0; i<N; i++){
                System.out.print(sequence[i]+" ");
            }
            System.out.println();
            if(isGoodSequence()){
                String tmp = "";
                for(int i =0; i<sequence.length; i++){
                    tmp += sequence[i];
                }
                result = Math.min(Integer.parseInt(tmp), result);
            }
            return;
        }
        for(int i = index; i<N; i++){

            if(num > 3) num = 1;
            sequence[i] = num;
            dfs(i+1, i+1, num+1);
            //sequence[i] = 0;
        }
    }

    static boolean isGoodSequence(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<N; i++){
            if(queue.isEmpty()) {
                queue.add(sequence[i]);
            }
            else {
                int size = queue.size();
                while(size > 0) {
                    int top = queue.poll();
                    if (top == sequence[i]) {
                        return false;
                    } else {
                        queue.add(top);
                        size--;
                    }
                }
                queue.add(sequence[i]);
            }
        }
        return true;
    }
}
