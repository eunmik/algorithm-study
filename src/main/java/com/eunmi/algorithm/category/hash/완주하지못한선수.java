package com.eunmi.algorithm.category.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 푼 날짜 : 2021-12-22
 */
//https://programmers.co.kr/learn/courses/30/lessons/42576
public class 완주하지못한선수 {


    public static void main(String[] args){
        완주하지못한선수 a = new 완주하지못한선수();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

//        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola"};

//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};


        System.out.println(a.solution(participant, completion));
    }

    //시간 복잡도 O(N), 공간 복잡도 O(N)
    public String solution1(String[] participant, String[] completion) {
        Map<String, Integer> completed = new HashMap<>();
        for(String c : completion){
            if(completed.get(c) == null){
                completed.put(c, 1);
            }else {
                completed.put(c, completed.get(c) + 1);
            }
        }
        for(String p : participant){
            if(completed.get(p) == null){
                return p;
            }
            completed.remove(p);
        }
        return null;
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completed = new HashMap<>();
        for(String c : completion){
            if(completed.get(c) == null){
                completed.put(c, 1);
            }else {
                completed.put(c, completed.get(c) + 1);
            }
        }
        for(String p : participant){
            if(completed.get(p) == null || completed.get(p) == 0){
                return p;
            }
            completed.put(p, completed.get(p)-1);
        }
        return null;
    }


}
