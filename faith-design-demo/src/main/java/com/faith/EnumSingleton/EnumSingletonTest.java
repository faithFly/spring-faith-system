package com.faith.EnumSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author:faith
 * @time:2023/7/1313:36
 */
public enum EnumSingletonTest {
    INSTANCE;
    private EnumSingletonTest getInstance(){
        return INSTANCE;
    }
}
class EnumSingleton{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSingletonTest instance = EnumSingletonTest.INSTANCE;
        Constructor<EnumSingletonTest> constructor = EnumSingletonTest.class.getConstructor(String.class,int.class);
        EnumSingletonTest enumSingletonTest = constructor.newInstance();
        System.out.println(instance == enumSingletonTest);
    }
}
