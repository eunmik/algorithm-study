package com.eunmi.algorithm.category.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Printers {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42587
     * 테스트 3개 빼고 다 실패 (.....OTL)
     */
    public static void main(String[] args){
        Printers p = new Printers();
        int[] priorities = {2, 1, 3, 2};
        //int[] priorities = {1,1,9,1,1,1};
        int location = 2;
        int result = p.solution(priorities, location);
        System.out.println(result);
    }
    public int solution(int[] priorities, int location){
        int answer = 0;
        Queue q = new LinkedList<>();
        //print 순서를 정려해 보자.
        for(int p = 0; p < priorities.length; p++){
            q.offer(p); //{0,1,2,3}
        }
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<priorities.length; i++){
            if(i != priorities.length-1){
                list.add(i); //인덱스를 리스트에 넣어두고
                if(priorities[i] < priorities[i+1]){//앞에 숫자보다 뒤에 숫자가 크면
                    for(int e : list){ //리스트에 넣어있는 인덱스들을 다 뒤로 보낸다
                        q.offer(q.poll());
                    }
                }
            }
        }
        while(true){

            if((int)q.poll() == location){ //위치랑 q의 값이 같으면
                return answer+1;
            }
            answer++;
        }
    }
}
