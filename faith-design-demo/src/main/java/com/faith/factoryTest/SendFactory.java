package com.faith.factoryTest;

import com.faith.factoryTest.Impl.MailSender;
import com.faith.factoryTest.Impl.SmsSender;

/**
 * @description:
 * @author:faith
 * @time:2023/7/1316:48
 */
public class SendFactory {
    public static Sender MailProduct(){
       return new MailSender();
    }
    public static Sender SmsProduct(){
        return new SmsSender();
    }
}
