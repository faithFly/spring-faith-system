package com.faith.bridging;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1110:56
 */
public class BossCar extends RefinedCar{
    public BossCar(Engine engine) {
        super(engine);
    }
    @Override
    public String getBrand() {
        return "Boss";
    }
}
