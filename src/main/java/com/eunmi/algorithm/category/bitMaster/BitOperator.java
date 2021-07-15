package com.eunmi.algorithm.category.bitMaster;

public class BitOperator {
    public static void main(String[] args){

        System.out.println("2 << 3 = " + (2<<3));
        System.out.println("16 >> 3 = " + (16>>3));
        System.out.println("-16 >> 3 = " + (-16>>3));
        System.out.println("-16 >>> 3 = " + (-16>>>3));

        int N = 3;
        int M = 2;
        for(int j = 0 ; (1<<N) > j ; ++j) {
            System.out.print(j+ " ");
        }

    }

}
