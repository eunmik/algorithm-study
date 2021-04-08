package com.eunmi.algorithm.greedy;

import java.util.*;

public class BigNumber {
    /** https://programmers.co.kr/learn/courses/30/lessons/42883?language=java **/
    public static void main(String[] args){
        BigNumber b = new BigNumber();
        //"87654321", 3, "87654"
        //"18765432", 3, "87654"
        //"99991" 3,   "99"
        //"11119" 3, "19"
        //"999" 2, "9"
        System.out.println(b.solution("99999999999999999", 9)); //9를 명시해서 continue

    }


    public String solution(String number, int k){
        String answer = "";
        char[] array = number.toCharArray(); //charArray로 바꿔주고
        Character[] c_array = new Character[array.length]; //Arrays.sort로 돌리기 위해 Character[] 에 넣어준다.
        List<Character> list = new ArrayList<>();

        for(int i=0; i<array.length; i++){
            c_array[i] = array[i];
            list.add(array[i]);
        }

        Arrays.sort(c_array, Comparator.reverseOrder()); //내림차순으로 정렬 --> TODO 정렬을 하면 안된디ㅏ.
        char bigNum = c_array[0];
        int bigNum_idx = 0;
        for(int i=0; i<array.length; i++){ //제일 큰수의 인덱스를 구한다.
            if(array[i] == bigNum){
                bigNum_idx = i;
                break;
            }
        }
        char[] front = Arrays.copyOf(array, bigNum_idx); //큰수를 기준으로 앞에있는 숫자의 정렬
        char[] back = Arrays.copyOfRange(array, bigNum_idx + 1, array.length); //뒤에있는 숫자의 정렬
        if(front.length > k) { //K보다 font[]의 사이즈가 크면
            Arrays.sort(front);
            for(int i =0; i< k; i++){
                for(int j=0; j<list.size(); j++) {
                    if (front[i] == list.get(j)) {
                        list.remove(j);
                        break;
                    }
                }
            }
        }else if(front.length < k){
            if(front.length!=0){
                for(int i =0; i< front.length; i++){
                    list.remove(i);
                }
                k = k - front.length;
            }

            Arrays.sort(back);
            for(int i =0; i< k; i++){
                for(int j=0; j<list.size(); j++) {
                    if (back[i] == list.get(j)) {
                        list.remove(j);
                        break;
                    }
                }
            }
        }

        for(Character c : list){
            answer += c + "";
        }

        return answer;

    }
}
