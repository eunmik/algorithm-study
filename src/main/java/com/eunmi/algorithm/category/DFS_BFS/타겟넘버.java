package com.eunmi.algorithm.category.DFS_BFS;

public class 타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target){
        return operation(numbers, 0, target, 0);

    }
    public static int operation(int[] numbers, int index, int target, int sum){
        if(index == numbers.length){
            if(sum == target){
                return 1;
            }else {
                return 0;
            }
        }
        return operation(numbers, index + 1, target, sum + numbers[index]) +
                operation(numbers, index + 1, target, sum - numbers[index]);
    }

}
