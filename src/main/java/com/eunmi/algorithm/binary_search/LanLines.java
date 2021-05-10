package com.eunmi.algorithm.binary_search;

import java.util.Arrays;

public class LanLines {
    public static void main(String[] args){
        LanLines l = new LanLines();
        int[] info = {4, 20};
        int[] lans = {802, 743, 457, 539};
        System.out.println(l.solution(info, lans));

    }
    public int solution(int[] info, int[] lans){
        int min = 0;
        Arrays.sort(lans);
        int max = lans[lans.length - 1];
        int answer = 0;
        while(min<=max) {
            int sum = 0;
            int mid = (min + max) / 2;
            for (int lan : lans) {
                sum += lan / mid;
            }
            if (sum < info[1]) { //sum이 원하는 갯수보다 크면

                max = mid - 1;
            } else {
                min = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }
}
