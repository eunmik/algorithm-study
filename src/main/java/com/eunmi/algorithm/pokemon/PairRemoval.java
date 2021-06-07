package com.eunmi.algorithm.pokemon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/12973
public class PairRemoval {
    public static void main(String[] args){
        PairRemoval p = new PairRemoval();
        String s = "cdcd";
        System.out.println(p.solution2(s));
    }
    public int solution(String s){ //효율성 테스트 실패
        char[] sArray = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char c : sArray){
            list.add(c);
        }
        int i =0;
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            if(i == list.size()-1){
                break;
            }
            if(list.get(i).equals(list.get(i+1))){
                list.remove(i);
                list.remove(i);
                i=0;
            } else {
                i++;
            }
        }

        return (list.size() > 0) ? 0 : 1;
    }

    public int solution2(String s){
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack();

        for(int i =0; i<sArray.length; i++){
            if(i == stack.size()-1){
                break;
            }
            if(stack.isEmpty()){
                stack.push(sArray[i]);
            }else {
                char last = stack.peek();
                char current =  sArray[i];
                if(last == current){
                    stack.pop();
                }else if(last != current){
                    stack.push(current);
                }
            }
        }
        return (stack.size() > 0)? 0 : 1;
    }
}
