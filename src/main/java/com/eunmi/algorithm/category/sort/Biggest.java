package com.eunmi.algorithm.category.sort;


import java.util.*;

public class Biggest {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42746
     * 제한 사항
     * numbers의 길이는 1 이상 100,000 이하입니다.
     * numbers의 원소는 0 이상 1,000 이하입니다.
     * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
     * **/
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        Biggest b = new Biggest();
        String result = b.solution(numbers);
        System.out.println(result);
    }

    public String solution(int[] numbers) {
        String answer = "";

        String[] sNumbers = new String[numbers.length]; //String 배열을 만든다.

        for(int i=0; i<numbers.length; i++){ //int 배열에 있는 값을 string으로 변환해서 string 배열에 넣는다.
            sNumbers[i] = numbers[i] + "";
        }

        Arrays.sort(sNumbers, new Comparator<String>(){ //
            @Override  //합병정렬
            public int compare(String n1, String n2){
                // 더해서 큰 값 만드는 내림 차순
                return (n2+n1).compareTo(n1+n2);
            }
        });


        for(int i=0; i<sNumbers.length; i++){
            answer += sNumbers[i];
        }

        // "000" 과 같이 0이 여러번인 경우 제외
        if(answer.startsWith("0"))
            answer = "0";

        return answer;
    }
}
