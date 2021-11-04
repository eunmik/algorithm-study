package com.eunmi.algorithm.category.recursive;

//팩토리얼 구현 예제
//팩토리얼은 1~부터 N까지를 차례대로 곱한 결과

//n! = 1 * 2 * 3 * ... * (n-1) * n
//수학적으로 0!과 1!의 값은 1입니다.
public class Factorial {

    //반복적으로 구현한 factorial
    public int factorial_iterative(int n){
        int result = 1;
        //1부터 N까지의 숫자를 차레대로 곱하기
        for (int i =1; i<=n; i++){
            result *=i;
        }
        return result;
    }

    //재귀적으로 구현한 factorial
    public int factorial_recursive(int n){
        if (n<=1){ //n이 1이하이면 1을 리턴
            return 1;
        }
        // n! = n* (n-1)!
        return n * factorial_recursive(n - 1);
    }

    public static void main(String[] args){
        Factorial f = new Factorial();
        int n = 2; // 1 * 2 * 3 * 4 * 5
        System.out.println(f.factorial_iterative(n));
        System.out.println(f.factorial_recursive(n));
    }
}
