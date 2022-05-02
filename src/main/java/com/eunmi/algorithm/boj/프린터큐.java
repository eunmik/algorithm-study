package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1966
 */
public class 프린터큐 {
    static class Job{
        int index;
        int priority;

        public Job(int index, int priority){
            this.index = index;
            this.priority = priority;
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
            Queue<Job> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            List<Integer> priorityList = new ArrayList<>();
            for(int i =0; i<size; i++){
                int p = Integer.parseInt(st.nextToken());
                queue.add(new Job(i, p));
                priorityList.add(p);
            }
            Collections.sort(priorityList, Comparator.reverseOrder());

            int count = 0;
            int i =0;
            while(!queue.isEmpty()){
                Job job = queue.poll();

                if(job.priority != priorityList.get(i)){
                    queue.add(job);
                }else if(job.index == M && priorityList.get(i) == job.priority){
                    sb.append((count+1) +"\n");
                    break;
                }else if(job.priority == priorityList.get(i)){
                    count++;
                    i++;
                }
            }
            N--;
        }
        System.out.println(sb);
    }
}
