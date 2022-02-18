package com.eunmi.algorithm.category.DFS_BFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * LEVEL 3
 */
public class 단어변환 {
    public class Node{
        String next;
        int edge;
        public Node(String next, int edge){
            this.next = next;
            this.edge = edge;
        }
    }
    public int solution(String begin, String target, String[] words){
        int n = words.length, answer = 0;
        Queue<Node> queue = new LinkedList<>();

        boolean[] visit = new boolean[n];
        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.next.equals(target)){
                answer = cur.edge;
                break;
            }

            for(int i =0; i<n; i++){
                if(!visit[i] && isNext(cur.next, words[i])){
                    visit[i] = true;
                    queue.add(new Node(words[i], cur.edge + 1));
                }
            }
        }
        return answer;

    }

    static boolean isNext(String cur, String n){
        int cnt = 0;
        for(int i =0; i<n.length(); i++){
            if(cur.charAt(i) != n.charAt(i)){
                if(++cnt > 1) return false;
            }
        }
        return true;
    }

    @Test
    public void answer(){
        assertEquals(4, solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        assertEquals(0, solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
