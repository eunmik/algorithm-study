package com.eunmi.algorithm.category.stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Progress {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42586
     * test 2, 11에서 실패.. ㅠㅠ
     */
    public static void main(String[] args){
        Progress progress = new Progress();
        int[] progresses = {93, 30, 55};
        //int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1, 30, 5};
        //int[] speeds = {1,1,1,1,1,1};
        int[] result = progress.solution(progresses, speeds);
        for( int r : result){
            System.out.println(r);
        }
    }

    public int[] solution(int[] progresses, int[] speeds){

        Stack stack = new Stack<>();
        int cnt =0;
        List<Integer> answer = new ArrayList<>();

        for(int i=progresses.length -1; i>=0; i--){ //주어진 배열의 뒷 숫자부터 스택에 집어 넣었다
            stack.add(Math.round((double)(100-progresses[i])/speeds[i]));
        }

        while(!stack.empty()){
            int compare =  Integer.parseInt(String.valueOf(stack.pop())); //long cannot be cast to integer
            cnt=1;
            while(!stack.empty() && compare >= Integer.parseInt(String.valueOf(stack.peek()))) { //앞의 데이터가 더 크거나 같으면
                cnt++;
                stack.pop();
            }
            answer.add(cnt);
        }
        int[] result = new int[answer.size()];
        for(int i =0; i<answer.size(); i++){
            result[i] = answer.get(i);
        }

            return result;
    }
}
