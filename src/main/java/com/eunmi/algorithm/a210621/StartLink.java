package com.eunmi.algorithm.a210621;

public class StartLink {
    public static void main(String... args){
        StartLink s = new StartLink();
        s.solution(4);
//        int[] arr = permutation(new int[]{1,2,3}, 0, 3, 3);
//        for(int r : arr){
//            System.out.println(r);
//        }
    }
    public void solution(int size){
        int[] numbers = new int[size];
        for(int i=0; i<size; i++){
            numbers[i] = i+1;
        }
        boolean[] visited = new boolean[4];

        //int[] arr = permutation(numbers, 0, numbers.length, numbers.length);


    }
    public void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
    public int[] permutation(int[] arr, int depth, int n, int r){
        if (depth == r){
            print(arr, r);
            return arr;
        }
        for(int i=depth; i<n; i++){
            arr = swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            arr = swap(arr, depth, i);
        }
        return null;

    }

    public int[] swap(int[] arr, int depth, int i){
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
        return arr;
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


 }
