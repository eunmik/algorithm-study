package com.eunmi.algorithm.category.brute_force;

import java.util.*;

/**
 * 푼 날짜 : 2022-01-18
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class 모의고사 {
    public static void main(String[] args) {
        모의고사 a = new 모의고사();
        int[] answers = {1, 2, 3, 4, 5};
        //int[] answers = {1, 3, 2, 4, 2};
        //int[] answers = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        int[] result = a.solution(answers);
        for(int r : result){
            System.out.println(r);
        }

    }

    /**
     * 1번 수포자가 찍는 방식: [1, 2, 3, 4, 5], 1, 2, 3, 4, 5, ...
     * 2번 수포자가 찍는 방식: [2, 1, 2, 3, 2, 4, 2, 5], 2, 1, 2, 3, 2, 4, 2, 5, ...
     * 3번 수포자가 찍는 방식: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5], 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     */

    class Node {
        int count;
        int len;
        int name;
        public Node(int count, int len, int name){
            this.name = name;
            this.count = count;
            this.len = len;
        }
    }
    public int[] solution(int[] answers){
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Node aNode = new Node(0, 0, 1);
        Node bNode = new Node(0, 0, 2);
        Node cNode = new Node(0, 0, 3);


        for(int i =0; i<answers.length; i++){
            int answer = answers[i];
            if(a[i%a.length] == answer){
                aNode.count++;
            }
            if(b[i%b.length] == answer){
                bNode.count++;
            }
            if(c[i%c.length] == answer){
                cNode.count++;
            }
        }
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                return o2.count - o1.count;
            }
        });
        priorityQueue.add(aNode);
        priorityQueue.add(bNode);
        priorityQueue.add(cNode);

        while(!priorityQueue.isEmpty()) {
            Node topNode = priorityQueue.poll();
            list.add(topNode.name);
            if(!priorityQueue.isEmpty() && priorityQueue.peek().count < topNode.count) {
                break;
            }
        }
        int[] result = new int[list.size()];
        for(int j =0; j<list.size(); j++){
            result[j] = list.get(j);
        }
        Arrays.sort(result);
        return result;

    }
}
