package com.eunmi.algorithm.practices.KaKaoBlind2022;

import java.util.*;

public class 불량이용자 {
    public static void main(String[] args){
        불량이용자 b = new 불량이용자();
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        int[] result = b.solution(id_list, report, 2);
        for(int i : result){
            System.out.println(i);
        }
    }

        public int[] solution(String[] id_list, String[] report, int k){
            //hasMap에 id_list를 key로 넣는다.
            //key값에 report 숫자를 증가 시킨다
            //report[0]를 key 일때 report[1]를 넣어준다.
            //report가 2 일 때 report[0]에 report가 2인 value가 있으면 cnt++
            Map<String, Set<String>> map2 = new LinkedHashMap<>();

            for(String r : report){
                String[] tmp = r.split(" ");
                String user = tmp[0];
                String badUser = tmp[1];
                if(map2.get(badUser) == null) {
                    map2.put(badUser, new HashSet<>());
                }
                map2.get(badUser).add(user);


            }
            Map<String, Integer> email_list = new HashMap<>();

            for(String key : map2.keySet()){
                if(map2.get(key).size() >= k){
                    Set<String> list = map2.get(key);
                    for(String s : list){
                        email_list.put(s, email_list.getOrDefault(s, 0) + 1);
                    }
                }
            }
            int[] result = new int[id_list.length];
            for(int i =0; i<id_list.length; i++){
                if(email_list.get(id_list[i]) != null){
                    result[i] = email_list.get(id_list[i]);
                }
                else {
                    result[i] = 0;

                }
            }
            return result;
        }
}
