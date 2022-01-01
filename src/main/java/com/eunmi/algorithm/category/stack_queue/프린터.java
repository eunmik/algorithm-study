package com.eunmi.algorithm.category.stack_queue;

import java.util.*;

/**
 * 푼 날짜 : 2022-01-01
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class 프린터 {
    public static void main(String[] args) {
        프린터 a = new 프린터();
        int[] priorities = {2,1,3,2};
        int location = 2;

        //int[] priorities = {1, 1, 9, 1, 1, 1};
        //int location = 0;

        //int[] priorities = {4,3,2,1};
        //int location = 1;
        System.out.println(a.solution(priorities, location));

    }

    public class Node{
        int index;
        int value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    public int solution(int[] priorities, int location){
        /*
        1. priorities의 정렬된 리스트(sorted_priorities)를 생성한다 [3,2,2,1]
        2. priorities를 queue에 담는다 [2,1,3,1]
        3. priorities[i]과 priorities[j] 이 일치하면 둘다 삭제 한다. cnt++
        4. 그렇지 않으면 priorities[j]의 값을 빼서 뒤에 넣는다.
         */
        int[] sorted_priorities = priorities.clone();
        sorted_priorities = Arrays.stream(sorted_priorities).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();


        int i = 0;
        Queue<Node> queue = new LinkedList<>();
        for(int p : priorities) {
            queue.add(new Node(i++, p));
        }
        i = 0;
        int cnt = 0;
        int result = 0;
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.value == sorted_priorities[i]) {
                i++;
                cnt++;
                if(current.index == location) {
                    result = cnt;
                    break;
                }
            }
            queue.add(current);


        }
        return result;
    }
}
