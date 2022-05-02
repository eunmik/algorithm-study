package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1966
 */
public class 프린터큐 {
    static class Job implements Comparable<Job>{
        int index;
        int priority;

        public Job(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
        @Override
        public int compareTo(Job o) {
            return o.priority - this.priority;
        }
    }
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //Test Case 갯수
        StringBuilder sb = new StringBuilder();

        while(N > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            PriorityQueue<Job> queue = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine(), " ");

            for(int i =0; i<size; i++){
                queue.add(new Job(i, Integer.parseInt(st.nextToken())));
            }

            int count = 0;
            while(!queue.isEmpty()){
                Job job = queue.poll();
                count++;
                if(job.index == M){
                    sb.append(count+"\n");

                }
            }
            N--;
        }
        System.out.println(sb);
    }
}
