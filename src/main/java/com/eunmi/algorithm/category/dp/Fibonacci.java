package com.eunmi.algorithm.category.dp;

public class Fibonacci {
    int NIL = -1;
    int MAX = 100;
    int[] lookup = new int[MAX];
    int cnt =0;
    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        int n =5;
        double begin ,end;
        begin = System.currentTimeMillis();
        //recursive
       //System.out.println("Fibonacci number is "+f.fib_recursive(n)); //Time Taken 569.0, 15번 호출 됨

        //memoized
        //f._initialize();
        //System.out.println("Fibonacci number is "+f.fib_memoized(n)); //Time Taken 2.0, 9번 호출 됨

        //tabulated
        System.out.println("Fibonacci number is "+f.fib_tabulated(n)); //Time Taken 1.0

        end = System.currentTimeMillis();
        double time_spent = (end - begin);
        System.out.println("Time Taken " + time_spent);

    }

    public int fib_recursive(int n){
        System.out.println(cnt++ + " -> "+n);
        if (n <=1)
            return n;
        return fib_recursive(n - 1) + fib_recursive(n - 2);

    }

    public int fib_memoized(int n){
        System.out.println(cnt++ + " -> "+n);

        if(lookup[n] == NIL){
            if(n<=1){
                lookup[n] = n;
            }else {
                lookup[n] = fib_memoized(n - 1) + fib_memoized(n - 2);
            }
        }
        return lookup[n];
    }

    public void _initialize(){
        int i;
        for(i=0;i<MAX;i++){
            lookup[i] = NIL;
        }
    }

    public int fib_tabulated(int n){
        int[] f = new int[n+1];
        int i;
        f[0] = 0;
        f[1] = 1;
        for(i =2; i<=n; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
