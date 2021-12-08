package com.eunmi.algorithm.category.list;

import java.util.HashMap;
import java.util.Map;

public class LinkedList2 {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args){
        LinkedList2 list = new LinkedList2();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        //list.print();
        LinkedNode node = list.findFormLast3(2);
        System.out.println(node.number);


    }

    private void print(){
        LinkedNode nodeToPrint = this.head;
        while(nodeToPrint != null){
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    private void add(LinkedNode node){
        if(head == null){
            head = node;
            tail = node;
        }else if(tail != null){
            tail.next = node;
            tail = tail.next;
        }
    }

    /**
     * 단일 연결 리스트의 끝에서 n번째 위치한 노드를 찾는 함수를 구현하라.
     * 예) findFormatLast( 1->4 ->2-> 3, 2), 끝에서 2번째 위치한 2를 리턴한다.
     *
     */
    //시간복잡도 O(n), 공간복잡도 O(n)
    private LinkedNode findFormLast(int n){
        Map<Integer, LinkedNode> nodeMap = new HashMap<>();
        int index = 0;
        LinkedNode current = this.head;
        while(current != null){
            nodeMap.put(index++, current);
            current = current.next;
        }
        int indexToFind = nodeMap.size() - n;

        return nodeMap.get(indexToFind);
    }

    //시간복잡도 O(n), 공간복잡도 O(1)
    private LinkedNode findFormLast2(int n){
        LinkedNode current = this.head;
        int length = 0;

        while(current != null){
            length++;
            current = current.next;
        }

        int targetIndex = length -n;
        LinkedNode target = this.head;

        while(targetIndex > 0){
            targetIndex--;
            target = target.next;
        }
        return target;
    }
    //시간복잡도O(N), 공간복잡도 O(1)
    private LinkedNode findFormLast3(int n){
        LinkedNode left = this.head, right = this.head;
        int count = 0;
        while (right.next != null){
            if(count == n -1){
                left = left.next;
                right = right.next;
            } else if(count++ <n){
                right = right.next;
            }
        }
        return left;
    }
}
