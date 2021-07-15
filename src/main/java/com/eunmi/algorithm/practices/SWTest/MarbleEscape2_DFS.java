package com.eunmi.algorithm.practices.SWTest;

import java.util.*;

class MarbleEscape2_DFS {
    static int n;
    static int m;
    static char[][] arr ;
    static int[] red = new int[2];
    static int[] blue = new int[2];
    static int[] goal = new int[2];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = Integer.MAX_VALUE;

    public static void solve(){
        dfs(red,blue,0);
        System.out.println(answer==Integer.MAX_VALUE?-1:answer);
    }

    public static void dfs(int[] r,int[] b,int moveCnt) {
        if(moveCnt == 11) return;
        if(r[0]==-100 && b[0]!=-100){
            answer = answer > moveCnt ? moveCnt : answer;
            return;
        }
        if(b[0] == -100)
            return;

        for(int i=0;i<4;i++){
            int[] curRed = {r[0],r[1]};
            int[] curBlue = {b[0],b[1]};
            move(curRed,curBlue,i);
            dfs(curRed,curBlue,moveCnt+1);
        }
    }


    public static void move(int[] r,int[] b,int dir){
        int[] curRed = new int[]{r[0],r[1]};
        int[] curBlue = new int[]{b[0],b[1]};
        while(next(curRed,curBlue,dir)){
            if(goalCheck(curRed)) {
                curRed[0] = -100;
                curRed[1] = -100;
            }
            if(goalCheck(curBlue)){
                curBlue[0] = -100;
                curBlue[1] = -100;
            }
        }
        r[0] = curRed[0];
        r[1] = curRed[1];
        b[0] = curBlue[0];
        b[1] = curBlue[1];
    }

    public static boolean goalCheck(int[] x){
        if(goal[0] == x[0] && goal[1] == x[1]) return true;
        else return false;
    }

    public static boolean checkRange(int x,int y){
        if(x<0 || x>=n || y<0 || y>=m) return false;
        else if(arr[x][y] == '#') return false;
        else return true;
    }

    public static boolean next(int[] red,int[] blue, int dir){
        int nx1,nx2,ny1,ny2;
        nx1 = red[0] + dx[dir];
        nx2 = blue[0] + dx[dir];
        ny1 = red[1] + dy[dir];
        ny2 = blue[1] + dy[dir];

        if(checkRange(nx1,ny1) && checkRange(nx2,ny2)){
            red[0] = nx1;
            red[1] = ny1;
            blue[0] = nx2;
            blue[1] = ny2;
            return true;
        }
        else if(!checkRange(nx1,ny1) && checkRange(nx2,ny2)){
            if(red[0] == nx2 && red[1] == ny2){
                return false;
            }
            else{
                blue[0] = nx2;
                blue[1] = ny2;
                return true;
            }
        }
        else if(checkRange(nx1,ny1) && !checkRange(nx2,ny2)){
            if(blue[0] == nx1 && blue[1] == ny1){
                return false;
            }
            else{
                red[0] = nx1;
                red[1] = ny1;
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[n][m];
        for(int i=0;i<n;i++) arr[i] = new char[m];
        for(int i =0;i<n;i++){
            char[] temp = sc.next().toCharArray();
            for(int j=0;j<m;j++){
                if(temp[j] == 'R'){
                    red[0] = i;
                    red[1] = j;
                    arr[i][j] = '.';
                }
                else if(temp[j] == 'B'){
                    blue[0] = i;
                    blue[1] = j;
                    arr[i][j] = '.';
                }
                else if(temp[j] == 'O'){
                    goal[0] = i;
                    goal[1] = j;
                    arr[i][j] = '.';
                }
                else{
                    arr[i][j] = temp[j];
                }
            }
        }
        solve();
    }

}
