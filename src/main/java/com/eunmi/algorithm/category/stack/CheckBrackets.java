package com.eunmi.algorithm.category.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 주어진 수식의 괄호 짝이 맞는지 확인하는 코드를 작성하라.
 * 예) [{1+2*(2+2)} - {1-3}] => true
 *    [{1+2*(2+2} - [1+3}] => false
 */
public class CheckBrackets {
    public static void main(String[] args){
        CheckBrackets cb = new CheckBrackets();
        System.out.println(cb.solution2("[{1+2*(2+2)} - {1-3}]"));
        System.out.println(cb.solution2("[{1+2*(2+2} - [1+3}]"));
        System.out.println(cb.solution2("((())"));
        System.out.println(cb.solution2("(()))"));
        System.out.println(cb.solution2("{{(())}}"));

    }
    //시간복잡도 O(N), 공간복잡도 O(N)
    private boolean  solution(String mathExpression){
        Stack<Character> brackets = new Stack<>();
        char[] chars = mathExpression.toCharArray();
        for (char c : chars){
            switch (c) {
                case '(':
                case '{':
                case '[':
                    brackets.push(c);
                    break;
                case ')':

                    if(brackets.isEmpty() || brackets.pop() != '('){
                        return false;
                    }
                    break;
                case '}':

                    if(brackets.isEmpty() || brackets.pop() != '{'){
                        return false;
                    }
                    break;
                case ']':

                    if(brackets.isEmpty() || brackets.pop() != '['){
                        return false;
                    }
                    break;

            }
        }
        return brackets.isEmpty();

    }

    //시간복잡도 O(N), 공간복잡도 O(N)
    private boolean solution2(String mathExpression){
        Stack<Character> brackets = new Stack<>();
        char[] chars = mathExpression.toCharArray();
        List<Character> openingBrackets = Arrays.asList('(', '{', '[');
        List<Character> closingBrackets = Arrays.asList(')', '}', ']');

        for (char c : chars){
            if(openingBrackets.contains(c)){
                brackets.push(c);
            } else if(closingBrackets.contains(c)){
                if(brackets.isEmpty()){
                    return false;
                }
                Character openingBracket = brackets.pop();
                if (closingBrackets.indexOf(c) != openingBrackets.indexOf(openingBracket)){
                    return false;
                }

            }
        }
        return brackets.isEmpty();
    }

}
