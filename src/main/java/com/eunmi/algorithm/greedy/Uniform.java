package com.eunmi.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/** https://programmers.co.kr/learn/courses/30/lessons/42862
 * 제한사항
 * 전체 학생의 수는 2명 이상 30명 이하입니다.
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
 * 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 * **/
public class Uniform {
    /** 12번 테스트에서 실패....!!!! **/
    public static void main(String[] args){
        Uniform u = new Uniform();
        //7, [2,4,5,6,7], [1,3,4,5,6,7] -> 7
        //4, [3,1,2], [2,4,3] -> 3
        //5, [1,2,3], [2,3,4] -> 4
        int n = 5;
        int[] lost = {1,2,3};
        int[] reserve = {2,3,4};
        int result = u.solution(n, lost, reserve);
        System.out.println(result);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        /**
         * n - lost.size();
         * if(lost[i] +1 or lost[i]-1 in reserve)
         *      n++;
         * **/
        n = n - lost.length; //전체 학생 수 에서 도둑맞은 학생 수를 먼저 뺀다.
        List<Integer> list = new ArrayList<>();
        List<Integer> lostList = new ArrayList<>();
        for(int r : reserve){
            list.add(r);
        }
        for(int i : lost){
            lostList.add(i);
        }
        //먼저 reserve의 값이 lost에 있는지 확인, 왜냐하면 여유분 있는 학생들이 도난 당하면 옷을 빌려줄 수가 없기 때문에
        for(int i =0; i<lostList.size(); i++) {
            int num_lost = lostList.get(i);
            for (int j = 0; j < list.size(); j++) {
                if(num_lost == list.get(j)){
                    list.remove(j);
                    lostList.remove(i);
                    n++;
                    break;
                }
            }
        }
        for(int i =0; i<lostList.size(); i++) {
            int num_lost = lostList.get(i);
            int before = num_lost - 1;
            int after =num_lost + 1;
            for (int j = 0; j < list.size(); j++) {
                int compare = list.get(j);
                if (before != 0 &&
                        compare == before ||
                        compare == after ||
                        num_lost == compare) {
                    n++;
                    list.remove(j);
                    break;
                }
            }
        }

        return n;
    }
}
