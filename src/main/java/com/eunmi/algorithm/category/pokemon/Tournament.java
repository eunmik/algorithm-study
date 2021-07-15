package com.eunmi.algorithm.category.pokemon;

public class Tournament {
    public static void main(String[] args){
        Tournament t = new Tournament();
        System.out.println(t.solution(8, 4, 7));

    }
    public int solution(int n, int a, int b){
        //n/2 == 총 라운드 갯수
        //round(a/2) == 다음 라운드 숫자
        int totalRounds = n / 2;
        int currentRound = 1;
        int aNum = a;
        int bNum = b;
        while(totalRounds >= currentRound){
            aNum = (int) Math.ceil((double)aNum / 2);
            bNum = (int) Math.ceil((double)bNum / 2);
            if(aNum == bNum){
                break;
            }
            currentRound++;

        }
        return currentRound;
    }
}
