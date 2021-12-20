package com.eunmi.algorithm.category.queue;

import java.util.HashMap;

/**
 * LRU 캐시를 구현하라.
 * 최대 n개 만큼의 가장 최근에 접근한 데이터를 캐싱하는 LRU(Least Recently Used)
 */
public class LRUCache2 {
    public static void main(String[] args){
        LRUCache2 lruCache = new LRUCache2(3);
        lruCache.query(1);
        lruCache.query(2);
        lruCache.query(3);
        lruCache.query(1);
        lruCache.query(4);
        lruCache.query(5);
        lruCache.query(2);
        lruCache.query(2);
        lruCache.query(1);
        lruCache.print();

    }
    private int cacheSize;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache2(int cacheSize){
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();

    }

    //시간 복잡도 O(1)
    private void query(int number){
        if(map.containsKey(number)) {
            Node node = map.get(number);
            remove(node);
            addToHead(node);

        }else {
            Node nodeToAdd = new Node();
            nodeToAdd.value = number;
            if(map.size() == this.cacheSize){
                map.remove(tail.value);
                remove(tail);
            }
            addToHead(nodeToAdd);
            map.put(number, nodeToAdd);
        }
    }

    private void addToHead(Node node){
        node.next = head;
        node.prev = null;
        if(head!= null){
            head.prev = node;
        }
        head = node;
        if(tail == null){
            tail = head;
        }
    }
    private void remove(Node node){
        if(node.prev != null){
            node.prev.next = node.next;
        }else {
            head = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }else {
            tail = node.prev;
        }
    }

    private void print(){
        Node currentNode = head;
        while(currentNode!= null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    private class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;
    }
    
}
