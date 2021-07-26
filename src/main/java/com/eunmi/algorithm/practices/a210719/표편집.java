package com.eunmi.algorithm.practices.a210719;

import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/81303
public class 표편집 {
    /**
     * 8	2	["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]	"OOOOXOOO"
     * 8	2	["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"]	"OOXOXOOO"
     *
     */

    /*
        "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
        "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
        "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
        "Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
     */
    public static void main(String[] args){
        표편집 a = new 표편집();
        System.out.println(a.solution(8,2,new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
    }
    public String solution(int n, int k, String[] cmd) {
        //n : 표의 행 개수, k : 처음 선택된 행의 위치
        Stack<Integer> remove = new Stack<>();
        int table_size = n;

        for(int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);

            if(c == 'U') {
                k -= Integer.valueOf(cmd[i].substring(2));
            } else if(c == 'D') {
                k += Integer.valueOf(cmd[i].substring(2));
            } else if(c == 'C') {
                remove.push(k);
                table_size -= 1;
                if(k == table_size) k -= 1;
            } else {
                int r = remove.pop();
                if(k >= r) k += 1;
                table_size += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < table_size; i++) {
            sb.append('O');
        }
        while(!remove.isEmpty()) {
            sb.insert(remove.pop().intValue(), 'X');
        }
        return sb.toString();
    }

}
