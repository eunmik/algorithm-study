package com.eunmi.algorithm.category.brute_force;

import java.util.ArrayList;

public class Exams {

    /**
     * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
     * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
     * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ..
     * 시험은 최대 10,000문제
     */
    public static void main(String[] args){
        Exams ex = new Exams();
        int[] answers = {1, 2, 3, 4, 5, 6};
        int[] result = ex.solution(answers);
        for(int r : result){
            System.out.println(r);
        }
    }
    public int[] solution(int[] answers){

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int points_one = getCount(answers, one);
        int points_two = getCount(answers, two);
        int points_three = getCount(answers, three);

        int max = Math.max(Math.max(points_one, points_two), points_three);
        ArrayList<Integer> list = new ArrayList<>();
        if(max==points_one) list.add(1);
        if(max==points_two) list.add(2);
        if(max==points_three) list.add(3);

        int[] result = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }

    public static int getCount(int[] answers, int[] user){
        int[] user_answers = new int[answers.length];
        int cnt = 0;
        int answer_cnt = 0;
        for(int i=0; i<answers.length; i++){
            user_answers[i] = user[cnt];
            cnt++;
            if(cnt==user.length){
                cnt=0;
            }
            if(user_answers[i] == answers[i]){
                answer_cnt++;
            }
        }

        return answer_cnt;
    }


}
