package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/6603
 * Hint : 재귀
 */
public class 로또 {
    static List<List<Integer>> List;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.MAX_VALUE;
        sb = new StringBuilder();
        while(N != 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            List = new ArrayList<>();
            ArrayList<Integer> intArray = new ArrayList<>();
            for(int i =0; i<N; i++){
                intArray.add(Integer.parseInt(st.nextToken()));
            }
            for(int i=0; i<N; i++){
                solution(intArray, i);
            }

            Collections.sort(List, new Comparator<java.util.List<Integer>>() {
                @Override
                public int compare(java.util.List<Integer> o1, java.util.List<Integer> o2) {
                    for(int i =0; i<o1.size(); i++){
                        if(!o1.get(i).equals(o2.get(i))){
                            return o1.get(i) - o2.get(i);
                        }

                    }
                    return 0;
                }
            });

            for(int i=0; i<List.size(); i++){
                String result = List.get(i).toString().replaceAll("[\\[\\],]", "");
                sb.append(result+"\n");

            }
            sb.append("\n");
        }

        System.out.println(sb);




    }

    static void solution(ArrayList<Integer> array, int index){

        if(array.size() == 6){
            if(!List.contains(array)){
                List.add(array);
            }
            return;
        }
        ArrayList<Integer> tmp = (ArrayList<Integer>) array.clone();
        tmp.remove(index);
        for(int i =0; i<tmp.size(); i++){
            solution(tmp, i);
        }
        return;
    }
}
