package com.faith.datastruct;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1710:30
 */
public class FaithHashTable {
    public static void main(String[] args) {
     FaithHashTab hash = new FaithHashTab(7);
     hash.add(new Emp(1,"faith"));
     hash.add(new Emp(2,"acid"));
     hash.add(new Emp(3,"evil"));
     hash.add(new Emp(4,"taylor"));
     hash.add(new Emp(123,"swift"));
     hash.list();
     hash.findEmpById(2);
     hash.findEmpById(5);

    }
}
class FaithHashTab{
    public EmpLinkedList[] hashlist;
    private int size;
    //初始化hashlist集合长度
    public FaithHashTab(int size){
        hashlist = new EmpLinkedList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            hashlist[i] = new EmpLinkedList();
        }
    }
    //添加雇员
    public void add(Emp obj){
        //找到要插入的list
        int index = getHash(obj.id);
        hashlist[index].add(obj);
    }
    //遍历
    public void list(){
        for (int i = 0; i < size; i++) {
            hashlist[i].display(i);
        }
    }
    public void findEmpById(int id){
        //获取下标
        int hash = getHash(id);
        Emp empByID = hashlist[hash].findEmpByID(id);
        if (empByID != null){
            System.out.println("在链表"+hash+"=>userid="+empByID.id+",userName="+empByID.name);
        }
    }
    private int getHash(int num){
        return num % size;
    }
}
class EmpLinkedList{
    public Emp head;
    public void add(Emp obj){
         if (head == null){
             head = obj;
             return;
         }
         Emp temp = head;
         while (true){
             if (temp.next == null){
                 temp.next = obj;
                 break;
             }
             temp = temp.next;
         }
    }
    public void display(int index){
        if (head == null){
            System.out.println("链表index"+index+"为null");
            return;
        }
        Emp temp = head;
        while (temp!=null){
            System.out.println("链表index"+index+":id=>"+temp.id+",姓名=>"+temp.name);
            temp = temp.next;
        }
    }
    public Emp findEmpByID(int id){
        if (head == null) {
            System.out.println("链表为null");
            return null;
        }
        Emp temp = head;
        while (true){
            if (temp == null){
                System.out.println("没有找到");
                return null;
            }
            if (temp.id == id){
                return temp;
            }
            temp = temp.next;
        }
    }
}
class Emp{
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int id;
    public String name;
    public Emp next;

}
