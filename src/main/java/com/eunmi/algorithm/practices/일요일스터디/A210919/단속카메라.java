package com.eunmi.algorithm.practices.일요일스터디.A210919;

//https://programmers.co.kr/learn/courses/30/lessons/42884

import java.util.Arrays;
import java.util.Comparator;

/**
 * 푼 날짜: 2021-09-15
 * 알고리즘 : 모르겠다. 검색해서 풀음 ㅠ (https://mishuni.tistory.com/53)
 */
public class 단속카메라 {
    public static void main(String[] args){
        단속카메라 d = new 단속카메라();
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}; //2
        //int[][] routes = {{-2, -1}, {1, 2}, {-3, 0}}; //2
        //int[][] routes = {{0,0}}; //1
        System.out.println(d.solution(routes));

    }
    public int solution(int[][] routes){

        Arrays.sort(routes, new Comparator<int[]>() {  //나가는 순서를 기준으로 오름차순으로 정렬한다.
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int min = Integer.MIN_VALUE;
        int cnt = 0;
        for(int[] r : routes){
            if(r[0] > min){ //min이랑 다음 차의 출발지점과 비교해서 다음 차의 출발지점이 min값 보다 더 크면 카메라를 추가해준다.
                min = r[1]; //min에는 다음 차의 도착 지점을 넣는다.
                cnt++;
            }
        }

        return cnt;
    }
}
