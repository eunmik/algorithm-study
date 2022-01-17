package com.eunmi.algorithm.category.sort;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 푼 날짜 : 2022-01-11
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 * 다시 풀기 (내가 푼거 아님)
 */
public class 가장큰수 {
    public static void main(String[] args) {
        가장큰수 a = new 가장큰수();
        //int[] numbers = {6, 10, 2}; //6210
        int[] numbers = {10, 9999, 19, 9};
        //int[] numbers = {1,1};
        String result = a.solution(numbers);
        System.out.println(result);
        //10, 9999, 19, 9   [9999 9 1910]
        //9999, 19, 10, 9

    }

    public String solution(int[] numbers){
        String answer = "";
        //문자열 리턴을 해줄 스트링 배열 생성
        String[] str = new String[numbers.length];

        //int배열을 String 배열로 변환
        for(int i =0; i< numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        //내림차순 정렬
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("#############");
                System.out.println("o1 : "+o1 +", o2 : "+o2);
                System.out.println("(o2 + o1) : "+(o2 + o1)+", (o1 + o2) : "+(o1 + o2));
                //System.out.println("return : "+(o2 + o1).compareTo(o1 + o2));

                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for(String s : str){
            System.out.print(s+", ");
        }

        //0값이 중복일 경우 ex) 0,0,0
        //답이 000이 나오면 안되니깐  첫번째 값이 0이면 0을 return
        if(str[0].equals("0")) return "0";

        //0이 아니면 문자열을 더해준다.
        for(String s: str){
            answer+= s;
        }
        return answer;

    }
}

