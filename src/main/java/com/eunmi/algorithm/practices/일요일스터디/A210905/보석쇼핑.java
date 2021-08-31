package com.eunmi.algorithm.practices.일요일스터디.A210905;

import java.util.*;

/**
 * 푼 날짜: 2021-08-31
 * 푼 시간: 09:10~10~30 1h 20분, 정확성은 통과했는데 효율성 대 실패!!
 */
//https://programmers.co.kr/learn/courses/30/lessons/67258
public class 보석쇼핑 {
    public static void main(String[] args){
        보석쇼핑 j = new 보석쇼핑();
        //String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
//            String[] gems = {"AA", "AB", "AC", "AA", "AC" };
        //String[] gems = {"XYZ", "XYZ", "XYZ" };
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB" };
        int[] result = j.solution(gems);
        for(int i : result){
            System.out.println(i);
        }

    }
    public int[] solution(String[] gems){
        Set<String> gemsSet = new HashSet<>();
        for(String g : gems){
            gemsSet.add(g);
        }

        int[][] r = new int[gems.length][2];
        for(int i =0; i< gems.length; i++){
            Set<String> tmpSet = new HashSet<>();
            Map<String, Integer> map = new HashMap<>();
            for(int j =i; j<gems.length; j++){
                if(map.get("startIndex") == null) {
                    map.put("startIndex", i);
                }
                tmpSet.add(gems[j]);
                if(tmpSet.size() == gemsSet.size()) {
                    map.put("lastIndex", j);
                    break;
                }

            }

            if(map.get("lastIndex") != null){
                r[i][0] = map.get("startIndex")+1;
                r[i][1] = map.get("lastIndex")+1;
            }


        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }

        });
        for(int[] set : r){
            if(set[0] >= 1){
                pq.add(set);
            }

        }

        return pq.poll();
    }

}
