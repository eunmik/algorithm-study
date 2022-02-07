package com.eunmi.algorithm.category.greedy;

import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        구명보트 a = new 구명보트();
        int[] people = {10,20,30,40,50,60,70,80,90};
        int limit = 100;
        System.out.println(a.solution(people, limit));
    }
    public int solution(int[] people, int limit){
        //100 {10,50,30,20) 50,30,20,10
         //0, 70, 30,0
        int cnt = 0;
        for(int i =0; i<people.length; i++){
            int pplOnBoat = people[i];
            people[i] = 0;
            int j = i+1;
            if(pplOnBoat != 0) {
                while (j < people.length) {
                    if (people[j] != 0 && pplOnBoat + people[j] <= 100) {
                        pplOnBoat = +people[j];
                        people[j] = 0;
                    }
                    j++;
                }
                cnt++;
            }
        }
        return cnt;

    }
}
