package com.eunmi.algorithm.category.hash;

import java.time.LocalDateTime;
import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/42577
public class 전화번호목록 {
 /*
     ["119", "97674223", "1195524421"]	false
     ["123","456","789"]	true
     ["12","123","1235","567","88"]	false
     "1195524421", "97674223", "119" false
     "2", "32" true
  */
    public static void main(String[] args){


        전화번호목록 b = new 전화번호목록();
        //String[] phone_book = {"2", "32"}; //true
        String[] phone_book = {"123","456","789"}; //true
        //String[] phone_book = {"12","123","1235","567","88"}; //false
        long startTime = System.currentTimeMillis();
        System.out.println(b.solution(phone_book));
        long endTime = System.currentTimeMillis();
        System.out.println("elapsed Time : " + (endTime - startTime));
    }

    public boolean solution(String[] phone_book){

        Arrays.sort(phone_book);
        for(int i = 0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }

}
