package com.eunmi.algorithm.category.hash;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/42577
//효율성에서 3,4번에서 실패 했다.
public class 전화번호목록_효율성실패 {
 /*
     ["119", "97674223", "1195524421"]	false
     ["123","456","789"]	true
     ["12","123","1235","567","88"]	false
     "1195524421", "97674223", "119" false
     "2", "32" true
  */


    public static void main(String[] args){


        전화번호목록_효율성실패 b = new 전화번호목록_효율성실패();
        //String[] phone_book = {"2", "32"}; //true
        //String[] phone_book = {"123","456","789"}; //true
        String[] phone_book = {"12","123","1235","567","88"};
        System.out.println(b.solution(phone_book));
    }

    public boolean solution(String[] phone_book){
        //1. 오름차순으로 정렬한다.
        List<String> list = Arrays.asList(phone_book);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Map<String, String> map = new HashMap<>();
        for(String p : list){
            if(map.keySet().size() != 0) {
                Iterator it = map.keySet().iterator();
                while(it.hasNext()){
                    String next = it.next().toString();
                    if(p.startsWith(next) || next.startsWith(p)){
                        return false;
                    }
                }
                map.put(p, null);

            }
        }
        return true;
    }

}
