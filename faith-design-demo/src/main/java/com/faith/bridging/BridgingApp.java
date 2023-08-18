package com.faith.bridging;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1111:00
 */
public class BridgingApp {
    public static void main(String[] args) {
        RefinedCar bossCar = new BossCar(new HybridEngine());
        bossCar.drive();
    }
}