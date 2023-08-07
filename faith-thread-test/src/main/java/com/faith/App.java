package com.faith;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        new  Son();
        System.gc();
        new Son();
//          ThreadTest threadTest = new ThreadTest();
//          Thread t1 = new Thread(threadTest);
//          Thread t2 = new Thread(threadTest);
//          Thread t3 = new Thread(threadTest);
//
//          t1.setName("窗口1");
//          t2.setName("窗口2");
//          t3.setName("窗口3");
//
//          t1.start();
//          t2.start();
//          t3.start();

//        int [] arr = {1,2,7,8,4,3};
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                int index = 0;
//                if (arr[j] > arr[j+1]){
//                   index = arr[j];
//                   arr[j] = arr[j+1];
//                   arr[j+1] = index;
//                }
//            }
//        }
//        for (int num:
//             arr) {
//            System.out.println(num);
//        }
        Integer a = 128;
        Integer b = 128;
        System.out.println(a.equals(b));

        Double c = 127.0;
        Double d = 127.0;
        System.out.println(c==d);
        System.out.println(c.equals(d));
        ThreadTest t1 = new ThreadTest();
        if (t1 instanceof ThreadTest){
            System.out.println("true!!!");
        }
    }
}
class ThreadTest implements Runnable{
    int ticket = 0;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
     while (true){
         if (extracted()) break;

     }
    }

    private boolean extracted() {

        try {
            lock.lock();
            if (ticket<100){
                   Thread.sleep(100);
                ticket++;
                System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"票");
            }else {
                return true;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return false;
    }
}
class MyRunable4 implements Runnable {

    // 打一个布尔标记
    boolean run = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            if(run){
                System.out.println(Thread.currentThread().getName() + "--->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                // return就结束了，你在结束之前还有什么没保存的。
                // 在这里可以保存呀。
                //save....

                //终止当前线程
                return;
            }
        }
    }
}
