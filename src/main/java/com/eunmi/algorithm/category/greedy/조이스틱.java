package com.eunmi.algorithm.category.greedy;

/**
 * 푼 날짜 : 2022-02-04
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 * LEVEL 2
 */

/**
 * ▲ - 다음 알파벳
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 * ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
 */
public class 조이스틱 {
    public static void main(String[] args) {
        조이스틱 a = new 조이스틱();
        //String name = "JEROEN"; //56
        //String name = "JAN"; //23
        //String name = "JAZ"; //11
        //String name = "BBBAAB"; // 9
        String name = "ABAAAAAAAAABB"; // 7
        System.out.println(a.solution(name));
    }
    /**
     * ASCII 78 아상 ~ 90이하면 밑으로
     * ASCII 65 이상 77이하면 위로
     * 앞으로 가는 거랑 뒤로 가는거랑 비교
     */


    public int solution(String name){
        char[] nameArray = name.toCharArray();
        return Math.min(getCountDependOnDirection(nameArray, "right"), getCountDependOnDirection(nameArray, "left"));

    }

    public int getCountDependOnDirection(char[] name, String direction){
        int count = 0;
        if(direction.equals("right")){

            for(int i =0; i<name.length; i++){
                int c = getAlphabetCounts(name[i]);
                count += c;
                if(i == name.length-1 || i+1 == name.length -1 && name[i+1] == 'A') { //마지막이면 이동할 필요가 없음
                }else {
                    count+= 1; //옆으로 이동하는 값
                }
            }
            return count;
        }else if(direction.equals("left")){

            count += getAlphabetCounts(name[0])+1;
            for(int i = name.length-1; i > 0; i--){
                int c = getAlphabetCounts(name[i]);
                count += c;
                if(i == 1 || i-1 == 1 && name[i-1] == 'A') { //마지막이면 이동할 필요가 없음
                }else {
                    count+= 1; //옆으로 이동하는 값
                }
            }
            return count;
        }
        return 0;
    }

    public int getAlphabetCounts(char alphabet){
        if(65 <= alphabet && alphabet <= 77){
            return alphabet - 65;
        }else if (78 <= alphabet && alphabet <= 90){
            return 91 - alphabet;
        }
        return 0;
    }

}
