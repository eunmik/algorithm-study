package com.eunmi.algorithm.category.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 푼 날짜 : 2021-12-24
 */
//https://programmers.co.kr/learn/courses/30/lessons/42578
public class 위장 {
    public static void main(String[] args) {
        위장 a = new 위장();
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        //String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
                System.out.println(a.solution(clothes));
    }

    public int solution(String[][] clothes){
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        for(String[] c : clothes){
            map.put(c[1], map.getOrDefault(c[1], 0)+1);
        }
        if(map.size() > 1) {
            result = 1;
            for(int i : map.values()) {
                result = result * (i+1);
            }

        }

        return result-1;
    }
}
