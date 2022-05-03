package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/5430
 * Hint : deque
 */
public class AC{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T > 0){
            char[] commands = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            boolean isError = false;

            for(int i =0; i<N; i++){
                String token = st.nextToken();
                token = token.replaceAll("[\\[\\]]", "");
                list.add(Integer.parseInt(token));
            }

            int c = 0;
            int reverseCnt = 0;
            while(!isError && c< commands.length){

                switch(commands[c++]){
                    case 'R':
                        if(!list.isEmpty()) {
                            reverseCnt++;
                        }
                        break;
                    case 'D':
                        if(list.isEmpty()){
                            sb.append("error\n");
                            isError = true;
                            break;
                        }else {
                            if(reverseCnt%2==0){
                                list.pollFirst();
                            }else {
                                list.pollLast();
                            }
                        }
                        break;
                }
            }

            if(!isError) {
                sb.append("[");
                while(!list.isEmpty()){
                    if(reverseCnt%2 == 0) {
                        sb.append(list.pollFirst());
                    }else {
                        sb.append(list.pollLast());
                    }

                    if(list.size()!=0){
                        sb.append(",");
                    }

                }

                sb.append("]\n");
            }

            T--;
        }
        System.out.print(sb);

        br.close();
    }

}