package com.eunmi.algorithm.category.brute_force;

/** https://programmers.co.kr/learn/courses/30/lessons/42842 **/

public class Carpet {
    public static void main(String[] args){
        Carpet c = new Carpet();
        int[] result = c.solution(10, 2);
        for(int r : result){
            System.out.print(r+", ");
        }
    }
    public int[] solution(int brown, int red) {
        //brown과 yello의 개수를 합치면 전체 블록의 개수가 나온다.
        //가로의 블럭 갯수와 세로의 블럭 갯수는 겹치는 부분이 모서리의 4개 이므로
        //brown의 갯수는 "2x + 2y -4"이다

        //red의 갯수는 (x-2)*(y-2)
        int height = 0;
        int width = 0;
        for (height = 3; height <= (int) (brown + 4) / 2; height++) { //red가 최소 1개 있기 때문에 세로 블럭은 3개 미만이 될 수 없어 3부터 시작

            width = ((brown + 4) / 2) - height; // ((10+4)/2) - 3 = 4
            if (width < height) { // 4 < 3
                break;
            }

            int redCount = (width - 2) * (height - 2); //(4-2) * (3-2) = 2
            if (red == redCount) {
                break;
            }
        }

        int[] answer = new int[] { width, height };
        return answer;
    }
}
