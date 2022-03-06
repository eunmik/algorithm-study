package com.eunmi.algorithm.practices.우테코2021;

import java.util.*;

public class 연속되는글자 {
    public static void main(String[] args){
        연속되는글자 a = new 연속되는글자();

         String s = "wowwow";
        //String s = "wwwowwwooowwwow";
        a.solution(s);
        int[] result = a.solution(s);
        for (int i : result) {
            System.out.println(i);
        }

    }
    public int[] solution(String s){
        /**
         * 1. 앞뒤로 연속 되는 글자를 카운트 해 준다. (큐를 이용)
         * 2. 그 외에는 순차적으로 연속되는 글자를 카운트 한다 (스택을 이용)
         */
        //1번 수행
        Deque<Character> q = new LinkedList();
        char[] c_array = s.toCharArray();
        for(char c : c_array){
            q.add(c);
        }
        List<Integer> list = new ArrayList<>();
        final char firstLetter = c_array[0];
        int cnt = 0;
        while(true) {
            if(q.peekLast() != firstLetter && q.peekFirst() != firstLetter){
                break;
            }
            if(firstLetter == q.peekFirst()){
                q.pollFirst();
                cnt++;
            }
            if(firstLetter == q.peekLast()){
                q.pollLast();
                cnt++;
            }
        }
        list.add(cnt);

        //2번 수행
        Stack<Character> stack = new Stack<>();
        cnt = 0;
        while(!q.isEmpty()){

            char qPeek = q.poll();
            if(stack.isEmpty()){
                cnt++;
                stack.push(qPeek);
            }else if(stack.peek() == qPeek){
                cnt++;
            }else if(stack.peek() != qPeek){
                list.add(cnt);
                stack.push(qPeek);
                cnt = 1;
            }
        }
        list.add(cnt);

        //정렬
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

       return answer;

    }
}
