package com.eunmi.algorithm.category.문자열;

//https://www.acmicpc.net/problem/5430

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 푼 날짜 : 2021-11-05
 * 푼 시간 : 2시간..?
 * 시간 초과... 또로록 ->
 *  시간초과에 대한 힌트
 *  reverse는 모든 원소를 다 훌어서 시간복잡도가 o(n)인 걸로 알고있습니다. 만약 RRRRRRRRRR......이라면? 이걸 다하면 어마어마하게 느리겠죠
 *  reverse의 횟수를 매우 줄일수있는 방법을 생각해보세요
 *
 *  50% 틀림.. -> 10넘어가는 숫자처리를 안함.. [1,2,3,4]만 하고 [12,442] 큰 숫자를 처리 안함
 */
public class AC {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
        while(T>0){
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine()); //배열에 들어있는 수의 개수
            String array_str = br.readLine();
            String[] array_char = array_str.substring(1, array_str.length()-1).split(",");
            //List<Character> list = new LinkedList<>();
            Deque<String> list = new LinkedList<>();

            int reverseCnt = 0;

            if(array_char.length != 0){
                for(int i =0; i<N; i++){
                    list.add(array_char[i]);
                }
            }
            StringBuilder result = new StringBuilder();
            boolean isError = false;
            for(int i =0; i<command.length(); i++){
                if(command.charAt(i) == 'R'){
                    //Collections.reverse(list);
                    reverseCnt++;
                }else if(command.charAt(i) == 'D'){
                    if(list.isEmpty()){
                        isError = true;
                        break;
                    }else if(reverseCnt%2 == 0){
                        list.pollFirst();
                    }else if(reverseCnt%2 != 0){
                        list.pollLast();
                    }
                }
            }


            if(!list.isEmpty()) {
                result.append("[");
                if ((reverseCnt % 2) != 0){ //홀수 이면
                    while(!list.isEmpty()) {
                        result.append(list.pollLast() + ",");
                    }
                }
                else {
                    while(!list.isEmpty()) {
                        result.append(list.pollFirst() + ",");
                    }
                }
                result.deleteCharAt(result.length() - 1);
                result.append("]");
            }else if(list.isEmpty()){
                if(isError){
                    result.append("error");
                }else {
                    result.append("[]");
                }

            }

            System.out.println(result);
            T--;


        }

    }
}
