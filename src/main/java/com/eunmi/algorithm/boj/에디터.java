package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1406
 */
public class 에디터 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        int N = Integer.parseInt(br.readLine());

        char[] wordArray = word.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char w : wordArray){
            list.add(w);
        }
        int currentCursor = wordArray.length;
        while (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N--;
            switch (st.nextToken()) {
                case "L" : //커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                    if(currentCursor != 0){
                        currentCursor-= 1;
                    }
                    break;
                case "D" : //커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    if(currentCursor != list.size()){
                        currentCursor+= 1;
                    }
                    break;
                case "B" : // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                    //삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
                    if(currentCursor != 0){
                        list.remove(currentCursor-1);
                        currentCursor -=1;
                    }
                    break;
                case "P" : //$라는 문자를 커서 왼쪽에 추가함
                    list.add(currentCursor, st.nextToken().charAt(0));
                    currentCursor+=1;

                    break;

            }

        }
        for(char c : list){
            System.out.print(c);
        }

    }
}
