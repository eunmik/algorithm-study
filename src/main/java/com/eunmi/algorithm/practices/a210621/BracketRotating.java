package com.eunmi.algorithm.practices.a210621;


import java.util.*;

public class BracketRotating {

    public static void main(String[] args){
        BracketRotating b = new BracketRotating();
        //String s = "[](){}";
        String s = "{{{}";
        //String s = "[(])"; // (])[ ])[) )[)]
        System.out.println(b.solution1(s)); //{{}{ {}{{ }}{}

    }

    public int solution1(String s){
        int answer = 0;
        for(int i=0; i<s.length();i++){
            Stack<String> st = new Stack();
            s = s.substring(1, s.length()) + s.substring(0,1);

            for(int j=0; j<s.length(); j++){
                String word = s.substring(j, j+1);
                if(st.isEmpty()) {
                    st.push(word);
                    continue;
                }

                if(word.equals(")") && st.peek().equals("(")){
                    st.pop();
                }else if(word.equals("}") && st.peek().equals("{")){
                    st.pop();
                }else if(word.equals("]") && st.peek().equals("[")){
                    st.pop();
                }else{
                    st.push(word);
                }
            }
            if(st.isEmpty()){
                answer++;
            }

        }
        return answer;
    }






    public int solution(String s) {
        Map<Integer, char[]> sampleMap = new HashMap();
        sampleMap.put(0, new char[]{'{', '}'});
        sampleMap.put(1, new char[]{'(', ')'});
        sampleMap.put(2, new char[]{'[', ']'});


        int cnt = 0;

        for(int c=0; c<s.length(); c++){
            int i = 0;

            boolean result = false;
            //char[] tmpS = s.toCharArray();
            String tmpS = s;
            while(true)
            {

                char front = sampleMap.get(i)[0];
                char rear = sampleMap.get(i)[1];

                if(tmpS.contains(String.valueOf(front))){

                    if(tmpS.contains(String.valueOf(rear))) { //bracket이 두 쪽 다 존재하면
                        result = (tmpS.indexOf(front) < tmpS.indexOf(rear)) ? true : false; //front의 rear의 index보다 작으면 cnt++
                        if(result){
                            String tmpStr = tmpS.substring(tmpS.indexOf(front), tmpS.indexOf(rear)-1);
                            boolean tmpResult = false;
                            if (tmpStr.contains(String.valueOf(sampleMap.get(0)[0]))) tmpResult = (tmpStr.indexOf(String.valueOf(sampleMap.get(0)[0])) < tmpS.indexOf(String.valueOf(sampleMap.get(0)[1]))) ? true : false;
                            if (tmpStr.contains(String.valueOf(sampleMap.get(1)[0]))) tmpResult = (tmpStr.indexOf(String.valueOf(sampleMap.get(1)[0])) < tmpS.indexOf(String.valueOf(sampleMap.get(1)[1]))) ? true : false;
                            if (tmpStr.contains(String.valueOf(sampleMap.get(2)[0]))) tmpResult = (tmpStr.indexOf(String.valueOf(sampleMap.get(2)[0])) < tmpS.indexOf(String.valueOf(sampleMap.get(2)[1]))) ? true : false;
                            if(!tmpResult) break;

                            char[] tmpArray = tmpS.toCharArray();

                            tmpArray[tmpS.indexOf(front)] = 0;
                            tmpArray[tmpS.indexOf(rear)] = 0;
                            tmpS = String.valueOf(tmpArray).trim(); //지우기
        //                    tmpS = Arrays.toString(tmpArray);
                        }
                    }
                    else {
                        result = false;
                    }
                    if(!result) break;
                }else {
                    i++;
                }


                if(i>=3 || tmpS.length() == 0){
                    if(result) cnt++;
                    break;
                }
            }

            String newS = "";
            for(int j=0; j<s.length(); j++){
                if(j==s.length()-1) {
                    newS += s.charAt(0);
                }else{
                    newS += s.charAt(j+1);
                }
            }
            s = newS;
        }
        return cnt;
    }
}
