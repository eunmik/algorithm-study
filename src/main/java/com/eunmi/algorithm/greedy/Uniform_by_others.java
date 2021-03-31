package com.eunmi.algorithm.greedy;

public class Uniform_by_others {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n;

        for(int i = 0; i < lost.length; i++) {
            boolean rent = false;
            int j = 0;
            while(!rent) {
                if(j == reserve.length)
                    break;
                if(lost[i] == reserve[j]) { //여유분 학생이랑 도둑맞은 학생이랑 같으면
                    reserve[j] = -1; rent=true;
                }
                else if(lost[i] - reserve[j] == 1 ){ //여유분 학생이 앞에 번호면
                    reserve[j] = -1; rent=true;
                }
                else if(lost[i] - reserve[j] == -1){  //여유분 학생이 뒤에 번호면
                    reserve[j] = -1; rent=true;
                }
                else{
                    j++;
                }
            }
            if(!rent) answer--;
        }
        return answer;
    }
}
