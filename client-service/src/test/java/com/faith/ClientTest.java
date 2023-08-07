package com.faith;

import com.rabbitmq.client.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author:faith
 * @time:2023/5/1710:05
 */
@SpringBootTest
public class ClientTest {
    @Test
    public void clientMethod() throws IOException, TimeoutException {
        //建立连接
        ConnectionFactory factory =new ConnectionFactory();
        factory.setHost("120.79.81.249");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("faith");
        factory.setPassword("123456");

        Connection connection = factory.newConnection();

        //创建通道
        Channel channel = connection.createChannel();

        //创建队列
        String clientQueue = "faith.queue";
        channel.basicConsume(clientQueue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //处理消息
                String msg = new String(body);
                System.out.println("接受消息："+ msg);
            }
        });
        System.out.println("等待");
    }
}
