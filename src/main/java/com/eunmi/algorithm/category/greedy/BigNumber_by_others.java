package com.eunmi.algorithm.category.greedy;

public class BigNumber_by_others {
    /** https://programmers.co.kr/learn/courses/30/lessons/42883?language=java **/
    public static void main(String[] args){
        BigNumber_by_others b = new BigNumber_by_others();
        //"87654321", 3, "87654"
        //"18765432", 3, "87654"
        //"99991" 3,   "99"
        //"11119" 3, "19"
        //"999" 2, "9"
        //System.out.println(b.solution("1924", 2));
        System.out.println(b.solution("123 12 34", 3));

    }
    public String solution(String number, int k){
        String answer = "";
        char[] number_array = number.toCharArray();
        /** {1,9,2,4}
         * 1. j=0, index=-1->
         *      i = 0, if(0 <1) true, max = 1, index=0
         *      i = 1, if(1 <9) true, max = 9, index=1
         *      i = 2, if(2 <9) false
         *      answer = "9"
         * 2. j=1, index=1>
         *      i = 2, if(0 <2) true, max = 2, index=2
         *      i = 3, if(2 <4) true, max = 4, index=3
         *      answer = "94"
         * **/        //필요한 글자수만큼 반복하기
        for (int j = 0, index = -1; j < number.length() - k; j++) { //최종적으로 나오는 문자열의 길이는 length-k
            System.out.println("for (int j = "+j+", index = "+index+"; j < "+number.length()+"-"+k+"; j++)");
            char max = 0;
            System.out.println("       max = "+max);

            //앞에서 남겨야 되는 숫자 중에 제일 큰 수체크
            for(int i = index+1; i <=k+j; i++){
                System.out.println("     for(int i = "+(index+1)+"; i <="+k+"+"+j+"; i++){");

                if(max < number_array[i]){
                    System.out.println("       if("+max+" < number_array["+i+"] //"+number_array[i]+"){ //" + (max < number_array[i]));
                    System.out.println("             index = "+i);
                    index = i;
                    System.out.println("             max = "+number_array[i]+";");
                    max = number_array[i];
                }
            }


            //제일 큰수를 정답에 추가
            answer +=max;
            System.out.println("answer  = "+answer);

        }

        return answer;
    }
}
