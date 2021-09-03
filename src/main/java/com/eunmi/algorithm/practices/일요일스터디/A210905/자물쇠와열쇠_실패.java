package com.eunmi.algorithm.practices.일요일스터디.A210905;

/**
 푼 날짜 : 2021-09-03
 푼 시간 : ..... GG
 */
//https://programmers.co.kr/learn/courses/30/lessons/60059
//level 3
public class 자물쇠와열쇠_실패 {
    public static void main(String[] args) {
        자물쇠와열쇠_실패 j = new 자물쇠와열쇠_실패();
//        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
//        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] key = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1},{1, 1, 1, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 0, 1, 1}};
//        int[][] lock = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1},{1, 1, 1, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 0, 1, 1}};
        int[][] lock = { {1, 1, 1, 1},{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 0, 1, 1}};

        int[][] key = {{1, 0}, {0, 1}};
//        int[][] lock = {{0, 1}, {1, 0}};
        System.out.println(j.solution(key, lock));
    }
    public boolean solution(int[][] key, int[][] lock){
        boolean result = false;
        //lock배열 사이즈에 바깥 테두리에 줄 하나씩 추가한 것을 key 배열에 적용한다.
        //lock 배열과 (사이즈를 늘린) 키 배열을 비교한다. lock[i][j] = 0일때 key[i][j] = 1인지 확인
        //false이면 key를 90도 돌린다

        int[][] lockCopy = new int[lock.length + 2][lock.length + 2];
        for(int i =0; i<lockCopy.length; i++){
            for(int j =0; j<lockCopy.length; j++){
                lockCopy[i][j] = 2;
            }
        }

        for(int i =0; i<lock.length; i++){
            for(int j =0; j<lock.length; j++){
//                System.out.println("lockCopy["+(i+1)+"]["+(j+1)+"] = lock["+i+"]["+j+"]" );

                lockCopy[i+1][j+1] = lock[i][j];
            }
        }
        result = isSolved(lock.length, lockCopy, key);

        return result;

    }
    public int[][] rotate(int[][]key){
        int[][] tmp = new int[key.length][key.length];
        int k = key.length-1;
        for(int i =0; i<key.length; i++){
            for(int j =0; j<key.length; j++){

//                System.out.println("key["+i+"]["+j+"] = tmp["+j+"]["+k+"]" );
                tmp[j][k] = key[i][j];

            }
            k--;

        }
        return tmp;
    }


    public boolean isSolved (int length, int[][] lock, int[][] key){
        boolean isSolved = false;

        int cnt = 0;
        while(!isSolved && cnt <4){
            for(int i =0; i<lock.length-length; i++){
                 for(int j =0; j<lock.length-length; j++){
                    isSolved = match(key.length, key, lock, i, j);
                    if(isSolved) break;
                }
                if(isSolved) break;
            }
            if(!isSolved) {
                key = rotate(key);
                cnt++;
            }

        }
        return isSolved;
    }
    public boolean match(int length, int[][] key, int[][]lock, int idx, int jdx){
        int key_idx = 0;
        int key_jdx;
        boolean result = true;
        for (int i = idx; i < idx+length; i++) {
            key_jdx = 0;
            for (int j = jdx; j < jdx+length; j++) {
                if (lock[i][j] == 0 && key[key_idx][key_jdx] == 1 || lock[i][j] == 1 && key[key_idx][key_jdx] == 0 || lock[i][j] == 2 ){
                    result = true;
                }else {
                    result = false;
                    break;
                }

                key_jdx++;
            }
            if(!result) break;
            key_idx++;
        }

        return result;
    }
}
