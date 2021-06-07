package com.eunmi.algorithm.pokemon;

import java.util.*;

public class Pokemon {
    public static void main(String[] args){
        Pokemon p = new Pokemon();
        int[] pokemons = {3,1,2,3};
        System.out.println(p.solution(pokemons));

    }
    public int solution(int[] nums){
        int possession = nums.length/2;
        Set<Integer> kindList = new HashSet<>();

        for(int i : nums){
            kindList.add(i);
        }


        return (kindList.size() >= possession) ? possession : kindList.size();
    }
}
