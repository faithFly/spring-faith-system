package com.faith.factoryTest;

/**
 * @description:
 * @author:faith
 * @time:2023/7/1316:51
 */
public class FactoryDemo {
    public static void main(String[] args) {
        Sender sender = SendFactory.MailProduct();
        sender.send();
    }
}
