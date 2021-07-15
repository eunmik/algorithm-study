package com.eunmi.algorithm.practices.a210614;


//https://programmers.co.kr/learn/courses/30/lessons/68935
public class TrinaryDigit {
    public static void main(String[] args){
        TrinaryDigit tr = new TrinaryDigit();
        System.out.println(tr.solution(45));
    }
    public int solution(int n){
        int answer = 0;
        int tendigit = n;
        String reverseTrit = "";

        //10진수를 3진수 거꾸로로
        while(tendigit>0){
            reverseTrit += tendigit%3;
            tendigit = tendigit/3;

        }

        for(int i=0; i<reverseTrit.length(); i++){
            char digit = reverseTrit.charAt((reverseTrit.length()-1)-i);
            answer += Integer.parseInt(String.valueOf(digit)) * (int) Math.pow(3, i);
        }

        return answer;
    }


}
