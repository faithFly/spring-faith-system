package com.faith.datastruct;

import java.util.HashSet;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1617:26
 */
public class HashSetTest {
    public static void main(String[] args) {
        //hashset 是基于hashmap来实现的，是一个不允许有重复元素的集合
        //1.hashset允许有null值
        //2.hashset是无序的，他不会保存下元素插入的顺序
        //3.hashset是线程不安全的，在多个线程中尝试修改hashset的时候，最终结果是不稳定的 实现了set接口
        HashSet<String> set = new HashSet<>();
        set.add("faith");
        set.add("acid");
        set.add("evil");
        set.add("faith");
        System.out.println(set);
        //是否包含
        set.contains("faith");
        //删除元素
        set.remove("acid");
        System.out.println(set);
        //计算长度
        System.out.println(set.size());
        //迭代
        for (String a:
             set) {
            System.out.println(a);
        }
    }
}
