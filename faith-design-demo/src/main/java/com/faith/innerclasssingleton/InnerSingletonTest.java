package com.faith.innerclasssingleton;

/**
 * @description:
 * @author:faith
 * @time:2023/7/1210:42
 */
public class InnerSingletonTest {
    public static void main(String[] args) {

    }
}
class InnerSingleton{
    private static class innerSingletonHolder{
        private static InnerSingleton instance = new InnerSingleton();
    }
    private InnerSingleton(){}
    public static InnerSingleton getInstance(){
        return innerSingletonHolder.instance;
    }
}
