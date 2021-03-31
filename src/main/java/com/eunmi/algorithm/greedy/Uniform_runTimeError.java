package com.eunmi.algorithm.greedy;

/** https://programmers.co.kr/learn/courses/30/lessons/42862
 * 제한사항
 * 전체 학생의 수는 2명 이상 30명 이하입니다.
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
 * 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 * **/
public class Uniform_runTimeError {
    public static void main(String[] args){
        Uniform_runTimeError u = new Uniform_runTimeError();
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        int result = u.solution(n, lost, reserve);
        System.out.println(result); //5
    }

    public int solution(int n, int[] lost, int[] reserve) {
        /**
         * n - lost.size();
         * if(lost[i] +1 or lost[i]-1 in reserve)
         *      n++;
         * **/
        U
        n = n - lost.length; //전체 학생 수 에서 도둑맞은 학생 수를 먼저 뺀다.
        for(int i =0; i<lost.length; i++) {
            int before = lost[i] - 1;
            int after = lost[i] + 1;
            for (int j = 0; j < reserve.length; j++) {
                if (before != 0 && reserve[j] == before || reserve[j] == after || lost[i] == reserve[j]) {
                    n++;
                    reserve[i] = 0;
                    break;
                }
            }
        }

        answer = n;
        return answer;
    }
}
