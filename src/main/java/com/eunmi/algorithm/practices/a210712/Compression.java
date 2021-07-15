package com.eunmi.algorithm.practices.a210712;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//  https://programmers.co.kr/learn/courses/30/lessons/17684

/**
 * TOBEORNOTTOBEORTOBEORNOT  [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
 * KAKAO  [11, 1, 27, 15]
 * ABABABABABABABAB  [1, 2, 27, 29, 28, 31, 30]
 */
public class Compression {
    static List<Integer> list = new ArrayList<>();
    static Map<String, Integer> dict = new LinkedHashMap<>();
    public static void main(String[] args){
        Compression c = new Compression();
        String msg = "ABABABABABABABAB";
        int[] result = c.solution(msg);
        for(int r : result){
            System.out.print(r);
            System.out.print(", ");
        }

    }
    public static int[] solution(String msg) {

        char alphabet = 65;
        //사전을 만들어준다.
        for(int i=0; alphabet<91; i++){
            dict.put(Character.toString(alphabet), i+1);
            alphabet += 1;
        }

        char[] msgCharArray = msg.toCharArray();
        int i = dictionary(msgCharArray, 0);
        while(i<msgCharArray.length){
            i = dictionary(msgCharArray, i);
        }

        int[] answer = list.stream().mapToInt(j->j).toArray();
        return answer;
    }

    public static int dictionary(char[] msgCharArray, int i){
        boolean isExist = true;
        //int i = 0;
        String key = String.valueOf(msgCharArray[i]);
        String availableKey = "";
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(dict.entrySet());
        int lastElement = entryList.get(entryList.size() - 1).getValue();
        while(isExist){
            if(dict.get(key) == null){
                dict.put(key, lastElement+1);
                isExist = false;
            }else {
                i++;
                availableKey = key;
                if(i>= msgCharArray.length){ //마지막
                    break;
                }
                key += String.valueOf(msgCharArray[i]);
            }
        }

        list.add(dict.get(availableKey));
        return i;
    }

    //다른 사람 풀이
    public int[] solution2(String msg) {
        ArrayList<String> dic = new ArrayList<String>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0 ; i < 26; i++) {
            dic.add(String.valueOf((char)('A'+i)));
        }

        for(int i = 0 ; i < msg.length() ; i++) {
            for(int j = dic.size()-1 ; j >= 0 ; j--) {
                if(msg.substring(i).startsWith(dic.get(j))) {
                    i += dic.get(j).length()-1;
                    result.add(j+1);
                    if(i+1 < msg.length())
                        dic.add(dic.get(j)+msg.charAt(i+1));
                    break;
                }
            }
        }

        int[] answer = new int[result.size()];

        for(int i = 0 ; i < result.size() ; i++)
            answer[i] = result.get(i);

        return answer;
    }
}
