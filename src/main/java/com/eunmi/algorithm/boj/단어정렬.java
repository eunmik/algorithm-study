package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1181
 * 2022.04.21
 */
public class 단어정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        while (N > 0) {
            String word = br.readLine();
            if(!list.contains(word)){
                list.add(word);
            }

            N--;
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    for(int i =0; i<o1.length(); i++){
                        return o1.compareTo(o2); //오름차순으로 정렬
                    }
                }
                return  o1.length() - o2.length();

            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
