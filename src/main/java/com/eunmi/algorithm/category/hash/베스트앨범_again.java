package com.eunmi.algorithm.category.hash;

import java.util.*;

/**
 * 푼 날짜 : 2021-12-24
 */
//https://programmers.co.kr/learn/courses/30/lessons/42579
public class 베스트앨범_again {
    public static void main(String[] args) {
        베스트앨범_again a = new 베스트앨범_again();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = a.solution(genres, plays);
        for(int r : result){
            System.out.println(r);
        }
    }
    public int[] solution(String[] genres, int[] plays){
        /**
         * 속한 노래가 많이 재생된 장르
         * 장르 내에서 많이 재생된 노래
         * 고유번호가 낮은 노래
         */
        Map<String, List<int[]>> map = new HashMap<>();
        Map<String, Integer> mostListened = new HashMap<>();
        for(int i =0; i<genres.length; i++){
            mostListened.put(genres[i], mostListened.getOrDefault(genres[i], 0) + plays[i]);
            List<int[]> list = map.getOrDefault(genres[i], new ArrayList<>());
            list.add(new int[]{i, plays[i]});
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o2[1] == o1[1]){
                        return 1;
                    }
                    return o2[1] - o1[1];
                }
            });

            map.put(genres[i], list);
        }

        

        return null;

    }
}
