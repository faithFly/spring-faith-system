package com.faith.datastucture;

import java.util.ArrayList;

/**
 * @description:
 * @author:faith
 * @time:2023/8/816:23
 */
public class LinkedList {
    public static void main(String[] args) {
        //默认头节点
        Node node = new Node();
        //制造测试数据 1 2 3
        for (int i = 1; i <= 3; i++) {
            node.add(i);
        }
        //正向输出
        node.display();

    }

}
class Node{
    int value;
    Node next;
    public static Node node = new Node();
    public Node(){
        value = 0;
        next = null;
    }
    public Node(int i){
        value = i;
        next = null;
    }

    /*
    *  尾部插入
     * @description:
     * @author: faith
     * @date: 2023/8/8 17:29
     * @param: []
     * @return: void
     **/
    public void add(int i){
        Node temp = node;
        while (true){
            if (temp.next == null){
                temp.next = new Node(i);
                break;
            }
            temp = temp.next;
        }
    }
    /*
     *  正向输出
     * @description:
     * @author: faith
     * @date: 2023/8/8 17:16
     * @param: [node]
     * @return: void
     **/
    public void display(){
        if (node == null){
            System.out.println("null");
        }
        Node temp = node.next;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}