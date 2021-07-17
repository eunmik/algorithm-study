package com.eunmi.algorithm.practices.a210719;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/42888
public class OpenTalk {
     //["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
    //["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    public static void main(String[] args){
        OpenTalk op = new OpenTalk();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = op.solution(record);
        for(String s : result){
            System.out.println(s);
        }

    }

    public String[] solution(String[] record) {
        String enterMsg = "님이 들어왔습니다.";
        String leaveMsg = "님이 나갔습니다.";


        //map에 username 별로 데이터를 넣는다.
        Map<String, String> map = new LinkedHashMap<>();
        for(String r : record){
            StringTokenizer st = new StringTokenizer(r, " ");

            String order = st.nextToken();
            String username = st.nextToken();
            String nickName = "";
            if(st.hasMoreElements()){
                nickName = st.nextToken();
            }
            if(!nickName.equals("")){
                map.put(username, nickName);
            }


        }

        List<String> list = new ArrayList<>();
        //map에서 하나씩 꺼내서 메시지를 만든다.
        for(String r : record){
            StringTokenizer st = new StringTokenizer(r, " ");
            String order = st.nextToken();
            String username = st.nextToken();
            if(order.equals("Enter")){
                list.add(map.get(username) + enterMsg);
            }else if(order.equals("Leave")){
                list.add(map.get(username) + leaveMsg);
            }

        }
        String[] answer = new String[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;

    }
}
