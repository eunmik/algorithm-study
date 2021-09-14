package com.eunmi.algorithm.practices.일요일스터디.A210919;

//https://programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;

/**
 * 푼 날짜 :2021-09-13
 * 푼 시간 18:21 ~
 * 알고리즘 : BFS
 */
public class 단어변환 {
    public static void main(String[] args) {
        단어변환 e = new 단어변환();
        //String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words = {"aaa","aab","abb","bbb"};
        System.out.println(e.solution("aaa", "bbb", words));
    }

    public static int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList();
        queue.add(new Word(begin, 1));
        Arrays.sort(words);
        Stack<String> stack = new Stack();
        for(int i =0; i<words.length; i++){
            stack.push(words[i]);
        }
        int min = Integer.MAX_VALUE;


        while (!queue.isEmpty()) {
            Word root = queue.poll();
            stack.remove(root.word);
            if(root.word.equals(target)){
//                if(min > root.cnt){
//                    min = root.cnt-1;
//                }
                return root.cnt - 1;

            }
            Iterator<String> it = stack.iterator();
            while(it.hasNext()){
                String w = it.next();
                if(isValid(w, root.word)){
                    queue.add(new Word(w, root.cnt + 1));
                }

            }
        }
        if(min >= Integer.MAX_VALUE){
            min = 0;
        }
        return min;
    }

    static boolean isValid(String begin, String target){
        char[] beginArray = begin.toCharArray();
        char[] targetArray = target.toCharArray();
        boolean[] checked = new boolean[begin.length()];
        int falseCnt = 0;
        for(int i =0; i<beginArray.length; i++){
            if(beginArray[i] == targetArray[i]){
                    checked[i] = true;
            }
        }
        for(boolean c : checked){
            if(!c) falseCnt++;
        }
        if(falseCnt > 1) {
            return false;
        }else {
            return true;
        }

    }

    static class Word {
        String word;
        int cnt;
        public Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;

        }
    }

}
