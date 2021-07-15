package com.eunmi.algorithm.category.brute_force;

import java.util.ArrayList;
import java.util.List;

/** https://programmers.co.kr/learn/courses/30/lessons/42839 **/
public class PrimeNumber {

    private int cnt;
    private List<String> list = new ArrayList<>();


    public static void main(String[] args){
        PrimeNumber pn = new PrimeNumber();
        String numbers = "17";
        int result = pn.solution(numbers);
        System.out.println(result);


    }
    public void permutation(List<Character> arr, List<Character> result, int n, int r) {

        if (r == 0) {
            // 0으로 시작하는 부분집합은 제외
            if (result.get(0) != '0') {

                String str = "";
                int size = result.size();
                for (int i = 0; i < size; i++) { //result에 있는 숫자를 String으로 합쳐준다 ex. "1"+"7"="17"
                    str += result.get(i);
                }

                int num = 0;

                // 이미 나온 숫자 조합이 아닐 경우
                if (!list.contains(str)) {
                    num = Integer.parseInt(str);
                    list.add(str);

                    // 소수 판별
                    if (isPrime(num)) { //isPrime이 true이면
                        cnt++;
                    }
                }
            }

            return;
        }

        for (int i = 0; i < n; i++) {

            result.add(arr.remove(i)); //array에 있는 숫자를 지우고 result에 넣는다
            permutation(arr, result, n - 1, r - 1);
            arr.add(i, result.remove(result.size() - 1));
        }

    }


    public  static boolean isPrime(int num){
        //1 과 number만 나와야 한다.
        if(num == 1){
            return false;
        }
        for(int i =2; i<num; i++){ //1이랑 자기자신 숫자를 제외 했을때 나머지가 0이 나오면 소수가 아니다
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public int solution(String numbers){
        //String을 charArray로 바꿔준다.
        char[] charArray = numbers.toCharArray(); //{'1','7'}
        List<Character> arr = new ArrayList<>();
        for(char c : charArray){ //{'1'49, '7'55}
            arr.add(c);
        }

        List<Character> result = new ArrayList<>();
        for(int i=0; i<charArray.length; i++){
            permutation(arr, result, numbers.length(), i + 1);

        }
        return cnt;
    }

}
