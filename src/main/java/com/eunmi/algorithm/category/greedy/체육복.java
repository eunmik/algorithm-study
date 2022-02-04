package com.eunmi.algorithm.category.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 푼 날짜 : 2022-02-03
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 * Level 1
 */
public class 체육복 {
    /**
     *     //7, [2,4,5,6,7], [1,3,4,5,6,7] -> 7
     *     //4, [3,1,2], [2,4,3] -> 3
     *     //5, [1,2,3], [2,3,4] -> 4
     *
     */
    public static void main(String[] args) {
        체육복 a = new 체육복();
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};
        System.out.println(a.solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve){
        Map<Integer, Integer> studentsWithUniform = new HashMap<>();
        for(int r : reserve){
            studentsWithUniform.put(r, 2);
        }

        for(int lo : lost){
            studentsWithUniform.put(lo, studentsWithUniform.getOrDefault(lo, 0) -1);
        }

        for(int i =1; i<=n; i++){
            int student = studentsWithUniform.getOrDefault(i, 0);
            int frontStudent = studentsWithUniform.getOrDefault(i-1, 0);
            int backStudent = studentsWithUniform.getOrDefault(i+1, 0);
            if(student == 0) //1개만 있는 학생
            {
                studentsWithUniform.put(i, 1);
            }else if(student ==-1) //잃어버린 학생
            {
                if(frontStudent == 2){
                    studentsWithUniform.put(i, student + 1);
                    studentsWithUniform.put(i - 1, frontStudent - 1);
                }else if(backStudent == 2){
                    studentsWithUniform.put(i, student + 1);
                    studentsWithUniform.put(i + 1, backStudent - 1);
                }
            }
        }
        Iterator it = studentsWithUniform.keySet().iterator();
        while(it.hasNext()){
            if(studentsWithUniform.get(it.next()) == -1){
                it.remove();
            }
        }
        return studentsWithUniform.size();

    }
}
