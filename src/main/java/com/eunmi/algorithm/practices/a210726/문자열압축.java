package com.eunmi.algorithm.practices.a210726;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/60057
public class 문자열압축 {
    /**
     * "aabbaccc"	7
     * "ababcdcdababcdcd"	9
     * "abcabcdede"	8
     * "abcabcabcabcdededededede"	14
     * "xababcdcdababcdcd"	17
     * "aaaaaaaaaaaaaaabbbbbbbbbbc" 7
     * "a" 1
     */
    public static void main(String[] args){
        문자열압축 s = new 문자열압축();
        System.out.println(s.solution2("aabbaccc"));
    }
    public int solution(String s){

        char[] sArray = s.toCharArray();

        int answer = Integer.MAX_VALUE;

        Stack<String> stack = new Stack();
        for (int count = 1; count < sArray.length+1; count++) {
            String newS = "";
            stack.clear();


            for (int i = 0; i < sArray.length; i+=count) {
                String tmp = "";
                int j = i;
                while(j<sArray.length && j<i+count){
                    tmp += String.valueOf(sArray[j]);
                    j++;
                }


                if (!stack.isEmpty()) {
                    if (!stack.peek().equals(tmp)) {
                        if (stack.size() != 1) {
                            newS += stack.size();
                        }
                        newS += stack.peek();
                        stack.clear();
                    }
                }
                stack.push(tmp);
            }

            if(!stack.isEmpty()) {
                if (stack.size() != 1) {
                    newS += stack.size();
                }
                newS += stack.pop();

            }
            if(newS.length() < answer){
                answer = newS.length();
            }
        }
        return answer;
    }


    //다른 사람 풀이
    public int solution2(String s) {
        int answer = 0;

        for(int i=1; i<=(s.length()/2)+1; i++){ //0글자의 경우 5글자까지는 봐야하기 때문
            int result = getSplitedLength(s, i, 1).length();
            answer = i==1 ? result : (answer>result?result:answer);
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat){
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!postString.startsWith(preString)){
            if(repeat ==1){
                result += preString + getSplitedLength(postString, n, 1);
                System.out.println(result);
                return result;
            }

            result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
            System.out.println(result);
            return result;
        }

        result += getSplitedLength(postString, n, repeat+1);
        System.out.println(result);
        return result;
    }
}
