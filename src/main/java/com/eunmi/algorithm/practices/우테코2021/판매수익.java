package com.eunmi.algorithm.practices.우테코2021;

import java.util.HashMap;
import java.util.Map;

public class 판매수익 {
    public static void main (String[] args){
        판매수익 a = new 판매수익();
        /*String[] ings = {"r 10", "a 23", "t 124", "k 9"};
        String[] menu = {"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
        String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};
        */
        String[] ings = {"x 25", "y 20", "z 1000"};
        String[] menu = {"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"};
        String[] sell = {"BBBB 3", "TTT 2"};

        System.out.println(a.solution(ings, menu, sell));
    }

    static Map<String, Integer> ingMap;
    public int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        //재료를 담고 있는 map을 만든다.
        ingMap = new HashMap<>();
        for(String i : ings){
            String[] ing = i.split(" ");
            ingMap.put(ing[0], Integer.parseInt(ing[1]));
        }

        //수익을 위한 map을 만든다.
        Map<String, Integer> dishMap = new HashMap<>();
        for(String m : menu){
            String[] dish = m.split(" ");
            String name = dish[0];
            String ingredients = dish[1];
            int price = Integer.parseInt(dish[2]);
            int ingTotal = buyIngs(ingredients);
            dishMap.put(name, price - ingTotal);
        }

        for(String s : sell){
            String[] sold = s.split(" ");
            answer += dishMap.get(sold[0]).intValue() * Integer.parseInt(sold[1]);
        }

        return answer;
    }

    public int buyIngs(String ingredients){
        String[] ings_arr = ingredients.split("");
        int totalPrice = 0;
        for(String c : ings_arr){
            totalPrice += ingMap.get(c).intValue();
        }
        return totalPrice;




    }
}
