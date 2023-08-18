package com.faith;

import sun.applet.Main;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @description:
 * @author:faith
 * @time:2023/8/109:44
 */
public class LiaoThreadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
/*      ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<String> task = new Task();
        Future<String> res = executorService.submit(task);
        System.out.println(res.get());
        executorService.shutdown();*/
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(new Supplier<Double>() {
            @Override
            public Double get() {
                return TTT(12138.123);
            }
        });
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }
    public  static Double TTT(Double a){
        return a;
    }
}
class FaithRunnable implements  Runnable{
    private final String name;
    public FaithRunnable(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end task " + name);
    }
}
class Task implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
       return "qweqweqweqwe";
    }
}