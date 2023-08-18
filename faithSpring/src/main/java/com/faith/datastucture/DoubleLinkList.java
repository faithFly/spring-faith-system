package com.faith.datastucture;

import java.util.Stack;

/**
 * @description:
 * @author:faith
 * @time:2023/8/910:12
 */
public class DoubleLinkList {
    public static void main(String[] args) {
        DoubleNode node = new DoubleNode(0);
        node.add(1);
        node.add(2);
        node.add(3);
        node.display();
        System.out.println(node.Count());
        System.out.println(node.getIndex(1).value);
    }

}
class DoubleNode{
    int value;
    DoubleNode pre;
    DoubleNode next;
    public static DoubleNode head = new DoubleNode(0);
    public DoubleNode(int value){
        this.value = value;
        pre = null;
        next = null;
    }

    //尾部新增
    // 1 2 3
    public void add(int i){
        DoubleNode temp = head;
        while (true){
            if (temp.next == null){
             //insert
                temp.next = new DoubleNode(i);
                temp.next.pre = temp.next;
                return;
            }
            temp = temp.next;
        }
    }

    //正向输出列表
    public void display(){
      DoubleNode temp = head.next;
      while (temp != null){
          System.out.println(temp.value);
          temp = temp.next;
      }
    }

    //leght
    public int Count(){
        DoubleNode temp = head.next;
        int count = 0;
        while (temp !=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    //getIndex
    public DoubleNode getIndex(int i){
        if (i < 0 || i > Count()){
            System.out.println("下标有误");
        }
        DoubleNode temp = head.next;
        DoubleNode res = null;
        int count = 0;
        while (temp != null)
        {
            if (count == i){
               res =temp;
            }
            count++;
            temp = temp.next;
        }
        return res;
    }

    //反转双链表 123 321
    public void reversaNode(){
        DoubleNode temp = head.next;
        if (head.next == null || head.next.next == null){
            System.out.println("双链表为null");
        }
        DoubleNode next = null;
        DoubleNode newNode = new DoubleNode(0);
        while (temp != null){
            next = temp.next; //1 2 3
            temp.next = newNode; //头部成 1
            newNode.next = next;
            temp = temp.next;
        }
    }

}
