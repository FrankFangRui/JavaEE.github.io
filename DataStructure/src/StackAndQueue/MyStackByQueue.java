package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 方锐
 * @since 2023/3/30 14:46
 */
public class MyStackByQueue {
    Queue<Integer> qu1;
    Queue<Integer> qu2;
    public int usedSize = 0;
    public MyStackByQueue(){
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    //入栈
    /*如果qu1不为空，放入qu1，qu1为空，放入qu2,qu2为空，还是放入qu1
    * 哪个是空的，放入哪个，两个都是空的，放入qu1*/
    public void push(int x){
        if(!qu1.isEmpty()){
            qu1.offer(x);
        }else if(!qu2.isEmpty()){
            qu2.offer(x);
        }else {
            qu1.offer(x);
        }
        usedSize++;
    }
    //出栈
    public int pop(){
        if(empty()){
            return -1;
        }
        /*if(!qu1.isEmpty()){
            //qu1不为空,把 qu1 元素弹出，只剩下一个元素，哪个元素就是栈顶元素
            //每次循环，有弹出元素，那么 size() 就会变化，每弹出一个元素，size()变小，导致错误
        for(int i = 0 ; i < qu1.size() - 1 ; i++){
                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        }else{
            for(int i = 0 ; i < qu2.size() - 1 ; i++){
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }*/
        if(!qu1.isEmpty()){
            //qu1不为空,把 qu1 元素弹出，只剩下一个元素，哪个元素就是栈顶元素
            //每次循环，有弹出元素，那么 size() 就会变化，每弹出一个元素，size()变小，导致错误
            int curSize = qu1.size();
            for(int i = 0 ; i < curSize - 1 ; i++){
                qu2.offer(qu1.poll());
            }
            usedSize--;
            return qu1.poll();
        }else{
            int curSize = qu2.size();
            for(int i = 0 ; i < curSize - 1; i++){
                qu1.offer(qu2.poll());
            }
            usedSize--;
            return qu2.poll();
        }
    }
    //peek
    public int top(){
        if(empty()){
            return -1;
        }
        // 相比于 pop ,用一个ret来经手每一个传送到另一个队列的元素，最后一个经手的元素
        // 就是“栈顶”的元素，而且不会有其他操作，只是peek一下
        if(!qu1.isEmpty()){
            int curSize = qu1.size();
            int ret = -1;
            for(int i = 0 ; i < curSize ; i++){
                ret = qu1.poll();
                qu2.offer(ret);
            }
            return ret;
        }else{
            int curSize = qu2.size();
            int ret = -1;
            for(int i = 0 ; i < curSize ; i++){
                ret = qu2.poll();
                qu1.offer(ret);
            }
            return qu2.poll();
        }
    }


    //判断队列是否为空
    public boolean empty(){
        return usedSize == 0;
    }
    public boolean empty2(){
        return qu1.isEmpty() && qu2.isEmpty();
    }
}
