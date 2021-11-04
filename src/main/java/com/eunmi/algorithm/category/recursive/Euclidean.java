package com.eunmi.algorithm.category.recursive;

//최대 공약수를 구하는 유클리드 호제법 알고리즘

//두 자연 수 A, B에 대하여 (A>B) A를 B로 나눈 나머지극 R이라고 할때
//A와 B의 최대 공약수는 B와 R의 최대 공약수와 같다.
public class Euclidean {
    int GCD(int A, int B){
        if(A%B == 0){
            return B;
        }
        int remainder = A%B;
        return GCD(B,remainder);
    }
    public static void main(String[] args){
        Euclidean e = new Euclidean();

        System.out.println(e.GCD(192, 162));
    }
}
