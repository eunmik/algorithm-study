package com.eunmi.algorithm.category.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 큐가 제공하는 오퍼레이션만 사용해서 큐를 뒤집는 코드를 작성하라.
 * 제공하는 오퍼레이션은 다음과 같다.
 * offer(E e): 큐의 끝에 데이터를 추가한다.
 * E poll(): 큐 헤드를 꺼낸다.
 * isEmpty(): 큐가 비어있는가
 */
public class ReverseQueue {
    public static void main(String[] args){
        Queue<Integer> numbers = new LinkedList<>();
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);

        System.out.println(numbers);
        ReverseQueue reverseQueue = new ReverseQueue();
        Queue<Integer> reversed = reverseQueue.reverse2(numbers);
        System.out.println(reversed);

    }

    //stack이랑 queue 같이 사용
    private Queue<Integer> reverse(Queue<Integer> numbers){
        Stack<Integer> stack = new Stack<>();
        while(!numbers.isEmpty()){
            stack.push(numbers.poll());
        }
        while( !stack.isEmpty()) {
            numbers.offer(stack.pop());
        }
        return numbers;
    }

    //재귀적인 방법
    private Queue<Integer> reverse2(Queue<Integer> numbers){
        if(numbers.isEmpty()){
            return numbers;
        }

        int front = numbers.poll();
        numbers = reverse(numbers);
        numbers.offer(front);
        return numbers;
    }




}
