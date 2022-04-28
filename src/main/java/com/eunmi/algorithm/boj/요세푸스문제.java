package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
 */
public class 요세푸스문제 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int index = K-1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        List<Integer> list = new ArrayList<>();
        for(int i =1; i<=N; i++){
            list.add(i);
        }

        while(list.size() > 1){


            System.out.println("index : "+index);
            sb.append(list.get(index)+", ");
            list.remove(index);

            index = (index + K) -1;
            if(index> list.size()) {
                index = index - list.size();
            }
            if(index == 2 && list.size() == 2) {
                index = 0;
            }
        }
        sb.append(list.get(0) + ">");
        System.out.println(sb);


    }
}
