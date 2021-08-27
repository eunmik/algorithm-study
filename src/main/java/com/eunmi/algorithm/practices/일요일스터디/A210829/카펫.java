package com.eunmi.algorithm.practices.일요일스터디.A210829;

/**
 * 푼 날짜 : 2021-08-27
 * 푼 시간 : 09:54~ 11:19 1h25 걸림!
 */
//https://programmers.co.kr/learn/courses/30/lessons/42842
public class 카펫 {
    public static void main(String[] args) {
        카펫 c = new 카펫();
        int[] result = c.solution(8, 1);
        System.out.println(result[0] + " :" + result[1]);
    }

    public int[] solution(int brown, int yellow) {

        int[] factors = new int[2];
        boolean[] visited = new boolean[yellow + 1];

        for (int i = 1; i < yellow+1; i++) {
            int factor = yellow;
            if (i == factor) {
                factors[0] = i + 2;
                factors[1] = factor + 2;

                int[] result = getBrown(factors, yellow, brown);
                if(result != null) {
                    return result;
                }
                break;
            } else {
                if (factor % i == 0) {
                    factor = factor / i;
                    if (!visited[i] && !visited[factor]) {

                        factors[0] = i + 2;
                        factors[1] = factor + 2;
                        visited[i] = true;
                        visited[factor] = true;
                        int[] result = getBrown(factors, yellow, brown);
                        if(result != null) {
                            return result;
                        }
                    }
                }
            }
        }
        return null;

    }
    public int[] getBrown(int[] factors, int yellow, int brown){
        if ((factors[0] * factors[1]) - yellow == brown) {
            if (factors[0] < factors[1]) {
                int tmp = factors[1];
                factors[1] = factors[0];
                factors[0] = tmp;
            }
            return factors;
        }
        return null;
    }
}

