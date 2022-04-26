package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/10867
 */
public class 중복빼고정렬하기 {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<Integer>();
        while(st.hasMoreElements()){
            int num = Integer.parseInt(st.nextToken());
            if(!list.contains(num)){
                list.add(num);
            }
        }

        Collections.sort(list);
        Iterator it = list.iterator();
        while(it.hasNext()){
            sb.append(it.next()+" ");
        }
        System.out.println(sb);
    }
}
