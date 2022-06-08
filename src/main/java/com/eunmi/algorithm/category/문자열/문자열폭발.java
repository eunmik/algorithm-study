package com.eunmi.algorithm.category.문자열;

//https://www.acmicpc.net/problem/9935

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 푼 날짜 : 2021-11-05
 * 푼 시간 :
 * 메모리 초과... -> repliaceAll때문에 O(N^2)의 시간복잡도를 가지기 때문이다.
 * 아직 해결 못함 ㅠ
 */
public class 문자열폭발 {
    public static void main(String[] args) throws Exception {
        //남아있는 문자가 없는 경우 "FRULA" 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str_array = br.readLine();
        String bomb = br.readLine();
        System.out.println(containsBobmb(str_array, bomb));

    }

    public static String containsBobmb(String array, String bomb){
        StringBuilder sb = new StringBuilder();
        String[] tmp = array.split(bomb);
        for(String t : tmp){
            sb.append(t);
        }
        //if(sb.toString().contains(bomb)){
        if(findString(sb.toString(), bomb)){
            return containsBobmb(sb.toString(), bomb);
        }else if(sb.length() == 0){
            return "FRULA";
        }else {
            return sb.toString();
        }

    }

    public static boolean findString(String array, String bomb){
        int arraySize = array.length();
        int bombSize = bomb.length();
        for(int i =0; i<=arraySize-bombSize; i++){
            boolean found = true;
            for(int j=0; j<bombSize; j++){
                if (array.charAt(i + j) != bomb.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if(found) return true;
        }
        return false;
    }
}
