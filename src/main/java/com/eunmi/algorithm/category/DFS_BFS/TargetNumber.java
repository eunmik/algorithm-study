package com.eunmi.algorithm.category.DFS_BFS;


/* https://programmers.co.kr/learn/courses/30/lessons/43165
* 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
* 각 숫자는 1 이상 50 이하인 자연수입니다.
* 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
* */
public class TargetNumber {
    static int cnt = 0;
    public static void main(String[] args){
        TargetNumber t = new TargetNumber();
        int[] numbers = {1, 1, 1, 1, 1};
        int result = t.solution(numbers, 3);
        System.out.println(result);
        System.out.println("cnt: :"+cnt);

    }
    public int solution(int[] numbers, int target) {
        //{1,1,1,1,1}
        int answer = 0;
        int current = numbers[0]; //1
        answer += dfs(current, 1, numbers, target); //1, 1, {1,1,1,1,1}, 3
        answer += dfs(-current, 1, numbers, target);
        return answer;
    }

    public int dfs(int prev, int index, int[] numbers, int target){
        cnt++;
        if(index >= numbers.length){
            if(target == prev){
                return 1;
            }
            return 0;
        }

        int cur1 = prev + numbers[index];
        int cur2 = prev - numbers[index];

        int ans = 0;
        ans += dfs(cur1, index+1, numbers, target);
        ans += dfs(cur2, index + 1, numbers, target);

        return ans;
    }

    public int solution2 (int[] numbers, int target) {
        int answer = 0;
        answer = dfs2(numbers, 0, 0, target);
        return answer;
    }
    int dfs2(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs2(numbers, n + 1, sum + numbers[n], target) +
                dfs2(numbers, n + 1, sum - numbers[n], target);
    }


}
