package com.eunmi.algorithm.practices.a210802;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/72411
public class 메뉴리뉴얼 {

    public static void main(String[] args){
        메뉴리뉴얼 m = new 메뉴리뉴얼();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        String[] result = m.solution(orders, course);
        for(String r : result){
            System.out.println(r);
        }
    }
    static HashMap<String,Integer> map;
    static int m;
    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int c : course){
            map = new HashMap<>();
            m=0;
            for(String o : orders){
                find(0, "", c, 0, o);
            }
            for (String s : map.keySet()){
                if (map.get(s)==m&&m>1){
                    pq.offer(s);
                }
            }
        }
        String  ans[] = new String[pq.size()];
        int k=0;
        while (!pq.isEmpty()){
            ans[k++] = pq.poll();
        }
        return ans;
    }
    static void find(int cnt,String str,int targetNum,int idx,String word){
        if (cnt==targetNum){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps="";
            for (int i=0;i<c.length;i++)temps+=c[i];
            map.put(temps,map.getOrDefault(temps,0)+1);
            m = Math.max(m,map.get(temps));
            return;
        }
        for (int i=idx;i<word.length();i++){
            char now =word.charAt(i);
            find(cnt+1,str+now,targetNum,i+1,word);
        }
    }
}
