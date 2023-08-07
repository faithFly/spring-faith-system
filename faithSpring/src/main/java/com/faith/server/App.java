package com.faith.server;

import com.faith.javademo.enumdemo.Person;
import com.faith.javademo.enumdemo.Student;
import com.faith.spring.FaithApplicationContext;

import java.lang.reflect.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.StringJoiner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
/*        FaithApplicationContext faithApplicationContext = new FaithApplicationContext(AppConfig.class);
        UserServer userService = (UserServer) faithApplicationContext.getBean("userService");
        userService.test();*/
        //System.out.println(date);

        //获取字段名
        Class sclass = Student.class;
        System.out.println(sclass.getDeclaredField("score"));
        //获得私有的字段
        System.out.println(sclass.getDeclaredField("age"));
        Field age = sclass.getDeclaredField("age");
        //字段名称
        System.out.println(age.getName());
        //字段类型
        System.out.println(age.getType());
        //返回修饰符 bit类型
        int modifiers = age.getModifiers();
        System.out.println(age.getModifiers());
        //是否为public修饰符
        System.out.println(Modifier.isPublic(modifiers));

        //获取字段值 更改字段值
        Person p = new Person("faith");
        Class aClass = p.getClass();
        //获取字段
        Field declaredField = aClass.getDeclaredField("name");
        declaredField.setAccessible(true);
        //当name字段是私有的时候 就会报NoSuchFieldException 需要修改权限
        Object o = declaredField.get(p);
        System.out.println(o);
        //更改字段值
        declaredField.set(p,"evil");
        System.out.println("update" + declaredField.get(p));


        //获取实例方法
        Class<Person> personClass = Person.class;
        //获取person的getAge方法 私有的getScore方法
        System.out.println(personClass.getMethod("getAge", int.class));
        System.out.println(personClass.getDeclaredMethod("getScore"));

        //调用获取到的方法
        String str = "hello world";
        str.substring(6);
        Method substring = String.class.getMethod("substring", int.class,int.class);
        String strSub = (String) substring.invoke(str,0,4);
        System.out.println(strSub);

        Person person = new Person("acid");
        Method getScore = person.getClass().getDeclaredMethod("getScore");
        getScore.setAccessible(true);
        int invoke = (int)getScore.invoke(person);
        System.out.println(invoke);

        //调用int构造函数
        Constructor<Integer> constructor = Integer.class.getConstructor(int.class);
        Integer integer = constructor.newInstance(123);
        System.out.println(integer);

        //调用int string类型入参的构造函数
        Constructor<Integer> constructor1 = Integer.class.getConstructor(String.class);
        Integer integer1 = constructor1.newInstance("111");
        System.out.println(integer1);


        //获取父类
        Class<Integer> integerClass = Integer.class;
        Class<? super Integer> superclass = integerClass.getSuperclass();
        System.out.println(superclass);

        //获取接口
        Class<Integer> integerClass1 = Integer.class;
        Class<?>[] interfaces = integerClass1.getInterfaces();
        for (Class i:
             interfaces) {
            System.out.println(i);
        }
    }

}
