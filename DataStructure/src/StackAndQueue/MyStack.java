package StackAndQueue;

import java.util.Arrays;

/**
 * @author 方锐
 * @since 2023/3/18 10:42
 */
public class MyStack {
    public int[] elem;
    // 当前栈中已经存放的元素的数据个数，也可以是 当前可以存放数据元素的下标
    public int usedSize;

    public static final int DEFAULT_SIZE = 10;

    //赋默认容量
    public MyStack(){
        elem = new int[DEFAULT_SIZE];
    }

    //1.压栈
    public void push(int val){
        //压栈，需要判断栈是否是满的
        if(isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        // 存放到当前的下标，同时usedSize需要自增
        elem[usedSize] = val;
        usedSize++;
    }

    //2.判断栈是否已满
    public boolean isFull(){
        if(usedSize == elem.length){
            return true;
        }
        return false;
    }

    //3.删除栈顶元素
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException("栈为空了");
        }
        int oldVal = elem[usedSize-1];
        usedSize--;
        return oldVal;
    }

    //4.判断栈是否为空
    public boolean isEmpty(){
        return usedSize == 0;
    }
    //5.获取栈顶元素，但是不删除元素
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException("栈为空了");
        }
        int oldVal = elem[usedSize-1];
        return oldVal;
    }

    public int getUsedSize(){
        return usedSize;
    }
}
