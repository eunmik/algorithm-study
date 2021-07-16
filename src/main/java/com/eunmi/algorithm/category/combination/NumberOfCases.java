package com.eunmi.algorithm.category.combination;

//경우의 수를 구해보자.
public class NumberOfCases {
    public static void main(String[] args){
        //System.out.println(combination(3,2)); //3
        /**
         * (1,2,3) -> (1,2),(1,3),(2,3)
         */
        //comb2(new int[]{1,2,3}, new boolean[3], 0, 3, 2);
        combi3(new int[]{1,2,3}, 0, 3, 2, 0);


    }
    //조합의 경우의 수 구하기
    public static int combination(int n, int r){
        if(n == r || r == 0)
            return 1;
        else
            return combination(n - 1, r - 1) + combination(n - 1, r);
    }

    //백트래킹
    static void comb1(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            print(arr, visited);
            return;
        } else {
            for(int i = start; i<n;i++){
                visited[i] = true;
                comb1(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    //재귀
    static void comb2(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            print(arr, visited);
            return;
        }
        if (depth == n) {
            return;
        } else {
            visited[depth] = true;
            comb2(arr, visited, depth + 1, n, r - 1);

            visited[depth] = false;
            comb2(arr, visited, depth + 1, n, r);
        }
    }

    //visited 배열을 쓰지 않고 정수 변수 index로 판별해 구해보기
    static void combi3(int[] arr, int index, int n, int r, int target){
        if( r== 0) {
            for (int i = 0; i < index; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");

        } else if (index == n){
          return;
        } else {
          //  arr[index] = target;
            combi3(arr, index + 1, n, r - 1, target + 1);
            combi3(arr, index, n, r, target + 1);
        }
    }


    static void print(int[] arr, boolean[] visited){
        for(int i=0; i<arr.length; i++){
            if(visited[i] == true){
                System.out.print(arr[i] + " ");
            }

        }System.out.println();
    }


}
