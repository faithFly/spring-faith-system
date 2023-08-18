package com.faith.datastruct;

import java.util.HashMap;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1617:31
 */
public class HashMapTest {
    public static void main(String[] args) {
        //hashmap是个散列表 他存储的内容是键值对映射的
        //hashmap实现了map接口，根据键的hashcode值存储数据，具有很快的访问的速度，最多允许一条记录的键为null，不支持线程同步
        //hashmap无序的
        //HashMap 继承于AbstractMap，实现了 Map、Cloneable、java.io.Serializable 接口。

        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"faith");
        map.put(2,"acid");
        map.put(3,"evil");
        map.put(4,"swift");
        System.out.println(map);
        HashMap<String,String> strMap = new HashMap<String,String>();
        strMap.put("qqq","faith");
        strMap.put("www","acid");
        strMap.put("eee","evil");
        strMap.put("rrr","swift");
        System.out.println(strMap);

        //访问元素
        String s = map.get(3);
        System.out.println(s);
        System.out.println(strMap.get("rrr"));
        //删除元素
        map.remove(1);
        System.out.println(map);
    }
}
