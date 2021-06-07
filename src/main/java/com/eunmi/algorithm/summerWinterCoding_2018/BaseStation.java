package com.eunmi.algorithm.summerWinterCoding_2018;

public class BaseStation {
    public static void main(String[] args) {
        BaseStation bs = new BaseStation();
        System.out.println(bs.solution(11, new int[]{4,11}, 1));
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int start = 1;
        while (start <= n) {
            if (idx < stations.length && start >= stations[idx] - w) {
                start = stations[idx] + w + 1;
                idx++;
            } else {
                start += 2 * w + 1;  //양쪽 범위랑 자기 자신
                answer++;
            }
        }
        return answer;
    }

}
