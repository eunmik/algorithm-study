package com.eunmi.algorithm.category.heap;

import java.util.*;

/**
 * 푼 날짜 : 2022-01-06
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class 이중우선순위큐 {
    public static void main(String[] args) {
        이중우선순위큐 a = new 이중우선순위큐();
        //String[] operations = {"I 16", "D 1" };
        String[] operations = {"I 7", "I 5", "I -5", "D -1" };
        int[] result = a.solution(operations);
        System.out.print("[");
        for(int i : result){
            System.out.print(i +",");
        }
        System.out.println("]");
    }

    public int[] solution(String[] operations){
        /**
         * I 숫자 : 삽입
         * D 1 : 큐에서 최댓값 삭제
         * D -1: 큐에서 최솟값을 삭제
          */
        Deque<Integer> deque = new ArrayDeque<>();
        for(String op : operations){
            if(op.contains("I")){
                int number = Integer.parseInt(op.substring(1).trim());
                deque.offer(number);
                deque = sort(deque);
            }else if(op.contains("D 1")){
                deque.pollLast();
            }else if(op.contains("D -1")){
                deque.pollFirst();
            }
        }

        deque = sort(deque);
        int[] result = new int[2];
        if(deque.size() > 0){
            result[0] = deque.pollLast();
            result[1] = deque.pollFirst();
            return result;
        }else {
            return new int[]{0, 0};
        }





    }
    public Deque<Integer> sort(Deque<Integer> deque){
        Deque<Integer> dq = new ArrayDeque<>();
        Object[] array = deque.toArray();
        Arrays.sort(array);
        for(Object i : array){
            dq.add((int) i);
        }
        return dq;
    }
}
