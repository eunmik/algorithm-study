package com.eunmi.algorithm.category.tree;

import java.util.HashMap;
import java.util.Map;

/**
 *  중위탐색과 전위 탐색 결과를 가지고 이진 트리를 만드는 코드를 작성하라.
 *  중위탐색(LDR) : 4,2,5,1,3
 *  전위탐색(DLR) : 1,2,4,5,3
 */
public class BuildTree {
    private static class Node{
        int value;
        Node left, right;

        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args){
        BuildTree buildTree = new BuildTree();
        Node root = buildTree.build(new int[]{4, 2, 5, 1, 6, 3}, new int[]{1, 2, 4, 5, 3, 6});
        printInOrder(root);
    }
    private static void printInOrder(Node root){
        if(root != null){
            printInOrder(root.left);
            System.out.println(root.value);
            printInOrder(root.right
            );
        }
    }

    private Node build(int[] inOrder, int[] preOrder){
        for(int i =0; i<inOrder.length; i++){
            indexMap.put(inOrder[i], i);
        }
        return buildRecurse(inOrder, preOrder, 0, inOrder.length -1);
    }

    int preIndex = 0;
    Map<Integer, Integer> indexMap = new HashMap<>();

    private Node buildRecurse(int[] inOrder, int[] preOrder, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return null;
        }
        Node node = new Node(preOrder[preIndex++]);
        if (startIndex == endIndex) {
            return node;
        }

        int inIndex = indexMap.get(node.value);
        node.left = buildRecurse(inOrder, preOrder, startIndex, endIndex - 1);
        node.right = buildRecurse(inOrder, preOrder, inIndex + 1, endIndex);

        return node;
    }

}
