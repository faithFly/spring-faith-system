package com.faith.datastruct;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1516:54
 */
public class LinkListTest {
    public static void main(String[] args) {
        /*Node linkList = new Node();
        linkList.add(1);
        linkList.add(5);
        linkList.add(2);
        linkList.add(8);
        linkList.showNode();// 1 5 2 8
        System.out.println("链表个数：" + linkList.Count());
        //删除第四个节点
        linkList.removeIndex(3);
        linkList.showNode();// 1 5 2
        System.out.println(linkList.Contains(3));
        //头插法 尾插就是默认的add
        linkList.headAdd(6);
        //sout 6 1 5 2
        linkList.showNode();*/
/*        LinkList list = new LinkList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.showNode();
        System.out.println("=========");
        LinkList list1 = new LinkList();
        list1.add(2);
        list1.add(2);
        list1.add(2);
        list1.showNode();
        System.out.println("=========");
        list.mergeNode(list1);
        list.showNode();*/
        LinkList list = new LinkList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.showNode();
        System.out.println("===========");
        list.reversalNode();
        list.showNode();
/*        linkList.add(1);
        linkList.add(1);
        linkList.add(1);*/
/*        Node linkList1 = new Node();
        linkList1.add(2);
        linkList1.add(2);
        linkList1.add(2);
        linkList.showNode();*/
        //System.out.println("=========");
        //linkList1.showNode();
        //Node node = linkList.mergeNode(linkList1);
        //node.showNode();
    }
}
//线性表分为顺序存储结构（地址连续）
//还有链式存储结构（地址不连续 每个节点指向下个节点）
//手写单链表
//这里的data我就单独使用一个int 好了 实际中其实这里可以是个实体对象
//Node可以理解为节点的意思
class LinkList{
    //这里为什么要多加一个head头节点呢 原来我直接写在了node里面
    public Node head = new Node();
    //新增节点
    public void add(int value){
        //将node节点的最后一个值指向new Node(value)对象
        //新建一个node 地址指向head 引用类型都是在栈存储了堆的内存地址
        //如果不新建的花 遍历的时候指向下个节点 head = head.next
        //等到get的时候 发现head变成了最后一个节点
        Node temp = head;
        //遍历
        while (true){
            if (temp.next == null){
                temp.next = new Node(value);
                return;
            }
            //当前遍历节点指向下个节点
            temp = temp.next;
        }
    }

    //打印链表
    public void showNode(){
        //输出当前的单链表
        //因为需要遍历改变遍历节点位置 那么这里的话依然需要temp
        //这里为什么要使用head.next??
        //因为在遍历的时候需要把当前指向位置往后移动 temp = temp.next;
        //while中的判断条件肯定是temp.next 输出一下就break 但是temp第一次 head有个头节点 他的next不是null 会输出 我们要把开始定在头节点的下一个
        Node temp = head.next;
        if (temp == null){
            System.out.println("链表为null");
            return;
        }
        while (true){
            //如果temp == null break
            if (temp == null){
                break;
            }
            //sout
            System.out.printf("val=%d,hashCode=",temp.data);
            //输出一下temp的内存地址 看是不是有顺序的
            System.out.println(temp.hashCode());
            //指向下一个
            temp = temp.next;
        }
    }

    //删除
    public void removeIndex(int index){
        // 0 1 2 3 4 5 6
        //test 01 delete 0
        //test 02 delete 1
        // delete 5 index
        if (index < 0 || index > Count()){
            System.out.println("请输入正确的下标");
        }
        //删除第一个元素
        if (index == 0 ){
            head.next = head.next.next;
            //head 0  //1 2 3 4 5 6
        }
        int i = 0;
        Node temp = head;
        while (temp.next != null){
            if (i != index){
                temp = temp.next;
                i++;
            }
            else {
                temp.next = temp.next.next;
            }
        }
    }

    //获取单链表的长度
    public int Count(){
        int count =0;
        Node temp = head.next;
        while (temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    //查看链表中是否包含元素
    public boolean Contains(int key){
        Node temp = head.next;
        while (temp != null){
            if (temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //头插
    public void headAdd(int val){
        Node temp = head;
        if (temp.next == null){
            head.next = new Node(val);
        }else {
            Node ins = new Node(val);
            ins.next = head.next;
            head.next = ins;
        }
    }

    //清空
    public void clear(){
        head.next = null;
    }

    //获取头节点
    public Node gethead(){
        return head;
    }

    //合并链表
    public void mergeNode(LinkList list){
        //head最后的指向指向list.next
        if (head.next == null){
            head.next = list.gethead().next;
        }
        Node temp = head.next;
        while (true){
            if (temp.next == null){
                temp.next = list.gethead().next;
                break;
            }
            temp = temp.next;
        }
    }

    //反转Node
    public void reversalNode(){
        if (head.next == null || head.next.next == null){
            return;
        }
        //0 1 2 3 4
        //4 3 2 1 0
        Node cur = head.next;//1 2 3 4
        Node next = null;
        Node zz = new Node();
        while (cur != null){
            //第一次
            //1.next =>2 3 4
            //2.cur => 1
            //3.zz => 0 1
            //4.cur=>2 3 4

            //第二次
            // 1.next=>3 4
            //2.cur => 2 1
            //3.zz => 0 2 1
            //cur => 3 4

            //第三次
            //1.next=> 4
            //2.cur => 3 2 1
            //3.zz  => 0 3 2 1
            //4.cur => 4
            next = cur.next;
            cur.next = zz.next;
            zz.next = cur;
            cur = next;
        }
        head.next=zz.next;
    }

}
class Node{
     public int data;
     public Node next;
     //构造函数 给头节点一个默认值
     public Node(){
         data = 0;
     }
     //add的时候需要newNode把value值放进去
     public Node(int val){
         data = val;
     }

}
