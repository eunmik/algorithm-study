package com.eunmi.algorithm.category.stack_queue;

import java.util.*;

/**
 * 푼 날짜 : 2021-12-29
 * https://programmers.co.kr/learn/courses/30/parts/12081
 */
public class 기능개발 {
    public static void main(String[] args) {
        기능개발 a = new 기능개발();
//        int[] progresses = new int[]{93, 30, 55};
//        int[] speeds = new int[]{1, 30, 5};
//        int[] progresses = new int[]{60,50,40};
//        int[] speeds = new int[]{50,50,50};
        int[] progresses = new int[]{99,50,40};
        int[] speeds = new int[]{5,50,50};
        int[] result = a.solution(progresses, speeds);
        for(int r : result){
            System.out.print(r+" ");
        }

    }

    public int[] solution(int[] progresses, int[] speeds) {

        int daysTowork = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<progresses.length; i++){
            daysTowork = (int) Math.ceil((float) (100 - progresses[i]) / speeds[i]);
            queue.offer(daysTowork);
        }
        List<Integer> result = new ArrayList<>();
        int total = 1;
        int prev = 0;
        while(!queue.isEmpty()){
            if(prev == 0){
                prev = queue.poll();
            }else {
                if(prev >= queue.peek()){ //현재 데이터가 전의 데이터보다 크면
                    queue.poll();
                    total++;
                }else {
                    prev = queue.poll();
                    result.add(total);
                    total = 1;

                }
            }
        }
        result.add(total);

        int[] answer = new int[result.size()];
        int i = 0;
        for(int in : result){
            answer[i] = in;
            i++;
        }
        return answer;
    }
}
