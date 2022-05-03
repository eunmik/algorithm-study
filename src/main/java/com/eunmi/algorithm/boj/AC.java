package com.eunmi.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/5430
 */
public class AC{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T > 0){
            char[] commands = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            boolean isError = false;

            for(int i =0; i<N; i++){
                String token = st.nextToken();
                token = token.replaceAll("[\\[\\]]", "");
                list.add(Integer.parseInt(token));
            }
            boolean isStraightforward = true;
            boolean isBackward = false;

            int c = 0;
            while(!isError && c< commands.length){

                switch(commands[c++]){
                    case 'R':
                        if(!list.isEmpty()) {
                            if(isStraightforward) {
                                isBackward = true;
                                isStraightforward = false;
                            }else {
                                isBackward = false;
                                isStraightforward = true;
                            }
                        }
                        break;
                    case 'D':
                        if(list.isEmpty()){
                            sb.append("error\n");
                            isError = true;
                            break;
                        }else {
                            if(isBackward){
                                list.remove(list.size()-1);
                            }else if (isStraightforward){
                                list.remove(0);
                            }

                        }
                        break;
                }
            }

            if(!isError) {
                sb.append("[");
                if(isBackward){
                    for (int i = list.size()-1; i >= 0; i--) {
                        if(i == 0){
                            sb.append(list.get(i));
                        }else {
                            sb.append(list.get(i)+",");
                        }

                    }
                }
                else if(isStraightforward){
                    for (int i = 0; i < list.size(); i++) {
                        if(i == list.size()-1){
                            sb.append(list.get(i));
                        }else {
                            sb.append(list.get(i)+",");
                        }

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