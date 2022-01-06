package com.eunmi.algorithm.category.heap;

import java.util.*;

/**
 * 푼 날짜 : 2022-01-05
 */

/**
 * {{0, 3}, {1, 9}, {2, 6}} : 9 (O)
 * {{0, 10}, {2, 10}, {9, 10}, {15, 2}} : 14
 * {{0, 10}, {2, 12}, {9, 19}, {15, 17}} : 25 (O)
 * {{0, 1}} : 1 (O)
 * {{1000, 1000}} : 1000
 * {{0, 1}, {0, 1}, {0, 1}} : 2
 * {{0, 3}, {1, 9}, {2, 6}, {30, 3}} : 7
 * {{0, 10}, {4, 10}, {15, 2}, {5, 11}} : 15
 * {{10, 10}, {30, 10}, {50, 2}, {51, 2}} : 6
 * {{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}} : 13 (O)
 * {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}} : 72
 * {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}} : 72
 */
public class DiskController {
    public static void main(String[] args) {
        DiskController s = new DiskController();
//        int[][] jobs =  {{0, 3}, {1, 9}, {2, 6}};
//        int[][] jobs =  {{1, 10},{3, 3},{10, 3}}; //9
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}, {30, 3}};
        System.out.println(s.solution(jobs));
    }
    public int solution(int[][] jobs){
        /**
         * 1. 오름차순으로 정렬
         *
         */
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Queue<int[]> waiting = new LinkedList<>();
        for(int[] j : jobs){
            waiting.offer(j);

        }
        PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int result = 0;
        int cnt = 0;
        int time = waiting.peek()[0];
        while(cnt < jobs.length){
            while(!waiting.isEmpty() && waiting.peek()[0] <= time){
                queue.offer(waiting.poll());
            }
            if(!queue.isEmpty()){
                int[] job = queue.poll();
                time += job[1];
                result += time - job[0];
                cnt++;
            } else {
                time ++;
            }
        }

        return Math.abs(result / jobs.length);

    }

}
