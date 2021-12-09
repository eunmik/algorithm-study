package com.eunmi.algorithm.category.stack;

import java.util.LinkedList;

/**
 * 포스트픽스로 주어진 식을 계산하는 코드를 작성하라. 수식은 사칙연산 (+,-,*,/)만 사용한다고 가정한다.
 * 예) 12+ =>3
 * 예)123+-5* => -20
 * 포스트 픽스는 수식을 피연산자 두개 뒤에 두는 표기법 예) 123+-5*
 */
public class EvaluationPostFix {
    public static void main(String[] args){
        EvaluationPostFix postfix = new EvaluationPostFix();
        System.out.println(postfix.solution("52+")==7);
        System.out.println(postfix.solution("52-")==3);
        System.out.println(postfix.solution("52*")==10);
        System.out.println(postfix.solution("52/")==2);
        System.out.println(postfix.solution("521+-9*")==18);
    }
    public int solution(String postfix){
        LinkedList<Integer> numbers = new LinkedList();
        postfix = postfix.trim(); //빈공간을 없앰
        for(int i =0; i<postfix.length(); i++){
            char c = postfix.charAt(i);
            if(Character.isDigit(c)){
                numbers.push(c-'0');
            } else {
                int right = numbers.pop();
                int left = numbers.pop();

                switch(c) {
                    case '+' :
                        numbers.push(left + right);
                        break;
                    case '-' :
                        numbers.push(left - right);
                        break;
                    case '*' :
                        numbers.push(left * right);
                        break;
                    case '/' :
                        numbers.push(left / right);
                        break;
                }
            }
        }
        return numbers.pop();
    }

}
