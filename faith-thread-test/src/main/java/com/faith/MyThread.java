package com.faith;

/**
 * @description:
 * @author:faith
 * @time:2023/6/2813:28
 */
public class MyThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程--->"+i);
        }

    }
}
