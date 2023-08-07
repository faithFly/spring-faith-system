package com.faith.javademo.enumdemo;

public enum Weekday {
    MON(1),TUE(2),WED(3),THU(4),FRI(5),SAT(6),SUN(7);
    public final int dayValue;
    private Weekday(int dayValue){
    this.dayValue = dayValue;
    }
}
