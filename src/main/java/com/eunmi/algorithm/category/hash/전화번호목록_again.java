package com.eunmi.algorithm.category.hash;

import java.util.Arrays;

/**
 * 푼 날짜 : 2021-12-23
 * 푼 시간 : 17:33~
 */
public class 전화번호목록_again {
    public static void main(String[] args) {
        전화번호목록_again a = new 전화번호목록_again();
        //String[] phone_book = {"119", "97674223", "1195524421"};
        //String[] phone_book = {"123", "456", "789"};
        String[] phone_book = {"12", "123", "1235", "567", "88"};
        System.out.println(a.solution(phone_book));
    }

    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        String prev = null;
        for(String p : phone_book){
            if(prev == null){
                prev = p;
            }else if(prev.startsWith(p)){
                return false;
            }else if(p.startsWith(prev)){
                return false;
            }
            prev = p;

        }
        return true;
    }
}

