package com.eunmi.algorithm.practices.일요일스터디.A210905;

import java.util.Stack;

/**
 * 푼 날짜: 2021-09-02
 * 푼 시간: 너무 오래걸려서 의미없다~~
 * 출처 : https://bangu4.tistory.com/221
 */
public class 큰수만들기_재도전 {
    public static void main(String[] args){
        큰수만들기_재도전 z = new 큰수만들기_재도전();
        System.out.println(z.solution("1924", 2));
        //System.out.println(z.solution("1231234" , 3)); //3234
//        System.out.println(z.solution("4177252841" , 4)); //775841
//        System.out.println(z.solution("1231234" , 3)); //3234
//        System.out.println(z.solution("1924" , 2)); //94
//        System.out.println(z.solution("4177252841", 4)); //775841
//        System.out.println(z.solution("4177252841", 8)); //84
//        System.out.println(z.solution("19241924" , 6)); //94
//        System.out.println(z.solution("87654321" , 3)); //87654
//        System.out.println(z.solution("18765432" , 3)); //87654
//        System.out.println(z.solution("99991" , 3)); //99
//        System.out.println(z.solution("11119" , 3)); //19
        System.out.println(z.solution("999" , 2)); //9
//        System.out.println(z.solution("99999999999999999" , 9));
    }
    public String solution(String number, int k){
        int count = k;
        char[] number_array = number.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i<number_array.length){
            char num = number_array[i];
            while(!stack.isEmpty() && num > stack.peek() && count-- > 0){
                stack.pop();
            }
            stack.push(num);
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        return sb.toString().substring(0, number.length()-k);
    }

}
