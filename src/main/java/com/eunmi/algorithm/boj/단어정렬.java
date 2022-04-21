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
                        if (o1.charAt(i) < o2.charAt(i)) {
                            return -1;  //m (61) < t(68) 뒤에 글자가 더 클 때  -1 : 오름차순
                        }else if(o2.charAt(i) < o1.charAt(i)) {
                            return 1;
                        }
                    }
                }
                if(o1.length() < o2.length()){
                    return -1;
                }
                return 0;

            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
