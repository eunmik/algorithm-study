package com.eunmi.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/** https://programmers.co.kr/learn/courses/30/lessons/42860
 * 제한 사항
 * name은 알파벳 대문자로만 이루어져 있습니다.
 * name의 길이는 1 이상 20 이하입니다.
 * 맨 처음엔 A로만 이루어져 있습니다.
 *
 * ▲ - 다음 알파벳
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 * ▶ - 커서를 오른쪽으로 이동
 *
 * **/

//런타임 에러 발생.. .아마 indexoutofboundsexception인거 같다
public class JoyStick {
    public static void main(String[] args){
        //"JEROEN" 56
        //"JAN" 23
        //"BBBAAB" 9
        System.out.println(solution("JAAAAN"));
    }
    public static int solution(String name){

        /**
         * 커서 앞의 A의 갯수와 뒤의 A의 갯수를 비교했을 때 A의 갯수가 더 적은 쪽으로 커서 이동해야되는데....
         *
         */
        char[] chars = name.toCharArray();
        List<Integer> list = new ArrayList<>();
        int cnt=0;
        //A의 갯수가 있는 list를 만든다. {0,74,4,78} {0,J,AAAA,N} 맨처음 글자에서 앞으로 갈지 뒤로갈지 결정하기 위해 index[0]에 0추가해주었따.
        for(int i=0; i<chars.length; i++){
            if(i==0 && chars[i]!=65){ //맨처음 글자가 A가 아니면
                list.add(0);
                list.add((int) chars[i]);
            }else if(chars[i]==65){ //글자가 A 이면
                cnt++;
            }else if(chars[i]!=65){ //글자가 A가 아니면
                if(cnt!=0){
                    list.add(cnt);
                    cnt=0;
                }
                list.add((int)chars[i]);
            }
        }

        int cursor_move = 0;
        List<Integer> c = new ArrayList<>();
        //int[] c = new int[chars.length];
        int cursor = 1;

        while(true){
            int alphabet = list.get(cursor);
            if(alphabet > 65){ //알파벳이 A가 아니면

                if((alphabet - 65) > 12){ //N보다 크면
                    alphabet = 65 - alphabet +26;
                }else { //N보다 작으면
                    alphabet = alphabet - 65;
                }
                cursor_move += alphabet;
                c.add(cursor-1, list.get(cursor));
                //c[cursor-1] = list.get(cursor);
            }
            if(c.size()==chars.length){
                break;
            }
            if(list.size() ==1){
                break;
            }
            int beforeA = list.get(cursor - 1);
            int afterA = list.get(cursor + 1);
            if (beforeA < 65 && afterA < 65) { //앞뒤에 다 A가 있다면
                if (beforeA < afterA) {
                    cursor_move += 1 + beforeA;
                    while(true) {
                        if(beforeA==0){
                            break;
                        }
                        c.add(cursor-beforeA-1, 65);
                        //c[cursor-beforeA-1] = 65;
                        beforeA--;
                    }
                    while(true){
                        if(afterA==0){
                            break;
                        }
                        c.add(cursor + afterA-1, 65);
                        //c[cursor + afterA - 1] = 65;
                        afterA--;
                    }
                    if(cursor==1){
                        cursor=list.size()-1;
                    }else{
                        cursor--;
                    }

                } else { //앞뒤가 같은 숫자라면
                    cursor_move += 1 + afterA;
                    while(true){
                        if(afterA==0){
                            break;
                        }
                        c.add(cursor + afterA-1, 65);
                        afterA--;
                    }
                    while(true){
                        if(beforeA==0){
                            break;
                        }
                        c.add(cursor-beforeA-1, 65);
                        //c[cursor - afterA - 1] = 65;
                        beforeA--;
                    }
                    cursor++;
                }
            }else if(beforeA > 65 && afterA <65){ //뒤에는 A가 있고 앞에는 없으면 ex. JAANK
                cursor_move += 1 + afterA;
                while(true) {
                    if(afterA==0){
                        break;
                    }
                    c.add(cursor + afterA-1, 65);
                    //c[cursor + afterA - 1] = 65;

                    afterA--;
                }
                cursor++;
            }else if(beforeA > 65 && afterA > 65 || beforeA==0 && afterA > 65){
                cursor_move += 1;
                cursor++;

            }
        }

        return cursor_move;
    }
}
