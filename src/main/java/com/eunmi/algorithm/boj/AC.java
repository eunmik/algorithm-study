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

            for(int i =0; i<commands.length; i++){
                switch(commands[i]){
                    case 'R':
                        if(!list.isEmpty()) {
                            int tmp = list.get(0);
                            Collections.sort(list, Collections.reverseOrder());
                            if (tmp == list.get(0)) {
                                Collections.sort(list);
                            }
                        }

                        break;
                    case 'D':
                        if(list.isEmpty()){
                            sb.append("error\n");
                            isError = true;
                        }else {
                            list.remove(0);
                        }
                        break;
                }
            }
            if(!isError) {
                sb.append("[");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i)+",");

                }
                if(sb.lastIndexOf(",") > -1) {
                    sb.replace(sb.lastIndexOf(","), sb.length(), "]");
                }else {
                    sb.append("]");
                }
                sb.append("\n");
            }

            T--;
        }
        System.out.print(sb);
    }

}
