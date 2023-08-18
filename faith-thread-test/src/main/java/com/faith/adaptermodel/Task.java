package com.faith.adaptermodel;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1110:13
 */
public class Task implements Callable<Long> {
    private long num;
    public Task(long num){
    this.num = num;
    }
    @Override
    public Long call() throws Exception {
        long r = 0;
        for (long i = 0; i < this.num; i++) {
            r = r + i;
        }
        System.out.println("res"+r);
        return r;
    }
}

