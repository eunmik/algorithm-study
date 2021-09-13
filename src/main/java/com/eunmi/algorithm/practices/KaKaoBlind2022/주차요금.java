package com.eunmi.algorithm.practices.KaKaoBlind2022;

import java.util.*;

public class 주차요금 {
    public static void main(String[] args){
        주차요금 p = new 주차요금();
        //int[] fees = {180, 5000, 10, 600}; //기본시간, 기본요금, 단위 시간, 단위요금
        //String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//        int[] fees = {120, 0, 60, 591};
//        String[] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
//
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};
        int[] result = p.solution(fees, records);
        for(int i : result){
            System.out.println(i);
        }
    }

    //주차 차량 대로 정렬한다.
    //차량에서 시간별로 정렬한다.
    //차량별 주차 시간을 구한다.
    //주차시간 * 주차 요금 구하기
    public int[] solution(int[] fees, String[] records){

        Set<String> set = new HashSet<>();
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        for(String r : records){
            String[] info = r.split(" "); //[0] : 시간, [1] : 차량번호
            String plateNum = info[1];
            int minutes = timeChanger(info[0]);
            //주차 차량 번호 대로 정렬한다.
            set.add(plateNum);
            //차량별 시간을 정렬한다.
            if(map.get(plateNum) == null){
                map.put(plateNum, new PriorityQueue<Integer>());
            }
            map.get(plateNum).add(minutes);

        }
        int[] result = new int[set.size()];
        List<String> list = new ArrayList();
        for(String s : set){
            list.add(s);
        }
        Collections.sort(list);
        int i = 0;
        for(String s : list){
            String car = s;
            //주차요금 구하기
            double parkedTime = getParkingTime(map.get(car)) - fees[0];
            int fee = 0;

            if(parkedTime <= 0){
                fee = fees[1];
            } else {
                fee = fees[1] + (int) Math.ceil( parkedTime / fees[2]) * fees[3];
            }
            result[i] = fee;

            i++;
        }
        return result;

    }

    //시간을 분으로 변경하는 함수
    public int timeChanger(String time){
        String[] splited = time.split(":");
        int hour = Integer.parseInt(splited[0]) * 60 ;
        int min = Integer.parseInt(splited[1]);
        return hour + min;

    }

    //차량별 주차 시간을 구한다.
    public int getParkingTime(PriorityQueue<Integer> pq ) {
        int outTime = 0;
        int inTime = 0;
        int closingTime = timeChanger("23:59");
        int parkedTime = 0;
        while (true) {


            inTime = pq.poll();
            if (pq.isEmpty()) {
                outTime = closingTime;
            } else {
                outTime = pq.poll();
            }
            parkedTime += outTime - inTime;
            if (outTime == closingTime || pq.isEmpty()) {
                break;
            }
        }
        return parkedTime;

    }
}
