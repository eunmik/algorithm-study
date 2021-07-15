package com.eunmi.algorithm.category.sort;

public class HIndex {

    public static void main(String[] args) {
        // MyThread인스턴스를 2개 만듭니다.
        MyThread1 t1 = new MyThread1("t1의 ");
        MyThread1 t2 = new MyThread1("t2의 ");

        t1.start();
        t2.start();
        System.out.print("!!!!!");
    }
}

class MyThread1 extends Thread {
    String str;
    public MyThread1(String str){
        this.str = str;
    }

    public void run(){
        for(int i = 0; i < 10; i ++){
            System.out.print(str);
            System.out.println("thread "+i);
            try {
                //컴퓨터가 너무 빠르기 때문에 수행결과를 잘 확인 할 수 없어서 Thread.sleep() 메서드를 이용해서 조금씩
                //쉬었다가 출력할 수 있게한다.
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
