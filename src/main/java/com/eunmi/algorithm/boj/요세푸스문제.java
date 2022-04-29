package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1158
 1 2 3 4 5 6 7
 1 2 4 5 6 7 [3]
 1 2 4 5 7 [3, 6]
 1 4 5 7 [3, 6, 2]
 1 4 5 [3, 6, 2, 7]
 1 4 [3, 6, 2, 7, 5]
 4 [3, 6, 2, 7, 5, 1]
 [3, 6, 2, 7, 5, 1, 4]

 7 3 <3, 6, 2, 7, 5, 1, 4>

 Hint : Queue
 */
public class 요세푸스문제 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();
        for(int i =1; i<=N; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            for(int i =1; i<=K; i++){
                if(i == K){
                    sb.append(queue.poll() + ", ");
                }else {
                    int tmp = queue.poll();
                    queue.add(tmp);
                }
            }

        }

        sb.replace(sb.lastIndexOf(","), sb.length() , ">");
        System.out.println(sb);


    }
}

