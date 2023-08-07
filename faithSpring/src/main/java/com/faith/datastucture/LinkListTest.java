package com.faith.datastucture;

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
        Hero h1 = new Hero(1,"宋江","呼保义");
        Hero h2 = new Hero(3,"卢俊义","玉麒麟");
        Hero h3 = new Hero(2,"吴用","智多星");
        Hero h4 = new Hero(5,"公孙胜","入云龙");
        SingLinkList linkList = new SingLinkList();
        linkList.add(h1);
        linkList.add(h2);
        linkList.add(h3);
        linkList.add(h4);
        linkList.toList();
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
