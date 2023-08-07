package com.faith;

/**
 * @description:
 * @author:faith
 * @time:2023/6/2814:00
 */
// 这并不是一个线程类，是一个可运行的类。它还不是一个线程
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程--->"+i);
        }
    }
}
