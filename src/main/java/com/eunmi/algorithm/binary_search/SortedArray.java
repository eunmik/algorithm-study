package com.eunmi.algorithm.binary_search;

/**
 * N개의 원소를 포함하고 있는 수열이 오름차순으로 정렬되어 있습니다. 이때 이 수열에서 X가 등장하는 횟수를 계산하세요.
 * 예를 들어 수열 {1,1,2,2,2,3}이 있을 때 x=2라면, 현재 수열에서 값이 2인 원소가 4개이므로 4를 출력합니다.
 * 단, 이문제는 시간 복잡도O(logN)으로 알고리즘을 설계하지 않으면 시간 초과 판정을 받습니다.
 */
public class SortedArray {


    static int n;
    static int x;
    static int[] num;
    public static void main(String[] args) throws Exception{
        SortedArray s = new SortedArray();
        int[] array = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;

        num = new int[n];

        int first = binary_search_first(0, n-1, x);
        int last = binary_search_last(0, n-1, x);

        if(first == -1 || last == -1) {
            System.out.println(-1);
        }
        else {
            System.out.println(last - first + 1);
        }
    }

    public static int binary_search_first(int start, int end, int target) {

        int middle; // 중간값

        while(start <= end) {
            middle = (start + end) / 2;

            if(num[middle] > target) {
                // 왼쪽을 탐색해야겠구나
                end = middle - 1;
            }
            else if(num[middle] < target) {
                // 오른쪽을 탐색해야겠구나
                start = middle + 1;
            }
            else {
                // 찾았다
                while(true) {
                    if(middle == 0 || num[middle - 1] != num[middle]) {
                        // middle이 0이면 어차피 첫 번째 값이니까 그대로 리턴
                        // num[middle - 1]이 현재 num[middle]과 다르다면 현재 middle 리턴
                        return middle;
                    }
                    else {
                        // 그게 아니라면 middle을 -1
                        middle -= 1;
                    }
                }


            }
        }
        return -1; // 찾는 것이 없음

    }

    public static int binary_search_last(int start, int end, int target) {
        int middle; // 중간값

        while(start <= end) {
            middle = (start + end) / 2;

            if(num[middle] > target) {
                // 왼쪽을 탐색해야겠구나
                end = middle - 1;
            }
            else if(num[middle] < target) {
                // 오른쪽을 탐색해야겠구나
                start = middle + 1;
            }
            else {
                // 찾았다
                while(true) {
                    if(middle == n - 1 || num[middle] != num[middle + 1]) {
                        // middle이 n이라면 어차피 마지막 원소니까 그대로 리턴
                        // 현재 num[middle]이 num[middle + 1]과 다르다면 현재 middle 리턴
                        return middle;
                    }
                    else {
                        // 그게 아니라면 middle을 -1
                        middle += 1;
                    }
                }
            }
        }
        return -1; // 찾는 것이 없음
    }


}
