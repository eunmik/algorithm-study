package com.eunmi.algorithm.category.stack_queue;

import java.util.*;

/**
 * 푼 날짜 : 2021-12-29
 * https://programmers.co.kr/learn/courses/30/parts/12081
 */
public class 기능개발 {
    public static void main(String[] args) {
        기능개발 a = new 기능개발();
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        int[] result = a.solution(progresses, speeds);
        for(int r : result){
            System.out.println(r);
        }

    }

    public int[] solution(int[] progresses, int[] speeds) {

        int daysTowork = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<progresses.length; i++){
            daysTowork = Math.round((100 - progresses[i]) / speeds[i]);
            queue.offer(daysTowork);
        }
        List<Integer> result = new ArrayList<>();
        int total = 1;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            if(!queue.isEmpty()){
                if(poll >= queue.peek()) {
                    total++;
                }else {
                    result.add(total);
                    total = 1;
                }
            }else {
                result.add(total);
                total = 1;
            }


        }
        int[] answer = new int[result.size()];
        int i =0;
        for(int r : result){
            answer[i] = r;
            i++;
        }

        return answer;
    }
}
