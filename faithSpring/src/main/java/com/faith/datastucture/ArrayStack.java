package com.faith.datastucture;

/**
 * @description:
 * @author:faith
 * @time:2023/8/1411:43
 */
public class ArrayStack {
    public static void main(String[] args) {
/*     FaithStack stack = new FaithStack(5);
     stack.push(1);
     stack.push(2);
     stack.push(3);
     stack.push(4);
     stack.push(5);
     stack.toList();
     stack.pop();
     stack.toList();*/

        //斐波那契数列的实现
        //如果说兔子在出生2个月后开始每个月就可以生一窝兔子，如果所有兔子都不死 1年后有多少只兔子
      //月份  //  1 2 3 4 5 6 7 8 9 10 11 12
// 数量（对）  //  1 1 2 3 5 8 13 21 34 55 89 144
        //观察上面的规律 从第三个数开始 后面的数等于前两个数的合
        //通过递归来实现
/*        int i;
        for (int j = 0; j < 40; j++) {
            System.out.println(Fbi(j));
        }*/
        //先来看看后缀表达式如何运算
        //9 3 1 - 3 * + 10 2 / +
        //第一个9 入栈 3 入栈 1 入栈
        //遇到-运算符 出 3 1 -运算 = 2 入栈 此时栈内是 9 2
        // 3 入栈 ==》 9 2 3
        //遇到* 运算符 出栈 3 2 *运算 = 6 入栈 此时栈内 9 6
        //遇到+ 运算符 出 9 6 +运算 = 15 入栈 此时栈内 15
        //10 入栈 2 入栈 此时栈内 15 10 2
        //遇到/运算符 10 /2 运算到5 入栈 15 5
        //遇到+运算符 15 5 出栈 15 + 5 = 20 入栈

        //中缀表达式==>后缀表达式
        //9+(3-1)*3+10/2
        //to 9 3 1 - 3 * + 10 2 / +

        //9+(3-1)*3+10/2
        //第一次遇到9 输出 9
        //遇到+ 入栈 +
        //遇到（ 入栈 + （
        //遇到3 输出 9 3
        //遇到- 入栈 ==> + （ -
        //遇到1 输出 9 3 1
        //遇到） 入栈 ==> + （ - )
        //当()闭合 从栈顶开始出栈输出 ( - ) 这里排除了括号 所以输出 - 栈内目前只有 +
        //控制台目前输出的内容==> 9 3 1 -
        //遇到了* 入栈 目前栈内 + *
        //遇到3 输出 9 3 1 - 3
        //遇到 + 入栈观察 + * + 上一个优先级比入栈的+ 高 所以全部出栈 输出 栈内目前只有+
        //控制台目前输出的内容==> 9 3 1 - 3 * +
        //栈内目前只有+ 注意这里的+号不是之前栈顶的+运算符 （就是表达式9后面的+） 现在栈内的+ 式3+10的那个3 因为遇到之前的运算符优先级比自己高把之前的都输出了
        //遇到10 输出 9 3 1 - 3 * + 10
        //遇到/ 入栈 + /
        //遇到2 输出 9 3 1 - 3 * + 10 2
        //最后输出 / +  ==> 9 3 1  - 3 * + 10 2 / +

        //喊 7
        //输入 00021
        //输出 02010
        //编号 12345
        int [] arr = {0,0,0,2,1};
        int[] ints = orderArr(arr);
        for (int i:
             ints) {
            System.out.printf("%d ",i);
        }

    }
    public static int[] orderArr(int [] arr){
        //返回的int[]
        int[] newArr = new int[arr.length];
        //一共喊了几次过
        int count = 0;
        for (int i:
             arr) {
            count+=i;
        }
        //最大域
        int index = 0;
        int num =1;
        while (true){
            if (index>=count){
                break;
            }
            if (num % 7 ==0 || Integer.toString(num).contains("7")){
                //找到这个数在数组中对应的下标
                //7 14 17 21
                //7/5取余数
                int i =(num % arr.length) - 1;
                newArr[i]++;
                index++;
            }
            num++;
        }
       return newArr;
    }


    public static int Fbi(int i){
        if (i<2){
            return  i == 0 ? 0 : 1;
        }
        return Fbi(i - 1) +Fbi(i - 2);
    }

}
class FaithStack{
    public int maxLenght;
    public int[] data;
    public int top;
    public FaithStack(int value){
        maxLenght = value;
        data = new int[maxLenght];
        top = -1;
    }
    public boolean isFull(){
        return top == maxLenght - 1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int value){
        if (isFull()){
            throw new RuntimeException("stack is full");
        }
        top++;
        data[top] = value;
    }
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        top--;
        return data[top];
    }
    public void toList(){
        if (isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack["+i+"]="+data[i]);
        }
    }
}