package com.faith.adaptermodel;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1110:20
 */
public class RunnableAdapter implements Runnable{
    //引用待转换的接口i
    public Callable<?> callable;
    public RunnableAdapter(Callable<?> callable){
    this.callable = callable;
    }
    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
