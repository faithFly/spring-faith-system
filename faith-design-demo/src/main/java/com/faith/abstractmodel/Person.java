package com.faith.abstractmodel;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1111:44
 */
public abstract class Person {
    public abstract void eat();
    public void run(){
        System.out.println("person run");
    }
}
class Student extends Person{
    @Override
    public void eat() {
        System.out.println("student eat something");
    }
/*    @Override
    public void run(){
        System.out.println("student run");
    }*/
}