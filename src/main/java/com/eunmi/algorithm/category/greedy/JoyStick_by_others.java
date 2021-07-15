package com.eunmi.algorithm.category.greedy;

public class JoyStick_by_others {
    static public int solution(String name) {
        int answer = 0;

        int len = name.length();

        //최대로 가질 수 있는 min값은 끝까지 가는것
        int min_move = len-1;

        for(int i=0; i<len; i++) {
            //Math.max 숫자 집합 중에 가장 큰수를 리턴
            //Math.max 가장 작은 수를 리턴
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1); //A에서 부터 시작했을 때랑, Z에서부터 시작했을때 비교해서 작은수를 return

            //좌우: 연속된 A의 등장에 따라 최소 움직임이 달라진다
            int next = i+1;// 현재 다음 위치부터
            //내 다음이 A라면 계속 NEXT++
            while(next<len && name.charAt(next) == 'A')
                next++;

            //min_move와 배교해줘야 하는 값은
            //내 위치에서 첫 위치로 돌아 간 후 (i+i)
            //A가 연속으로 나오는 지접의 다음(next)을 끝(len)에서 계산해주는 것이다 -> len-next

            min_move = Math.min(min_move, i+len-next + i);

            /**
             * // len - next :
             * // 총 길이에서 현재 바로 다음에 연속된 A가 지나고 남은 문자 갯수
             * // i : 오른쪽으로의 현재까지의 이동횟수
             * // i + len - next + i : 현재까지 왔다가 다시 돌아가서 남은 거 까지 가는 이동 횟수
             * // min(i,len-next)에서,
             * // i 보다 len-next 값이 작은 경우에 len-next를 선택하는데
             * // 이는, 마지막 문자가 A인 경우를 제외 하면
             * // 무조건 len-1 보다 크게 된다 (len-next >=1)
             * // 따라서,i가 len-next(남은 문자)보다 큰 경우는
             * // 굳이 왼쪽으로 다시 돌아갈 필요가 없다.
             * // 대신 끝이 A인 경우는, len-next가 0이 되므로,
             * // 무조건 len-1 보다 작은 i 가 최소 이동횟수가 된다.
             * // 따라서 Math.min(i,len-next) 이 부분은 식에서 필요하게 된다.
             * 	min_move = Math.min(min_move, Math.min(i+len-next+ Math.min(i,len-next) ));
             */

        }//for

        answer += min_move;

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution("BBBAAB"));
    }
}

