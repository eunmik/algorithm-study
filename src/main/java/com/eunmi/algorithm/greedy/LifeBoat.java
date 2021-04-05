package com.eunmi.algorithm.greedy;

import java.util.Arrays;

public class LifeBoat {
    public static void main(String[] args){
        //[70,80,50,50] limit 100
        //[10,20,30,40,50,60,70,80,90] limit 100 => 5
        LifeBoat b = new LifeBoat();
        //int[] people = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int[] people = {70,80,50,50};


        System.out.println(b.solution_by_others(people, 100));
    }

    public int solution(int[] people, int limit){
        int answer=1;
        Arrays.sort(people); //오름차순으로 정렬 [50,50,70,80]
        //List<Integer> lifeBoat = new ArrayList<>();
        int lifeBoat = 0;
        for(int p : people){
            int space = limit-lifeBoat;
            if(space !=0 && space >= p){
                lifeBoat+=p;
            }else{
                answer++;
                lifeBoat=p;
            }
        }
        return answer;
    }

    public int solution_by_others(int[] people, int limit){
        int answer=0;
        Arrays.sort(people); //오름차순으로 정렬
        int l =0; //처음
        int r = people.length-1; //끝
        while(l<r){
            int sum = people[l] + people[r]; //가장 작은수와 가장큰수를 더한다.
            if(sum>limit){ //limit을 넘는다면 첫번째 수만 배에 태우기 때문에 다음 수로 향한다
                r--;
            }else { //limit을 넘지 않는다면 첫번째 수와 마지막수를 배에 태우기 때문에 양끝에서 다음수로 향하도록 한다.
                l++;
                r--;
            }
            answer++;
        }
        if(l==r) answer++; //만약 계산되지 않은 마지막 숫자가 남았아면, 혼자 배를 타니깐 answer를 추가한다.

        return answer;
    }
}
