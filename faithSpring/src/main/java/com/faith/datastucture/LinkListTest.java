package com.faith.datastucture;

import java.util.Stack;

/**
 * @description:
 * @author:faith
 * @time:2023/8/79:53
 */
public class LinkListTest {
    public static void main(String[] args) {
        //1.链表是以节点的方式进行存储的
        //头指针就是 130指向a1
        //地址   data域     next域
        //110   a2         150
        //120   a5         null
        //130   a1         110
        //140   a4         120
        //150   a3         140
        //2.每个节点包含data域，next域 指向下一个节点
        //3.如上发现链表的各个节点不一定是连续存放的
        //4.链表分带头节点的链表和没有头节点的链表，根据实际的需求来确定
/*        Hero h1 = new Hero(1,"宋江","呼保义");
        Hero h2 = new Hero(3,"卢俊义","玉麒麟");
        Hero h3 = new Hero(2,"吴用","智多星");
        Hero h4 = new Hero(5,"公孙胜","入云龙");
        Hero h5 = new Hero(5,"faith","zzz");
        SingLinkList linkList = new SingLinkList();
        linkList.addById(h1);
        linkList.addById(h2);
        linkList.addById(h3);
        linkList.addById(h4);
        System.out.println("===============");
        linkList.deleteById(5);
        linkList.toList();*/

        //单链表常用面试题
        //1.求单链表中节点个数
        Hero h1 = new Hero(1,"宋江","呼保义");
        Hero h2 = new Hero(2,"卢俊义","玉麒麟");
        Hero h3 = new Hero(3,"吴用","智多星");
        Hero h4 = new Hero(4,"公孙胜","入云龙");
        Hero h5 = new Hero(5,"faith","zzz");
        Hero h6 = new Hero(6,"lll","lll");
        SingLinkList linkList = new SingLinkList();
        SingLinkList linkList1 = new SingLinkList();
        linkList.addById(h1);
        linkList.addById(h2);
        linkList.addById(h3);
        linkList1.addById(h4);
        linkList1.addById(h5);
        linkList1.addById(h6);
        //linkList1.reversalList();
        linkList1.toList();
        linkList1.deleteById(6);
        linkList1.toList();
        //SingLinkList merge = merge(linkList, linkList1);
        //merge.toList();



/*        Hero indexDesc = linkList.getIndexDesc(3);
        System.out.println(indexDesc);
        System.out.println("========");
        linkList.toList();
        //2.查找单链表中倒数第k个结点
        System.out.println("========");
        //3.单链表的反转
        //linkList.reversalList();
        linkList.toListDesc();
        System.out.println("========");
        linkList.toList();*/
        //4.从头到尾打印单链表
        //合并两个有序链表，合并之后的链表依然有序
    }
    /*
    *  合并有序的单链表 合并之后依然有序
     * @description:
     * @author: faith
     * @date: 2023/8/8 15:08
     * @param: []
     * @return: void
     **/
    public static SingLinkList merge(SingLinkList firstList,SingLinkList secondList){
        int count = firstList.Count();
        for (int i = 1; i <= count; i++) {
            Hero indexDesc = firstList.getIndexDesc(i);
            secondList.add(indexDesc);
        }
        return secondList;
    }
}
class SingLinkList{
    private Hero hero = new Hero(0,"","");

    //向单链表的尾部插入
    public void add(Hero insertHero){
        Hero temp = hero;
        while (true){
            //最后节点为null退出
            if (temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(insertHero);
    }
    //按照顺序排序插入
    public void addById(Hero insertHero) {
        Hero temp = hero;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getId() > insertHero.getId()) {
                break;
            } else if (temp.getNext().getId() == insertHero.getId()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag){
            System.out.println("已经存在");
        }else{
            insertHero.setNext(temp.getNext());
            temp.setNext(insertHero);
        }
    }
    //更新单链表
    public void updateById(Hero updateHero){
        if (hero.getNext() == null){
            System.out.println("链表为null");
            return;
        }
        Hero temp = hero;
        while (true){
            if (temp == null){
                System.out.println("没有找到");
                break;
            }
            if (temp.getId() == updateHero.getId()){
                temp.setName(updateHero.getName());
                temp.setNickName(updateHero.getNickName());
                break;
            }
            temp = temp.getNext();
        }
    }
    //删除单链表
    public void deleteById(int id){
            if (hero.getNext() == null){
                System.out.println("链表为null");
                return;
            }
            Hero temp = hero;
            while (true){
                if (temp == null){
                    System.out.println("没有找到");
                    break;
                }
                if (temp.getNext().getId() == id){
                    temp.setNext(temp.getNext().getNext());
                    break;
                }
                temp = temp.getNext();
            }
    }
    //输出
    public void toList(){
        if (hero.getNext() == null){
            System.out.println("链表为null");
            return;
        }
        Hero temp = hero.getNext();
        while (true){
        if (temp==null){
            break;
        }
        System.out.println(temp);
        temp = temp.getNext();
        }
    }

    /*
    *  解决思路 将单链表的节点依次添加到栈中 栈--》先进后出原理 再遍历打印
     * @description:
     * @author: faith
     * @date: 2023/8/8 15:05
     * @param: []
     * @return: void
     **/
    public void toListDesc(){
        Stack<Hero> stack = new Stack<>();
        Hero cur = hero.getNext();
        while (cur != null){
            stack.push(cur);
            cur = cur.getNext();
        }
        //打印
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }
    public int Count(){
        if (hero.getNext() == null){
            return 0;
        }
        Hero temp = hero;
        int count =0;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            count++;
            temp = temp.getNext();
        }
        return count;
    }
    //查找单链表中倒数第k个结点
    public Hero getIndexDesc(int index){
        int length = Count();
        if (hero.getNext() == null){
            throw new RuntimeException("链表为null");
        }
        if (index > length){
            throw new RuntimeException("下标超出链表长度");
        }
        if (index <= 0){
            throw new RuntimeException("下标不能小于等于0");
        }
        int count = 0;
        int num = length - index;
        Hero temp = hero.getNext();
        for (int i = 0; i < num; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
    public void reversalList(){
        //没有节点和只有一个节点返回 不需要反转
        if (hero.getNext()==null||hero.getNext().getNext() == null){
            return;
        }
        Hero cur = hero.getNext();
        Hero next = null;
        Hero zz = new Hero(0,"","");
        while (cur != null){
           next=cur.getNext();
           cur.setNext(zz.getNext());
           zz.setNext(cur);
           cur = next;
        }
        hero.setNext(zz.getNext());
    }
}
//hero
class Hero{
    private int id;
    private String name;
    private String nickName;
    private Hero next;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Hero getNext() {
        return next;
    }

    public void setNext(Hero next) {
        this.next = next;
    }

    public Hero(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
