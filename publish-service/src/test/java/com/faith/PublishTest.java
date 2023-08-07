package com.faith;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author:faith
 * @time:2023/5/1615:24
 */
@SpringBootTest
public class PublishTest {
    @Test
    public void publishTest() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //设置连接参数
        factory.setHost("120.79.81.249");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("faith");
        factory.setPassword("123456");
        //建立连接
        Connection connection = factory.newConnection();
        //创建通道
        Channel channel = connection.createChannel();

        //创建队列
        String queueName = "faith.queue";
        channel.queueDeclare(queueName,false,false,false,null);

        //发送消息
        String message = "today is Wednesday";
        channel.basicPublish("",queueName,null,message.getBytes());
        System.out.println("发送消息成功！"+message);
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
