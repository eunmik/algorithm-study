package com.eunmi.algorithm.hash;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Runner {
    /***
     * 제한사항
     * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
     * completion의 길이는 participant의 길이보다 1 작습니다.
     * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
     * 참가자 중에는 동명이인이 있을 수 있습니다.
     */
    public static void main(String[] args){
        Runner test = new Runner();
        String[] participants = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String result = test.getParticipantNotCompleted(participants, completion);
        System.out.println(result);


    }
    public String getParticipantNotCompleted(String[] participants, String[] completion) {

        HashMap<String, Integer> duplicateCheck = new HashMap<String, Integer>();
        HashMap<String, Integer> completedCheck = new HashMap<String, Integer>();
        ArrayList<String> resultList = new ArrayList();
        String result = null;

        //participatns에 동명이인이 있는 지 확인하는 for문
        for(String participant : participants) {
            if(duplicateCheck.get(participant) == null){ //duplicateCheck 테이블에 값이 없으면 0
                duplicateCheck.put(participant, 1);
            }else { //값이 있으면 +1, 즉 동일한 이름의 participant가 존재
                duplicateCheck.put(participant, duplicateCheck.get(participant).intValue()+1);
            }
        }

        //completion에 동명이인이 있는지 확인을 위한 for 문
        for(String completed: completion){
            if(completedCheck.get(completed) == null){ //completedCheck 테이블에 값이 없으면 0
                completedCheck.put(completed, 1);
            }else { //값이 있으면 +1, 즉 동일한 이름의 completed가 존재
                completedCheck.put(completed, completedCheck.get(completed).intValue() + 1);
            }
        }

        for(Map.Entry entry : duplicateCheck.entrySet()) { //참가자 명단에서
            String participant = entry.getKey().toString(); //참가자 이름
            int completedValue;
            if(completedCheck.get(participant) ==null){ //완주자 이름에 참가자가 없으면
                completedValue = 0;
            }else { //완주자 이름에 참가자가 있으면
                completedValue = completedCheck.get(participant).intValue(); //duplicateValue보다 클 수가 없다.
            }
            int duplicateValue = duplicateCheck.get(participant).intValue();

            int valueResult = duplicateValue - completedValue;

            if(valueResult >= 1  ){ //2명 이상의 동명이인 중 미완주자가 있다면
                return participant;
                /*for(int i =1; i <= valueResult; i++){ 미완주자가 여러명일때 생각해서 arrayList를 return 했는데 프로그래머스는 String return을 원하니깐!
                    resultList.add(participant);
                }*/
            } else if(valueResult == 0){ //동명이인이 없고 완주했다면
                continue;
            }

        }
        return result;

    }
}
