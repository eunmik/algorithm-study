package com.eunmi.algorithm.stack_queue;

import java.util.*;

public class Truck {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42583
     */


    public static void main(String[] args){
        Truck truck = new Truck();
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int result = truck.getEstimatedTime(100, 100, truck_weights);
        System.out.println(result);
    }

    public int getEstimatedTime(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;
        for(int t:truck_weights){
            while(true){
                if(q.isEmpty()) { //다리 위에 아무것도 없다면
                    q.offer(t); //트럭 한대를 올려 놓는다
                    time++;
                    currentWeight += t;
                    break;
                } else if(q.size() == bridge_length){
                    currentWeight -= q.poll();

                } else {
                    //다리 위에 트럭이 있을 때 무게를 계산, 현재 무게와 그다음 트럭의 무게를 합쳤을 때
                    //다리의 무게보다 무거오면 트럭은 다음 차례를 기다려야한다.
                    if(currentWeight + t > weight) {
                        q.offer(0);
                        time++;
                    }else{ //다리 무게보다 가벼우면
                        q.offer(t);
                        time++;
                        currentWeight+=t;
                        break;
                    }
                }
            }
        }
        return time+bridge_length;
    }
}
