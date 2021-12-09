package com.eunmi.algorithm.category.stack;

import java.util.Stack;

/**
 * 스택을 뒤집는 코드를 작성하라.
 *
 */
public class ReversedStack {
    public static void main(String[] args){
        ReversedStack rs = new ReversedStack();
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);
        System.out.println(numbers);
        rs.solution2(numbers);
        System.out.println(numbers);
    }
    //시간복잡도 O(N), 공간복잡도 O(N)
    private Stack<Integer> solution1(Stack<Integer> stack){
        Stack<Integer> reversedStack = new Stack<>();
        while(!stack.isEmpty()){
            reversedStack.push(stack.pop());
        }
        return reversedStack;
    }

    //시간복잡도 O(N^2), 공간복잡도 O(N)
    private void solution2(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        solution2(stack);
        insertAtBottom(stack, temp);

    }
    private void insertAtBottom(Stack<Integer> stack, int number){
        if(stack.isEmpty()){
            stack.push(number);
        }else {
            int temp = stack.pop();
            insertAtBottom(stack, number);
            stack.push(temp);
        }
    }
}
