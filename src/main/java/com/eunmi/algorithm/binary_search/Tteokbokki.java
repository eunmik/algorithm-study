package com.eunmi.algorithm.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tteokbokki {
    /**
     * 떡볶이 떡 만들기
     * 오늘 동빈이는 여행 가신 부모님을 대신해서 떡집 일을 하기로 했습니다.
     * 동빈이네 떡볶이 떡은 재밌게도 떡볶이 떡의 길이가 일정하지 않습니다.
     * 대신에 한 봉지 안에 들어가는 떡의 총 길이는 절단기로 잘라서 맞춰줍니다.
     * 절단기에 높이(H)를 지정하면 줄지어진 떡을 한 번에 절답합니다.
     * 높이가 H보다 긴 떡온 H 위의 부분이 잘릴 것이고, 낮은 떡은 잘리지 않습니다.
     * 예를 들어 높이가 19, 14, 10, 17cm인 떡이 나란히 있고 절단기 높이를 15cm로 지정하면 자른 뒤 떡의
     * 높이는 15,14,10,15cm가 될 것입니다. 잘린 떡의 길이는 차례대로 4,0,0,2cm입니다.
     * 손닙은 6cm만큼의 길이를 가져갑니다.
     * 손님이 왔을 때 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에
     * 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하세요.
     *
     * 입력 조건
     * 첫째 줄에 떡의 개수 N과 요청한 떡의 길이 M이 주어집니다.
     * (1 <= N <= 1,000,000 1<=M<=2,000,000,000)
     * 둘째 줄에는 떡의 개별 높이가 주어집니다.
     * 떡 높이의 총합은 항상 M 이상이므로, 손님은 필요한 양만큼 떡을 사갈 수 있습니다.
     * 높이는 10억보다 작거나 같은 양의 정수 또는 0 입니다.
     */
     public static void main(String[] args){
         Tteokbokki t = new Tteokbokki();
         int[] requested = {4, 6}; //[0]떡의 개수와 [1]요청한 떡의 길이
         int[] tteoks = {19, 15, 10, 17};
         System.out.println(t.solution(requested, tteoks));

     }
     public int solution(int[] requested, int[] tteoks){
         int answer = 0;
         int min = 0; //최솟값
         Arrays.sort(tteoks);
         int max = tteoks[tteoks.length-1]; //떡들 중 가장 긴 떡의 높이
         answer = binarySearch(requested, tteoks, min, max);

         return answer;
     }
     public int binarySearch(int[] requested, int[] tteoks, int min, int max){
         int sum = 0;

         if(min<=max) {
             int mid = (min+max) /2;
             for(int tteok : tteoks){
                 if(tteok - mid > 0)
                 sum += tteok - mid;
             }

             if(sum == requested[1]){
                 return mid;
             }
             if(sum > requested[1]){
                 //mid만 주어지면 이미 검색한거를 또하는 거인격
                 return binarySearch(requested, tteoks, mid+1, max);
             }else {
                 return binarySearch(requested, tteoks, min, mid-1);
             }

         }
         return -1;

     }
}
