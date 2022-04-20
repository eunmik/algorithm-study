package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/10866
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class 덱 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque deque = new LinkedList();
        while(N>0) {
            N--;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "pop_front" :
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    }else {
                        sb.append(deque.pollFirst() + "\n");
                    }
                    break;
                case "pop_back" :
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    }else {
                        sb.append(deque.pollLast() + "\n");
                    }
                    break;
                case "push_front" :
                    deque.addFirst(st.nextToken());
                    break;
                case "push_back" :
                    deque.addLast(st.nextToken());
                    break;
                case "size" :
                    sb.append(deque.size()+"\n");
                    break;
                case "empty" :
                    sb.append((deque.isEmpty() ? 1 : 0)+"\n");
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    }else {
                        sb.append(deque.getFirst() + "\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append(-1 + "\n");
                    }else {
                        sb.append(deque.getLast() + "\n");
                    }
                    break;

            }

        }
        System.out.println(sb);
    }
}
