package com.eunmi.algorithm.practices.a210712;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/17683

/**
 * "A#", ["13:00,13:02,HAPPY,B#A#"], "HAPPY"
 * "CDEFGAC", ["12:00,12:06,HELLO,CDEFGA"], "(None)"
 * "CCB", ["03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"], "FOO"
 * "ABC", ["03:00,03:10,FONG,CCB#ABC", "04:00,04:10,BARAR,ABC"], "FONG"
 */
public class MusicInfo {
    public static void main(String[] args){
        MusicInfo m = new MusicInfo();
        System.out.println(m.solution2("ABC", new String[]{"03:00,03:10,FONG,CCA#ABC", "04:00,04:10,BARAR,ABC"}));

    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        m = replaceAll(m);
        //musicinfos [시작시간, 종료시간, 제목, 악보]
        for(String music : musicinfos){
            String[] musicInfo = music.split(",");
            String musicNote = replaceAll(musicInfo[3]);
            int startTime = Integer.parseInt(musicInfo[0].split(":")[0])*60 + Integer.parseInt(musicInfo[0].split(":")[1]);
            int endTime =  Integer.parseInt(musicInfo[1].split(":")[0])*60 + Integer.parseInt(musicInfo[1].split(":")[1]);
            int playTime = endTime - startTime;
            char[] musicNotes = new char[playTime];
            char[] musicNoteCharArray = musicNote.toCharArray();
            int j = 0;
            for(int i=0; i<musicNotes.length; i++){
                musicNotes[i] = musicNoteCharArray[j];
                if(j==musicNoteCharArray.length-1) {
                    j=0;
                }else {
                    j++;
                }
            }
            if(String.valueOf(musicNotes).contains(m)){
                map.put(musicInfo[2], playTime);
            }
        }

        if(map.size()>0){
            answer = compare(map);
        }else {
            answer = "(None)";
        }
        return answer;

    }

    public String replaceAll(String m){
        m = m.replaceAll("C#", "V");
        m = m.replaceAll("D#", "W");
        m = m.replaceAll("F#", "X");
        m = m.replaceAll("G#", "Y");
        m = m.replaceAll("A#", "Z");
        return m;

    }

    public String compare(LinkedHashMap map){
        String musicName = "";
        int longestPlayedTime = 0;

        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int playedTime = (int) map.get(key);
            if(musicName=="" && longestPlayedTime == 0){
                musicName = key;
                longestPlayedTime = playedTime;
            } else if(longestPlayedTime < playedTime) {
                longestPlayedTime = playedTime;
                musicName = key;

            }

        }

        return musicName;
    }

    //다른 사람의 풀이
    public String solution2(String m, String[] musicinfos) {
        String answer = "(None)";
        int time = 0;

        m = edit(m);

        for (int inx = 0; inx < musicinfos.length; inx++) {

            String[] info = musicinfos[inx].split(",");

            int start = (60 * Integer.parseInt(info[0].substring(0, 2)) + Integer.parseInt(info[0].substring(3)));
            int end = (60 * Integer.parseInt(info[1].substring(0, 2)) + Integer.parseInt(info[1].substring(3)));
            int t = end - start;

            if (t > time) {
                info[3] = edit(info[3]);
                StringBuffer sb = new StringBuffer();
                for (int jnx = 0; jnx < t; jnx++) {
                    sb.append(info[3].charAt(jnx % (info[3].length())));
                }
                if (sb.toString().indexOf(m) >= 0) {
                    answer = info[2];
                    time = t;
                }
            }
        }

        return answer;
    }

    public String edit(String m) {

        m = m.replaceAll("C#", "V");
        m = m.replaceAll("D#", "W");
        m = m.replaceAll("F#", "X");
        m = m.replaceAll("G#", "Y");
        m = m.replaceAll("A#", "Z");

        return m;
    }
}
