package com.eunmi.algorithm.category.문자열;

import java.util.List;

public class KMPAlgorithm {
    static int[] makeTable(String pattern) {
        int patternSize = pattern.length();
        int[] table = new int[patternSize];
        int j =0;
        for (int i = 1; i<patternSize; i++) {
            while(j>0 && pattern.charAt(i) != pattern.charAt(j)) {  //i번째 문자와 j번째 문자가 일치 하지 않는다면
                System.out.println("[while] j : "+j+" ,i : "+i);
                j = table[j - 1]; //j를 j뒤에 인덱스로 이동한다.
                print(table, pattern);

            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                System.out.println("[if] j : "+j+" ,i : "+i);
                table[i] = ++j;
                print(table, pattern);

            }
        }
        return table;
    }

    public static void KMP(String parent, String pattern){
        int[] table = makeTable(pattern);
        System.out.println("============KMP=========");
        int parentSize = parent.length();
        int patternSize = pattern.length();
        int j = 0;
        for(int i =0; i< parentSize; i++){
            while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
                System.out.println("[while] j : "+j+" ,i : "+i);
                j = table[j - 1];
                print2(table, pattern, parent);
            }
            if (parent.charAt(i) == pattern.charAt(j)) {
                System.out.println("[if] j : "+j+" ,i : "+i);
                if(j == patternSize -1 ){
                    System.out.println((i- patternSize +2) + "번 째에서 찾았습니다.");
                    j = table[j];
                } else {
                    j++;
                }
                print2(table, pattern, parent);
            }
        }
    }
    public static void main(String[] args){
        String parent = "abababcd";
        String pattern = "abcd";
        //int[] table = makeTable(pattern);
        KMP(parent, pattern);
//        for(int i =0; i<table.length; i++){
//            System.out.print(table[i]+" ");
//        }
    }

    static void print(int[] table, String pattern){
        for(int i =0; i<table.length; i++){
            System.out.print(table[i]+" ");
        }
        System.out.println();
        for(int i =0; i<table.length; i++){
            System.out.print(pattern.charAt(i)+" ");
        }

        System.out.println();
        System.out.println("-------------------");
    }

    static void print2(int[] table, String pattern, String parent){
        for(int i =0; i<table.length; i++){
            System.out.print(table[i]+" ");
        }
        System.out.println();
        for(int i =0; i<pattern.length(); i++){
            System.out.print(pattern.charAt(i)+" ");
        }
        System.out.println();
        for(int i =0; i<parent.length(); i++){
            System.out.print(parent.charAt(i)+" ");
        }

        System.out.println();
        System.out.println("-------------------");
    }
}
