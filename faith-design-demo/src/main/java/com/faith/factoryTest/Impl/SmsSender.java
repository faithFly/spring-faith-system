package com.faith.factoryTest.Impl;

import com.faith.factoryTest.Sender;

/**
 * @description:
 * @author:faith
 * @time:2023/7/1316:48
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is SmsSender");
    }
}
