package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10828
 */

public class 스택 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List stack = new ArrayList<>();
        //push, pop, size, empty, top
        while(N > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()){
                case "push" :
                    stack.add(st.nextToken());
                    break;
                case "top" :
                    if(!stack.isEmpty()) {
                        sb.append(stack.get(stack.size() - 1) + "\n");
                    }else{
                        sb.append(-1 + "\n");
                    }
                    break;
                case "size" :
                    sb.append(stack.size()+"\n");
                    break;
                case "empty" :
                    sb.append((stack.size() == 0 ? 1 : 0) + "\n");
                    break;
                case "pop" :
                    if(!stack.isEmpty()){
                        sb.append(stack.get(stack.size() - 1)+"\n");
                        stack.remove(stack.size() - 1);
                    }else {
                        sb.append(-1 + "\n");
                    }

                    break;
            }
            N--;
        }
        System.out.println(sb);

    }
}
