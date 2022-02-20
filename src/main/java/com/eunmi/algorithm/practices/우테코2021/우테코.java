package com.eunmi.algorithm.practices.우테코2021;

import java.util.HashMap;
import java.util.Map;

public class 우테코 {
    public static void main(String[] args){
        우테코 a = new 우테코();
       // int[] arr = {2, 1, 3, 1, 2, 1};
        int[] arr = {1};
        int[] result = a.solution(arr);
        for(int r : result){
            System.out.println(r);
        }


    }
    public int[] solution(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i : arr){
            if(map.isEmpty() || map.get(i) == null){
                map.put(i, 1);
            }else {
                map.put(i, map.get(i)+1);

            }
            max = Math.max(max, map.get(i));
        }
        int[] result = new int[3];
        for(int i =1; i<4; i++){
            if(map.get(i) == null) {
                result[i-1] = max;
            }else if(map.get(i) < max){
                    result[i - 1] = max - map.get(i);
            }

        }
        return result;

    }
}
