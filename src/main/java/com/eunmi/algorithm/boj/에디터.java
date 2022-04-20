package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1406
 * Hint : stack
 * Hint2 : two stacks
 */
public class 에디터 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for(int i =0; i<word.length(); i++){
            leftStack.push(word.charAt(i));
        }

        while (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N--;
            switch (st.nextToken()) {
                case "L" : //커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                    if(!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D" : //커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    if(!rightStack.isEmpty()){
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B" : // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                    //삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
                    if(!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case "P" : //$라는 문자를 커서 왼쪽에 추가함
                    leftStack.push(st.nextToken().charAt(0));
                    break;
            }
        }
        for(char c : leftStack){
            sb.append(c);
        }
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());

        }

        System.out.println(sb);


    }
}
