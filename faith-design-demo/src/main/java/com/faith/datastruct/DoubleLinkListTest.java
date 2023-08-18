package com.faith.datastruct;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1611:39
 */
public class DoubleLinkListTest {
    public static void main(String[] args) {
    DoubleLinkedList list = new DoubleLinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.headAdd(4);
    list.display();
    System.out.println("=========");
    list.delete(0);
    list.display();
    }
}
class DoubleLinkedList{
    public DoubleNode head = new DoubleNode();
    //前插
    public void headAdd(int val){
        if (head.next == null){
            head.next = new DoubleNode(val);
            return;
        }
        DoubleNode temp = head;
        DoubleNode node = new DoubleNode(val);
        temp.next.prior = node;
        node.next = temp.next;
        temp.next = node;
    }
    //后插
    public void add(int val){
        if (head.next == null){
            //第一个没有前驱节点这里不加就是null
            head.next = new DoubleNode(val);
            return;
        }
        DoubleNode temp = head;
        while (true){
            if (temp.next == null){
                //add
                temp.next = new DoubleNode(val);
                temp.next.prior = temp;
                break;
            }
            temp = temp.next;
        }
    }
    //删除
    public void delete(int index){
        if (head.next == null){
            System.out.println("链表为null");
            return;
        }
        if (head.next.next == null){
            //只有一个值
            head = null;
            return;
        }
        DoubleNode temp = head.next;
        int count = 0;
        while (true){
            if (count == index){
                //delete
                //前面的next指向后面节点
                //后面的pr指向前面的节点
                //如果删除的是最后一个
                if (temp.next == null){
                    temp.prior.next = null;
                    break;
                }
                //删除的是第一个节点的话
                else if (temp.next.prior == null) {
                    temp.next = temp.next.next;
                    temp.next.prior = null;
                    break;
                }else {
                    temp.prior.next = temp.next;
                    temp.next.prior = temp.prior;
                    break;
                }

            }
            count++;
            temp = temp.next;
        }
    }

    public void display(){
        if (head.next == null){
            System.out.println("链表为null");
        }
        DoubleNode temp = head.next;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
class DoubleNode{
    public int data;
    //前指针
    public DoubleNode prior;
    //后指针
    public DoubleNode next;
    public DoubleNode(){
        data = 0;
    }
    public DoubleNode(int val){
        data = val;
    }
}