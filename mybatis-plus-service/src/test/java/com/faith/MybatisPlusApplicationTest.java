package com.faith;/**
 * @Author: faith
 * @Description: TODO
 * @DateTime: 2023/5/31 16:16
 **/

import com.faith.domain.Person;
import com.faith.domain.Student;
import com.faith.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@description:
 *@author:faith
 *@time:2023/5/3116:16
 */
@SpringBootTest
public class MybatisPlusApplicationTest {
//    @Autowired
//    private UserMapper mapper;
//    @Test
//   public void test01(){
//        //参数是wapper 条件构造器
//        List<Student> list = mapper.selectList(null);
//        for (Student student:
//             list) {
//            System.out.println(student);
//        }
//    }
@Test
public void test01(){
    //在JDK8时，JAVA新增了lambda表达式，它与 java.io 包里的 InputStream和 OutputStream是完全不同的概念，他更跟流没有任何关系。它也不同于 StAX 对 XML解析的 Stream，也不是 Amazon Kinesis 对大数据实时处理的Stream。
    //
    //JDK8 中的 Stream 是对集合（Collection）对象功能的增强，它借助于lambda表达式，更优雅的表达风格，极大的提高编程效率和程序可读性。它针对于对集合对象进行各种非常便利、高效的聚合操作，或者大批量数据操作。

    List<Person> list = new ArrayList<>();
    Person person = new Person(1,"faith",25,"衢州");
    Person person1 = new Person(1,"evil",25,"杭州");
    Person person2 = new Person(3,"acid",25,"杭州");
    Person person3 = new Person(4,"taylor",25,"温州");
    list.add(person1);
    list.add(person);
    list.add(person2);
    list.add(person3);
    //查询id为1的
    //传统方式
    ArrayList<Person> plist = new ArrayList<>();
    for (Person p:
         list) {
        if (p.getId() == 1){
        plist.add(p);
        }else {
            continue;
        }
    }
//    new Thread(new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("hello");
//        }
//    });

    plist.forEach(System.out::println);
    //stream流方式实现 获取id为1的
    List<Person> collect = list.stream().filter(p -> p.getId() == 1).collect(Collectors.toList());
    long count = list.stream().filter(p -> p.getId() == 1).count();
    collect.forEach(System.out::println);
    System.out.println(count);
}
@Test
public void test02(){
    Long a = 100L;
    Long b = 100L;
    System.out.println(a == b);

    Long c = new Long(100L);
    Long d = new Long(100L);
    System.out.println(c==d);

    Long e = new Long(200L);
    int g = 200;
    System.out.println(e == g);

    Long x = 200L;
    Long l = 200L;
    System.out.println(x == l);
    System.out.println(x.equals(l));
}
}
