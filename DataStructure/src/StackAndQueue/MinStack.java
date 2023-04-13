package StackAndQueue;

import java.util.Stack;

/**
 * @author 方锐
 * @since 2023/3/30 19:22
 */
public class MinStack {
    private Stack<Integer> s ;//普通栈
    private Stack<Integer> minStack;//维护当前栈的最小值

    public MinStack(){
        s = new Stack<>();
        minStack = new Stack<>();
    }

    //入栈
    public void push(int val){
        s.push(val);//普通栈必须放
        //如果minStack为空，直接放入元素，不为空，则比较大小之后放入元素
        if(minStack.empty()){
            //为空，则直接放入
            minStack.push(val);
        }else {
            //minStack不为空，说明已经有最小值，
            // peek一下栈顶元素，和要存入的元素比较一下大小
            //注意 val <= peekV 当两个值等于的时候，也要放入
            //只放入一个的话，如果弹栈弹走一个最小值，minStack中最小的值
            //就不是 s 中最小的值，因为 s 中还存在一个最小的值
            int peekV = minStack.peek();
            if(val <= peekV){
                minStack.push(val);
            }
        }
    }

    //出栈
    public void pop(){
        if(!s.empty()){
            int popV = s.pop();
            int peekVMinS = minStack.peek();
            //如果要弹出的元素是minStack中的栈顶元素
            if(popV == peekVMinS){
                minStack.pop();

            }
        }
    }
    //查看栈顶元素
    public int top(){
        if(!s.empty()){
            return s.peek();
        }
        return -1;
    }
    //获取最小栈的栈顶元素，即栈中的最小值
    public int getMin(){
        if(!minStack.empty()){
            return minStack.peek();
        }
        return -1;
    }
}
