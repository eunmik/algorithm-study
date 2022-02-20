package com.eunmi.algorithm.practices.우테코2021;

public class 휴가시간 {
    public static void main(String[] args){
        휴가시간 a = new 휴가시간();
        double time = 5.5;
        String[][] plans = {{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}};
        System.out.println(a.solution(time, plans));

    }
    //금요일 퇴근 시간 6PM
    //월요일 출근 시간 1PM

    public String solution(double time, String[][] plans){
        /**
         * 1. 금요일 퇴근시간이랑 여행 출발시간이랑 비교
         * 2. 월요일 출근시간이랑 여행 도착시간이랑 비교
         * 3. 필요한 휴가 시간 계산
         * 4. 남은 휴가시간 과 비교 해서 갈 수 있는지 확인
        */
        double fridayOffTime = 18;
        double mondayOnTime = 13;
        double min = Integer.MAX_VALUE;
        String result = null;
        for(int i =0; i<plans.length; i++){
            String[] plan = plans[i];
            double startTime = fridayOffTime - change12To24Hours(plan[1]); //음수면 휴가 시간 필요 없음
            double endTime = change12To24Hours(plan[2]) - mondayOnTime; //음수면 휴가 시간 필요 없음
            if(startTime <= 0){
                startTime = 0;
            }
            if(endTime <= 0){
                endTime = 0;
            }
            double neededTime = startTime + endTime;
            if(min > neededTime){
                min = neededTime;
                result = plan[0];
            }
        }
        return result;
    }

    public double change12To24Hours(String time){
        double numTime = Integer.parseInt(time.substring(0, time.length() - 2));;

        if(time.contains("PM")) {
            numTime += 12;
        }
        return numTime;
    }
}
