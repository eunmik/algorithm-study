package com.eunmi.algorithm.category.list;

import java.util.HashSet;
import java.util.Set;

public class LinkedList4 {
    private LinkedNode head;
    private LinkedNode tail;
    /**
     * 주어진 연결리스트가 원형 연결 리스트인지 단일 연결 리스트인지 확인하는 함수를 구현하라.
     * 예) 1-> 2-> 3-> 1 => true
     *     1-> 2-> 3-> 2 => true
     *     1-> 2-> 3 => false
     *
     */
    public static void main(String[] args){
        LinkedList4 list = new LinkedList4();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        LinkedNode node3 = new LinkedNode(3);
        list.add(node3);
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));
        list.add(node3);
        //list.print();
        System.out.println(list.hasCircle2());



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

    private boolean hasCircle(){
        Set<LinkedNode> nodeSet = new HashSet<>();
        LinkedNode current = this.head;
        while(current != null){
            if(nodeSet.contains(current)){
                return true;
            } else {
                nodeSet.add(current);
            }
        }
        return false;
    }

    //Floyd
    //시간복잡도 O(N), 시간복잡도 O(1)
    private boolean hasCircle2(){
        LinkedNode slow = this.head;
        LinkedNode fast = this.head;
        while (slow != null && fast != null){
            if(fast.next == null || fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
            if( slow==fast){
                return true;
            }
            slow = slow.next;
        }
        return false;
    }




}
