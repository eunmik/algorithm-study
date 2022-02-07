package com.eunmi.algorithm.category.greedy;

/**
 * 푼 날짜 : 2022-02-07
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 * Level 2
 * Test10번에서 시간초과남 ㅠ
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 큰수만들기 {
    public static void main(String[] args) {
        큰수만들기 a = new 큰수만들기();
        String name = "775841";
        System.out.println(a.solution(name, 4));
    }
    public String solution(String number, int k){
/**
 *
 1 9 2 4

 1 > 9 = false
 1 지우기  cnt ++

 9 2 4

 9 > 2 = true
 다음 숫자로 넘어가기

 2 > 4 = false
 2 지우기   cnt++


 */
        char[] numberArray = number.toCharArray();
        List<Integer> numberList = new ArrayList<>();

        for(char c : numberArray){
            numberList.add(c-'0');
        }

        int cnt = 0;
        int i = 0;
        while(cnt < k && i < numberList.size()) {
            if(i == numberList.size()-1 || i < numberList.size() -1 && numberList.get(i) < numberList.get(i+1) ) {
                numberList.remove(i);
                cnt++;
                i = 0;
            }else {
                i++;
            }
        }
        Iterator it = numberList.iterator();
        StringBuffer sb = new StringBuffer();
        while(it.hasNext()){
            sb.append(it.next());

        }

        return sb.toString();
    }
}
