package com.eunmi.algorithm.category.queue;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 큐를 사용해서 스택을 구현하라.
 * 큐 인스턴스를 사용해서 Stack 인터페이스를 구현하라
 * pop() 오퍼레이션은 가장 마지막으로 추가한 값을 꺼내야 한다.
 * push() 오퍼레이션은 값을 추가한다.
 *
 * 큐가 제공하는 offer(), poll(), isEmpty(), size()만 사용할 수 있다. Deque는 사용하지 못한다.
 * (힌트) 큐 인스턴스를 여러개 사용할 수 있다.
 */
public class QueueStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args){
        QueueStack stack = new QueueStack();
        stack.push2(1);
        stack.push2(2);
        stack.push2(3);
        System.out.println(stack.pop2() == 3);
        System.out.println(stack.pop2() == 2);
        System.out.println(stack.pop2() == 1);
    }
    //pop()이 시간복잡도 O(1), push()는 O(N)
    private Integer pop() {
        if (q1.isEmpty()) {
            return null;
        }
        return q1.poll();
    }

    private void push(int number){
        q2.offer(number);
        while (!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    //push()가 시간복잡도 O(1), pop()은 O(N)
    private Integer pop2(){
        if(q1.isEmpty()){
            return null;
        }
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        Integer result = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return result;
    }

    private void push2(int number){
        q1.offer(number);
    }

}
