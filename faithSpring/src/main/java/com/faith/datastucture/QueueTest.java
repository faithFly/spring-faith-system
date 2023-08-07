package com.faith.datastucture;

/**
 * @description:
 * @author:faith
 * @time:2023/8/416:31
 */
public class QueueTest {
    public static void main(String[] args) {
/*        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        System.out.println(arrayQueue.getHead());

        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getHead());

        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getHead());

        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getHead());

        System.out.println(arrayQueue.getHead());*/
        System.out.println(2%3);
    }
}
class ArrayQueue{
    public int maxSize;
    public int front;
    public int last;
    public int[] arr;

    public ArrayQueue(int size){
        maxSize = size;
        arr = new int[size];
        front = -1;
        last = -1;
    }
    public void addQueue(int num){
        if (isFull()){
           throw new RuntimeException("队列已满");
        }
        last++;
        arr[last] = num;
    }
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        front++;
        return arr[front];
    }
    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front + 1];
    }
    public boolean isEmpty(){
        return front == last;
    }
    public boolean isFull(){
        return last == maxSize - 1;
    }
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {

        }
    }
}
