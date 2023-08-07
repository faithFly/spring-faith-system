package com.faith.javademo.enumdemo;

import java.math.BigDecimal;

/**
 * @description:
 * @author:faith
 * @time:2023/8/19:58
 */
public class EnumApp {
    public static void main(String[] args) {
        System.out.println(new BigDecimal("123.4567"));

        BigDecimal decimal = new BigDecimal("123.4567");
        System.out.println(decimal.multiply(decimal));
        //小数点
        System.out.println(decimal.scale());


        BigDecimal d1 = new BigDecimal("123.4500");
        //通过BigDecimal的stripTrailingZeros()方法，可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal：
        BigDecimal d2 = d1.stripTrailingZeros();
        System.out.println(d2);

        BigDecimal d3 = new BigDecimal("1234500");
        BigDecimal d4 = d3.stripTrailingZeros();
        System.out.println(d4);
    }
}
