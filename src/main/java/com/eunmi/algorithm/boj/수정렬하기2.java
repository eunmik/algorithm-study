package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/2751
 * Arrays.sort -> 시간초과
 * StringBuilder 안쓰고 그냥 System.out.println 여러번 출력 하면 -> 시간초과
 */
public class 수정렬하기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<Integer>();
        //5,2,3,4,1
        for(int i =0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(Integer i : list){
            sb.append(i+"\n");
        }
        System.out.println(sb);

    }
}
