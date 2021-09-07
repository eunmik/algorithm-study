package com.eunmi.algorithm.practices.일요일스터디.A210912;

import java.util.*;

/**
 * 푼 날짜 : 2021-09-07
 * 푼 시간 : 10:42~17:00 중간중간 회의도하고~ 딴짓도 하고~
 */


//https://programmers.co.kr/learn/courses/30/lessons/42890
public class 후보키 {
    public static void main(String[] args) {
        후보키 k = new 후보키();
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}; //2
//        String[][] relation = {{"100","100","ryan","music","2"},{"200","200","apeach","math","2"},{"300","300","tube","computer","3"},{"400","400","con","computer","4"},{"500","500","muzi","music","3"},{"600","600","apeach","music","2"}}; //3
//        String[][] relation = {{"a","b","c"},{"1","b","c"},{"a","b","4"},{"a","5","c"}}; //1
//        String[][] relation = {{"a","1","4"},{"2","1","5"},{"a","2","4"}}; //2
        //String[][] relation = {{"a", "aa"}, {"aa", "a"}, {"a", "a"}}; //1
        //String[][] relation = {{"a","1","aaa", "c","ng"},{"b","1","bbb", "c","g"},{"c","1","aaa", "d","ng"},{"d","2","bbb", "d","ng"}}; //3
        //String[][] relation = {{"a","b","c","d","e","f"},{"f","d","c","d","d","f"},{"a","b","s","d","e","e"}}; //6

        System.out.println(k.solution(relation));

    }
    static Set<List<Integer>> set;
    public int solution(String[][] relation){
        //0,1,2,3
        int[] indeces = new int[relation[0].length];
        for(int i =0; i<indeces.length; i++){
            indeces[i] = i;
        }
        boolean[] visited = new boolean[indeces.length];
        set = new HashSet();
        for(int i =0; i<=indeces.length; i++){
            combination(indeces, visited, 0, indeces.length, i);
        }
        List<List<Integer>> sortedList = new ArrayList<List<Integer>>(set);
        Collections.sort(sortedList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();

            }
        });
        List<Integer[]> uniqueList = new ArrayList<>();
        for(List<Integer> list: sortedList){
            Integer[] arr = (Integer[]) list.toArray(new Integer[list.size()]);
            boolean isUnique =  checkUniqueness(relation, arr);
            if(isUnique){
                if(uniqueList.size() == 0 || checkMinimality(uniqueList, arr)){
                    uniqueList.add(arr);
                }
            }
        }

        return uniqueList.size();
    }
    public boolean checkMinimality(List<Integer[]> list, Integer[] candidate){
        Iterator<Integer[]> it = list.iterator();
        boolean result = true;
        while(it.hasNext()){
            Integer[] next = it.next();
            boolean[] checked = new boolean[next.length];
            for(int i =0; i<next.length; i++){
                String tmp = String.valueOf(next[i]);
                if(Arrays.toString(candidate).contains(tmp)){
                    checked[i] = true;
                }
            }
            if(!Arrays.toString(checked).contains("false")){
                result = false;
            }

        }
        return result;

    }
    public boolean checkUniqueness(String[][] relation, Integer[] index){
        Map<String, Integer> map = new HashMap<>();
        String tmp = "";
        for(int i =0; i<relation.length; i++){
            for(int j : index) {
                tmp += relation[i][j]+" ";
            }
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
            if(map.get(tmp) >= 2) {
                return false;
            }
            tmp = "";
        }
        return true;
    }

    //경우의 수 구하기
    void combination(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                if(visited[i] == true){
                    list.add(arr[i]);
                }

            }
            set.add(list);
            return;
        } else {
            for(int i = start; i<n; i++){
                visited[i] = true;
                combination(arr, visited, i+1, n, r-1);
                visited[i] = false;
            }
        }

    }
}
