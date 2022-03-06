package com.eunmi.algorithm.practices.우테코2021;


public class 격자채우기 {
    public static void main(String[] args){
        격자채우기 a = new 격자채우기();
        int r = 5;
        int c = 5;
        int[][] result = a.solution(r, c);
        for(int i =0; i<result.length; i++){
            for(int j =0; j<result[0].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
    public int[][] solution(int rows, int columns){
        int[][] map = new int[rows][columns];
        //짝수라면 [r,c] -> [r+1, c]  if(r=rows), r = 0
        //홀수라면 [r,c] -> [r, c+1] if(c=colums), c = 0
        int x =0, y=0;
        int num = 0;
        int zeroCnt = rows * columns;
        int repeatCnt = 0;
        boolean[][] visited = new boolean[rows][columns];
        while(true){
            repeatCnt++;
            if(map[x][y] == 0) {
                zeroCnt--;
            }
            visited[x][y] = true;
            map[x][y] = ++num;
            if(zeroCnt == 0){
                break;
            }
            if(rows == columns && repeatCnt >= rows*2){
                break;
            }
            if(num%2 ==0) { //짝수라면
                x++;
                if(x > rows -1){
                    x = 0;
                }
            }else if(num%2 !=0) { //홀수라면
                y++;
                if(y > columns -1){
                    y = 0;
                }
            }
        }
        return map;
    }


}
