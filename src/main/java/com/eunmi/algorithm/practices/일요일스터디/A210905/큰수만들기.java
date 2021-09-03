package com.eunmi.algorithm.practices.일요일스터디.A210905;

import java.util.*;

/**
 * 푼 날짜: 2021-09-02
 * 푼 시간: 14:20~
 * 테케 1, 11,12 빼고 다 안됨
 */
//https://programmers.co.kr/learn/courses/30/lessons/42883?language=cpp
public class 큰수만들기 {
    public static void main(String[] args){
        큰수만들기 z = new 큰수만들기();

//        System.out.println(z.solution("1231234" , 3)); //3234
//        System.out.println(z.solution("1924" , 2)); //94
//        System.out.println(z.solution("4177252841", 4)); //775841
//        System.out.println(z.solution("4177252841", 8)); //84
//        System.out.println(z.solution("19241924" , 6)); //94
//        System.out.println(z.solution("87654321" , 3)); //87654
//        System.out.println(z.solution("18765432" , 3)); //87654
//        System.out.println(z.solution("99991" , 3)); //99
//        System.out.println(z.solution("11119" , 3)); //19
//        System.out.println(z.solution("999" , 2)); //9
//        System.out.println(z.solution("99999999999999999" , 9));
        System.out.println(z.solution("661742328215729068402560788309769925990525047" , 30)); //9 6 8  6 7 8 8  9 7 6 9 9 9 9   5 7


        // "1924", 2));
        // "1231234" , 3  = "3234"
        // "4177252841", 4  = "775841"

        //가장 큰 수를 기준으로 앞과 뒤의 숫자들을 정렬한다.
        //거기서 앞에 k개수 제거한다.

    }
    public String solution(String number, int k){
        char[] numbers = number.toCharArray();
        Arrays.sort(numbers);
        int max = numbers[numbers.length - 1];

        char[] frontArray = number.substring(0, number.indexOf(max)).toCharArray();
        char[] rearArray = number.substring(number.indexOf(max)).toCharArray();
        Arrays.sort(frontArray);
        Arrays.sort(rearArray);

        StringBuilder sb = new StringBuilder(64);
        sb.append(frontArray);
        sb.append(rearArray);

        char[] combined = sb.toString().toCharArray();

        List<Character> least = new ArrayList<>();
        for(int i =0; i <k; i++){
            least.add(combined[i]);
        }

        String result = "";
        char[] numberArray = number.toCharArray();
        for(int i = 0; i<number.length(); i++){
            if(least.contains(numberArray[i])){
                least.remove(least.indexOf(numberArray[i]));
            }else {
                result = result + numberArray[i];
            }
        }

        return result;
    }
}
