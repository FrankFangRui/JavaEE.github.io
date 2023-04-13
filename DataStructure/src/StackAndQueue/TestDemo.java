package StackAndQueue;

/**
 * @author 方锐
 * @since 2023/3/18 10:43
 */
public class TestDemo {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());

        /*MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 获取栈顶元素 但是不删除
        int val = stack.peek();
        System.out.println(val);
        // 删除栈顶元素
        int val2 = stack.pop();
        System.out.println(val2);
        int val3 = stack.peek();
        System.out.println(val3);
        stack.pop();
        stack.pop();
        boolean flag = stack.isEmpty();
        System.out.println(flag);
        *//*in t val4 = stack.peek();
        System.out.println(val4);*//*
        // size() 是 Stack 父类的方法
        System.out.println(stack.getUsedSize());*/
    }
}
