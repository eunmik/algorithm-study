package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/6603
 * Hint : 재귀
 */
public class 로또 {
    public static class Number implements Comparable<Number>{
        List<Integer> list;
        public Number(List<Integer> list){
            this.list = list;
        }

        @Override
        public int compareTo(Number o) {
            if(this.list.get(0) == o.list.get(0)){
                for(int i =1; i<o.list.size(); i++){
                    if(this.list.get(i) != o.list.get(i)){
                        return this.list.get(i) - o.list.get(i);
                    }
                }
            }
            return this.list.get(0) - o.list.get(0);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Number)) {
                return false;
            }
            Number number = (Number) obj;
            for(int i=0; i<number.list.size(); i++){
                if(number.list.get(i) != this.list.get(i)){
                    return false;
                }
            }
            return true;
        }

    }
    static PriorityQueue<Number> Queue;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.MAX_VALUE;
        sb = new StringBuilder();
        while(N != 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            Queue = new PriorityQueue<>();
            ArrayList<Integer> intArray = new ArrayList<>();
            for(int i =0; i<N; i++){
                intArray.add(Integer.parseInt(st.nextToken()));
            }
            for(int i=0; i<N; i++){
                solution(intArray, i);
            }

            while(!Queue.isEmpty()){
                String result = Queue.poll().list.toString().replaceAll("[\\[\\],]", "");
                sb.append(result+"\n");

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void solution(ArrayList<Integer> array, int index){

        if(array.size() == 6){
            Number num = new Number(array);
            if(!Queue.contains(num)){
                Queue.add(num);
            }
            return;
        }
        ArrayList<Integer> tmp = (ArrayList<Integer>) array.clone();
        tmp.remove(index);
        for(int i =0; i<tmp.size(); i++){
            solution(tmp, i);
        }
        return;
    }
}
