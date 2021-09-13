package com.eunmi.algorithm.practices.KaKaoBlind2022;

import java.util.Stack;

//테스트 1, 11에서 계속 시간 초과 ㅠㅠ 제한 시간 10초
//long -> double로 바꿔주니깐 11은 해결

public class 소수확인 {
    public static void main(String[] args){
        소수확인 s = new 소수확인();
        //System.out.println(s.solution(110011, 10));
        long startTime = System.currentTimeMillis();
        System.out.println(s.solution(9999999, 3));
        System.out.println("Elapsed Time");
        System.out.println((double)(System.currentTimeMillis() - startTime)/1000);
    }
    // n을 k 진수로 바꿔 준다.
    //바꿔준 수를 0으로 나눈다.
    //조건을 확인 한다.
    //  1. 0P0 2. 0P 3. P0 4. P

    public int solution(int n, int k) {
        int result = 0;
        String prime = change(n, k);
        String[] splitZero = prime.split("0");

        for(String sp : splitZero){
            if(!sp.equals("")){
                if(sp.equals("1")){
                    continue;
                }else if (sp.equals("2") || isPrime(sp)){
                    result++;
                }
            }
        }

        return result;
    }
    //k진수로 바꿔주는 함수
    public String change(int n, int k){

        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int mod = n % k;
            n = n / k;
            sb.append(mod);
        }
        return sb.reverse().toString(); //211020101011
    }
    //소수인지 확인하는 함수
    public boolean isPrime(String strPrime){
        double prime = Double.parseDouble(strPrime);

        double n = 2;
        while (n < 20) {
            if (prime % n == 0) {
                return false;
            }
            n++;
            n = (n % 2 == 0 ? n + 1 : n);

        }
        return true;
    }
}
