package com.eunmi.algorithm.category.tree;

import java.util.Stack;

public class TreeIntro {
    private static class Node{
        int value;
        Node left, right;
        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        TreeIntro treeIntro = new TreeIntro();
        treeIntro.ldr2(root);
    }

    //재귀적으로 (4,2,5,1,6,3,7)
    private void ldr1(Node root){
        if (root != null){
            ldr1(root.left);
            System.out.println(root.value);
            ldr1(root.right);
        }
    }

    //iterator 하게
    private void ldr2(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(true) {
            while (root != null){
                stack.push(root);
                root = root.left;

            }
            if (stack.isEmpty()){
                break;
            }
            root = stack.pop();
            System.out.println(root.value);
            root = root.right;

        }

    }
}
