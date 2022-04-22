package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11650
 */
public class 좌표정렬하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> list = new PriorityQueue<>();
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Pair(x, y));

        }

        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()){
            Pair pair = list.poll();
            sb.append(pair.x + " " + pair.y + "\n");
        }
        System.out.println(sb);

    }

    static class Pair implements Comparable<Pair>{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;

        }

        @Override
        public int compareTo(Pair a) {

            if(this.x == a.x){
                return Integer.compare(this.y, a.y);
            }
            return Integer.compare(this.x, a.x);
        }
    }

}
