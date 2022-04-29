package com.eunmi.algorithm.category.sort;

public class CountingSort {
    public static void main(String[] args) {
        int N = 5;
        int[] array = new int[N]; //elements : 100
        int[] counting = new int[31]; //number range : 0~30
        int[] sortedArray = new int[N];

        for (int i = 0; i<array.length; i++){
            array[i] = (int) (Math.random() * 31);
        }

        //Counting sort
        //Step 1
        for(int i =0; i<array.length; i++){
            counting[array[i]]++;
        }

        //Step 2
        for(int i=1; i<counting.length; i++){
            counting[i] += counting[i - 1];
        }

        //Step 3
        for(int i= array.length -1; i>=0; i--){
            int value = array[i];
            counting[value]--;
            sortedArray[counting[value]] = value;
        }

        System.out.println("array[]");
        for(int i =0; i<array.length; i++){
            if(i%10 == 0) System.out.println();
            System.out.print(array[i] + "\t");
        }
        System.out.println("\n\n");

        System.out.println("counting[]");
        for(int i =-0; i<counting.length;i++){
            if(i%10 == 0) System.out.println();
            System.out.print(counting[i] + "\t");
        }
        System.out.println("\n\n");

        System.out.println("sortedArray[]");
        for(int i =-0; i<sortedArray.length;i++){
            if(i%10 == 0) System.out.println();
            System.out.print(sortedArray[i] + "\t");
        }
        System.out.println("\n\n");
    }
}
