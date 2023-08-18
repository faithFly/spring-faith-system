package com.faith.bridging;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1110:52
 */
public abstract class RefinedCar extends Car{

    public RefinedCar(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        this.engine.start();
        System.out.println("drive"+ getBrand()+"car....");
    }
    public abstract String getBrand();
}
