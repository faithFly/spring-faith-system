package com.faith.adaptmodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1110:15
 */
public class ConsoleApp {
    public static void main(String[] args) throws IOException {
        Callable<Long> callable = new Task(12450L);
         // 编译失败 因为Thread接受的是runnable接口参数
        //Thread thread = new Thread(callable);
        //thread.start();
        //这个时候需要改写Task类 把实现的的callable改为runnable，但是这样不行
        //因为搞不好task以callable在其他地方被调用了所以需要一个适配器
        //好比中国的电压和美国香港的电压不一样 充电器需要一个适配器


        //使用runnable这个中间类 thread调用runnable的run方法 run方法里再去调用callable的
        //call方法 做到一个适配器的功能
        RunnableAdapter adapter = new RunnableAdapter(callable);
        Thread thread = new Thread(adapter);
        thread.start();

        //使用适配器，把InputStream“变成”Reader：
        InputStream input = Files.newInputStream(Paths.get("/path/to/file"));
        Reader reader = new InputStreamReader(input, "UTF-8");
        //readText(reader);
    }
}

