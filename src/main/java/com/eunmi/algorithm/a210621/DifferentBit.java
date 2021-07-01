package com.eunmi.algorithm.a210621;


//https://programmers.co.kr/learn/courses/30/lessons/77885
public class DifferentBit {
    public static void main(String... args) {
        DifferentBit d = new DifferentBit();
        long[] numbers = {2,7};
        long[] result = d.solutionUsingBitMask(numbers);
        for(long r : result){
            System.out.println(r);
        }
    }
    //01111101001
    //01111101010


    public long[] solution(long[] numbers) {

        long[] result = new long[numbers.length];

        //짝수일 땐 +1
        //홀수 일 땐 0이 한칸씩 뒤로
        String tmp = "";
        int i =0;
        for (long num : numbers) { //100 -> 101
            if (num % 2 == 0) { //짝수이면
                tmp = Long.toBinaryString(num);
                tmp = tmp.substring(0, tmp.length() - 1) + 1;
            }
            else { //111 -> 1011
                tmp = Long.toBinaryString(num);
                tmp = "0"+tmp;
                int index = tmp.lastIndexOf("0");
                tmp = tmp.substring(0,index)+"10"+tmp.substring(index+2);
            }
            result[i] = Long.parseLong(tmp,2);
            i++;

        }
        return result;
    }

    public long[] solutionUsingBitMask(long[] numbers){
        long[] answer = numbers.clone();
        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            answer[i] += (answer[i]^numbers[i])>>>2;
        }
        return answer;
    }
}

