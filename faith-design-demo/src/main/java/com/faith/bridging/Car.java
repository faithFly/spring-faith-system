package com.faith.bridging;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1110:49
 */
public abstract class Car {
    //发动机
    protected Engine engine;
    public Car(Engine engine){
        this.engine = engine;
    }
    public abstract void drive();
}
