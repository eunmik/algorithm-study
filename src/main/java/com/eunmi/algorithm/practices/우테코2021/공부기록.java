package com.eunmi.algorithm.practices.우테코2021;

public class 공부기록 {
    public static void main(String[] args){
        공부기록 a = new 공부기록();
        //String[] arr = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
        String[] arr = {"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"};
        String result = a.solution(arr);
        System.out.println(result);
    }
    public String solution(String[] log){
        int i = 0;
        int result = 0;
        while(i<= log.length-2){
            int start = changeTimeToDigit(log[i]);
            int end = changeTimeToDigit(log[i+1]);

            int total = end - start;
            if(total <= 4){
                total = 0;
            }else if (total > 105 ){
                total = 105;
            }
            result += total;
            i += 2;
        }
        return changeDigitToTime(result);
    }
    public int changeTimeToDigit(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        int digit_time = (hour*60) + min ;
        return digit_time;
    }

    public String changeDigitToTime(int time){
        int hour = time/60;
        int min = time%60;
        StringBuilder sb = new StringBuilder();
        if(hour<10) {
            sb.append("0");
        }
        sb.append(hour + ":");
        if(min<10) {
            sb.append("0");
        }
        sb.append(min);

        return sb.toString();
    }


}
