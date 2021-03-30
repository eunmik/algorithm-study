package com.eunmi.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class Locations {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42748
     */
    static int cnt=0;
    public static void main(String[] args){
        Locations loc = new Locations();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = loc.solution(array, commands);
        for(int r : result){
            System.out.println(r);
        }

    }

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int[] c : commands){
            List<Integer> unsorted = new ArrayList<>();

            for(int i = c[0]-1; i <= c[1]-1; i++){ //unsorted list에 값을 집어넣었다
                unsorted.add(array[i]);
            }

            //quickSort(unsorted, 0, unsorted.size()-1); //정렬한다
            //insertionSort(unsorted);
            bubbleSort(unsorted);
            //selectionSort(unsorted);

            answer.add(unsorted.get(c[2]-1)); //지정된 인덱스에있는 값을 꺼낸다
        }
        int[] result = new int[answer.size()];
        for(int i =0; i<answer.size(); i++){ //int 배열로 바꿔준다다            result[i] = answer.get(i);
        }

        return result;
    }
    public static void quickSort(List<Integer> unsorted, int left, int right){
        /** unsorted = {5,2,6,3}
         * 1. left =0, right=3, if(0<3 true), i=0, j=3, pivot=unsorted[1]=2,
         *    while(0<3)
         *       while(3 > 2) j=2, while(6>2) j=1, while(2>2) false
         *       while(0<1, 5<2 false)
         *       temp = 5, unsorted[0]=2, unsorted[1]=5
         *  {2,5,6,3}
         *    while(0>1)
         *       while(5>2) j=0, while(2>2) false
         *       while(0<0, 2<2) false
         *       temp = 2, unsorted[0]=2, unsorted[0]=2
         *  {2,5,6,3}
         *  -------------
         *  unsorted = {2,5,6,3}
         *  2. left=0, right=-1, if(0<-1) false
         *  -------------
         *  unsorted = {2,5,6,3}
         *  3. left=1, right=3, if(1<3) true, i=1, j=3, pivot=6
         *     while(1<3)
         *       while(3>6) false
         *       while(1<3 && 5 < 6) i=2, while(2<3 && 6 < 6 false)
         *       temp = 6, unsorted[2]=3, unsorted[3]=6
         *   {2,5,3,6}
         *     while(2<3)
         *       while(6 > 6) false
         *       while(2<3 && 3<6) i=3, while(3<3) false
         *       temp=6, unsorted[3]=6, unsorted[3]=6
         *   {2,5,3,6}
         *  -------------
         *  unsorted = {2,5,3,6}
         *  4. left=1, right=2, if(1<2), i=1, j=2, pivot=5
         *     while(1<2)
         *       while(3>5) false
         *       while(1<2 && 5<5) false
         *       temp=5, unsorted[1]=3, unsorted[2]=5
         *   {2,3,5,6}
         *     while(1<2)
         *       while(5>5) false
         *       while(1<2 && 3<5) i=2
         *       temp=5, unsorted[2]=5, unsorted[2]=5
         *   {2,3,5,6}
         *  -------------
         *  unsorted = {2,3,5,6}
         *  5. left=1, right=1, if(1<1) false
         *  -------------
         *  unsorted = {2,3,5,6}
         *  6. left=3, right=2, if(3<2) false
         *  -------------
         *  unsorted = {2,3,5,6}
         *  7. left=4, right=3, if(4<3) false
         *  -------------
         **/
        int i, j, pivot, temp;

        System.out.println("left:"+left+" right:"+right+" cnt:"+cnt);
        if (left < right) {

            i = left;
            j = right;
            pivot = unsorted.get((left + right) / 2);
            //분할 과정
            while (i < j) {
                while (unsorted.get(j) > pivot) j--;
                // 이 부분에서 arr[j-1]에 접근해서 익셉션 발생가능함.
                while (i < j && unsorted.get(i) < pivot) i++;

                temp = unsorted.get(i);
                unsorted.set(i, unsorted.get(j));
                unsorted.set(j, temp);
            }
            cnt++;
            quickSort(unsorted, left, i - 1);
            cnt++;
            quickSort(unsorted, i + 1, right);

        }
    }

    public static void selectionSort(List<Integer> unsorted)
    {
        /** selection sort **/
        /** unsorted = {5,2,6,3}
         * 1. i=0, min=0, j=1,
         *      if(5>2 true) min=1;
         * 2. i=0, min=1, j=2
         *      if(2>6 false)
         * 3. i=0, min=1, j=3
         *      if(2>4 false)
         * 4. temp = 2, unsorted[1] = 5, unsorted[0] = 2, {2,5,6,3}
         * -------------------
         * 1. i=1, min=1, j=2
         *      if(5>6 false)
         * 2. i=1, min=1, j=3
         *      if(5>3 true) min=3
         * 3. temp=3, unsorted[3]=5, unsorted[1]=3, {2,3,6,5}
         * -------------------
         * 1. i=2, min=2, j=3
         *      if(6>5 true) min=3;
         * 2. temp=5, unsorted[3]=6, unsorted[2]=5, {2,3,5,6}
         */
            for(int i = 0; i<unsorted.size()-1; i++){
                int min = i;
                for(int j = i+1; j<unsorted.size(); j++){
                    if(unsorted.get(min) > unsorted.get(j)){
                        min=j;
                    }
                }
                int temp = unsorted.get(min);
                unsorted.set(min, unsorted.get(i));
                unsorted.set(i, temp);
            }

    }

    public static void bubbleSort(List<Integer> unsorted){
        /** bubble sort**/
        /** unsorted = {5,2,6,3}
         * 1. i=0, j=1, if(2<5 true), temp=5, unsorted[0]=2, unsorted[1]=5, {2,5,6,3}
         * 2. i=0, j=2, if(6<5 false)
         * 3. i=0, j=3, if(3<6 true), temp=6, unsorted[2]=3, unsorted[3]=6, {2,5,3,6}
         * ---------------
         * unsorted = {2,5,3,6}
         * 1. i=1, j=1, if(5<2 false)
         * 2. i=1, j=2, if(3<5 true), temp=5, unsorted[1]=3, unsorted[2]=5, {2,3,5,6}
         * ---------------
         * unsorted = {2,3,5,6}
         * 1. i=2, j=1, if(3<2 false)
         *
         */
            for(int i=0; i < unsorted.size()-1; i++){
                for(int j=1; j < unsorted.size()-i; j++){
                    if(unsorted.get(j) < unsorted.get(j-1)){
                        int temp = unsorted.get(j-1);
                        unsorted.set(j-1, unsorted.get(j));
                        unsorted.set(j, temp);
                    }
                }
            }
    }

    public static void insertionSort(List<Integer> unsorted){
        /** Insertion Sort **/
        /**
         * unsorted = {5,2,6,3}
         * 1. i=1, temp=2, aux=0, (0>=0, 5>2 => true) unsorted[1]=5, aux=-1, unsorted[0]=2, {2,5,6,3}
         * 2. i=2, temp=6, aux=1, (1>=0, 5 > 6 false) unsorted[2]=6, {2,5,6,3}
         * 3. i=3, temp=3, aux=2, (2>=0, 6 > 3 true) unsorted[3]=6, {2,5,6,6},| aux=1, (1>=0, 5 > 3 true) unsorted[2]=5,{2,5,5,6},| aux=0,(0>=0, 2 > 3 false),unsorted[1]=3, {2,3,5,6}
         *
         * **/
        for(int i = 1 ; i < unsorted.size() ; i++){
            int temp = unsorted.get(i);
            int aux = i - 1;

            while( (aux >= 0) && ( unsorted.get(aux) > temp ) ) {
                unsorted.set(aux+1, unsorted.get(aux));
                aux--;
            }
            unsorted.set(aux + 1, temp);
        }

    }
}
