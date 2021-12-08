package com.eunmi.algorithm.category.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedList3 {
    private LinkedNode head;
    private LinkedNode tail;
    /**
     * 정렬된 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.
     * 예) 1-> 1-> 1-> 2-> 3-> 3 ==> 1->2->3
     *
     */
    public static void main(String[] args){
        LinkedList3 list = new LinkedList3();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        //list.print();
        list.removeDuplicates4();
        list.print();


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

    //시간복잡도 O(N), 공간복잡도O(1)
    private void removeDuplicates(){
        LinkedNode current = this.head;
        while(current != null){
            LinkedNode next = current;
            while(next != null && next.number == current.number){
                next = next.next;
            }
            current.next = next;
            current = current.next;
        }
    }

    //시간복잡도 O(N), 공간복잡도O(1)
    private void removeDuplicates2(){
        LinkedNode current = this.head;
        LinkedNode prev = this.head;

        while(current != null){
            if(current.number != prev.number){ //prev랑 current가 다를때 세팅하겠다
               prev.next = current;
               prev = current;
            }
            current = current.next;

        }
        if(prev!= current) {
            prev.next = null;
        }
    }

    //시간복잡도 O(N), 공간복잡도O(N)
    private void removeDuplicates3(){
        removeDuplicatesRecursive(this.head);
    }
    private LinkedNode removeDuplicatesRecursive(LinkedNode node){
        if(node == null){
            return null;
        }
        if(node.next != null){
            if(node.number == node.next.number){
                node.next = node.next.next;
                removeDuplicatesRecursive(node);
            } else {
                removeDuplicatesRecursive(node.next);
            }
        }
        return node;
    }
    //시간복잡도 O(N), 공간복잡도O(N)
    private void removeDuplicates4(){
        Set<Integer> numberSet = new HashSet();
        LinkedNode current = this.head;
        LinkedNode prev = null;

        while(current != null){
            int currentNumber = current.number;
            if (numberSet.contains(currentNumber)){
                prev.next = current.next;

            } else {
                numberSet.add(currentNumber);
                prev = current;
            }
            current = current.next;

        }
    }



}
