package com.eunmi.algorithm.category.brute_force;

import java.util.ArrayList;
import java.util.List;

/**
 * 푼 날짜 : 2022-01-20
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 * 다시풀기!!!
 */
public class 소수찾기 {
    //경우의 수 만들기

    public static void main(String[] args) {
        소수찾기 a = new 소수찾기();
        String numbers = "002";
        System.out.println(a.solution(numbers));

    }

    public int solution(String numbers){
        char[] charArray = numbers.toCharArray();
        int charArrayLength = charArray.length;
        int[] intArray = new int[charArrayLength];
        for(int i =0; i<charArrayLength; i++){
            intArray[i] = charArray[i] - '0';
        }
        for(int i =1; i<=intArray.length; i++) {
            permutation(intArray, 0, charArrayLength, i);
        }
        int count = 0;
        for(String s : permutationResult) {
            if(isPrime(Integer.parseInt(s))){
                count ++;
            }
        }
        return count;

    }

    static boolean isPrime(int inputNumber){
        boolean isPrime = true;
        if(inputNumber <= 1){
            return false;
        }
        for(int i = 2; i <= inputNumber/2; i++){
            System.out.println("inputNumber : "+inputNumber +"  "+ i + "<" + (inputNumber / 2));
            if((inputNumber % i ) == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    // 순서 없이 n 개중에서 r 개를 뽑는 경우
// 사용 예시: permutation(arr, 0, n, 4);
    static List<String> permutationResult = new ArrayList<>();
    static void permutation(int[] arr, int depth, int arrLength, int numberToFind) {
        if (depth == numberToFind) {
            String result = "";
            for(int i =0; i<numberToFind; i++){
                result += String.valueOf(arr[i]);
            }
            if(!result.equals("0")){
                result = result.replaceAll("^0*", "").trim();
            }
            if(!result.equals("") && !permutationResult.contains(result)) {
                permutationResult.add(result);
            }

            return;
        }

        for (int i=depth; i<arrLength; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, arrLength, numberToFind);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}
