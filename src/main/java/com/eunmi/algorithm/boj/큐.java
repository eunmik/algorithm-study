package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10845
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class 큐 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        List queue = new ArrayList();
        while(N>0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N--;
            switch (st.nextToken()){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(queue.size() > 0){
                        sb.append(queue.get(0) + "\n");
                        queue = pop(queue);
                    }else {
                        sb.append(-1+"\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()+"\n");
                    break;
                case "empty":
                    sb.append((queue.size() == 0 ? 1 : 0)+"\n");
                    break;
                case "front":
                    if(queue.size() >0){
                        sb.append(queue.get(0)+"\n");
                    }else {
                        sb.append(-1+"\n");
                    }
                    break;
                case "back":
                    if(queue.size()>0){
                        sb.append(queue.get(queue.size() - 1)+"\n");
                    }else {
                        sb.append(-1+"\n");
                    }
                    break;
            }

        }
        System.out.println(sb);


    }

    static List<Integer> pop(List<Integer> queue){
        List<Integer> result = new ArrayList<>();

        for(int i =1; i<queue.size(); i++){
            result.add(queue.get(i));
        }
        return result;
    }

}
