package com.eunmi.algorithm.category.문자열;

//https://youtu.be/WAzjfl7Pt_4
public class 단순문자열매칭알고리즘 {

    int findString(String parent, String pattern){
        int parentSize = parent.length();
        int patternSize = pattern.length();
        for(int i =0; i<= parentSize - patternSize; i++){
            boolean found = true;
            for(int j = 0; j<patternSize; j++){
                if(parent.charAt(i + j) != pattern.charAt(j)){ //한 개의 문자라도 같지 않는다면
                    found = false;
                    break;

                }
            }
            if(found){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        단순문자열매칭알고리즘 a = new 단순문자열매칭알고리즘();
        String parent = "Hello World";
        String pattern = "llo W";
        int result = a.findString(parent, pattern);
        if(result==-1){
            System.out.println("404");
        }else{
            System.out.println(result + 1 +" 번 째");
        }
    }
}
