package com.faith.lazysington;

/**
 * @description:
 * @author:faith
 * @time:2023/7/129:29
 */
public class LazySingtonTest {
    public static void main(String[] args) {
//        LazySington instance = LazySington.getInstance();
//        LazySington instance1 = LazySington.getInstance();
//        LazySington instance2 = LazySington.getInstance();
//        System.out.println(instance);
//        System.out.println(instance1);
//        System.out.println(instance2);
        new Thread(()->{
            LazySington instance = LazySington.getInstance();
            System.out.println(instance);
        }).start();
        new Thread(()->{
            LazySington instance = LazySington.getInstance();
            System.out.println(instance);
        }).start();
    }
}
class LazySington{
    //静态
    private volatile static LazySington instance;
    private LazySington(){

    }
    public static LazySington getInstance(){
        if (instance == null){
            synchronized (LazySington.class){
            if (instance == null){
                instance = new LazySington();
                //字节码层面
                //1.开辟空间
                //2.初始化
                //3。引用赋值
                //当 2 和 3 对换的时候 在多线程的情况下线程1进入刚引入赋值 线程2进入发现instance就不是null就返回了 但是这个时候还尚未初始化
            }
            }
            instance = new LazySington();
        }
        return instance;
    }

}
//线程不安全
//class LazySington{
//    //静态
//    private static LazySington instance;
//    private LazySington(){
//
//    }
//    public static LazySington getInstance(){
//        if (instance == null){
//            instance = new LazySington();
//        }
//        return instance;
//    }
//
//}
