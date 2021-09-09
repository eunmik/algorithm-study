package com.eunmi.algorithm.practices.일요일스터디.A210905;

import java.util.*;

/**
 * 푼 날짜 : 2021-08-30
 * 푼 시간 : 14:10~15:20 거의 3h... 언제쯤 시간이 줄어들까나~
 * */

//https://programmers.co.kr/learn/courses/30/lessons/72411
public class 메뉴리뉴얼 {
    public static void main(String[] args){
        메뉴리뉴얼 m = new 메뉴리뉴얼();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] result = m.solution(orders, course);
        for(String r : result){
            System.out.println(r);
        }
    }

    static int most;
    public String[] solution(String[] orders, int[] course) {

        //우선순위 큐를 이용한다.
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int c : course) {
            most = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < orders.length; i++) { //코스요리가 2개일 때, 3개일때, 4개일때 각각 for문을 돌린다.
                getMenu(0, "", c, 0, orders[i], map);
            }

            Iterator<String> it = map.keySet().iterator();

            while (it.hasNext()) {
                String key = it.next();
                if (map.get(key) >= most && most > 1) { //map 안에 있는 메뉴 중에 최대 주문한 갯수인 메뉴만 골라서 큐에 넣어준다. ( 최대 주문한 갯수가 적어도 2개 이상이어야 한다)
                    pq.offer(key);
                }
            }
        }
        String[] result = new String[pq.size()];
        int i =0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll();
        }

        return result;
    }
    //재귀를 사용해서 코스요리 갯수에 맞게 메뉴를 구성한다.
    public static void getMenu(int cnt, String str, int target, int idx, String word, Map<String, Integer> map){
        if(cnt == target) {
            char[] c = str.toCharArray();
            Arrays.sort(c); // "XY" 가 있고 "YX"가 나올 때가 있으니깐 정렬을 해준다.
            str = String.valueOf(c);
            map.put(str, (map.get(str) == null ? 1 : map.get(str) + 1)); //맵에 메뉴를 넣고 기존에 값이 있으면 +1을 더해준다.
            if(most < map.get(str)) { //최대 주문한 갯수를 구한다.
                most = map.get(str);
            }
            return;
        }
        char[] wordArray = word.toCharArray();
        for(int i = idx; i < word.length(); i++){
            getMenu(cnt+1, str+wordArray[i], target, i+1, word, map);
        }
        return;
    }


}
