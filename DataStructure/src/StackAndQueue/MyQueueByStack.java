package StackAndQueue;

import java.util.Stack;

/**
 * @author 方锐
 * @since 2023/3/30 15:42
 */
public class MyQueueByStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueueByStack(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    //入栈
    public void push(int x){
        s1.push(x);
    }

    //出栈
    public int pop(){
        if(empty()){
            return -1;
        }
        if(s2.empty()){
            // 需要先判断s2里面的状态，如果s2有元素，直接出，没有元素，
            // 需要把s1里面的元素全部都倒过来
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        //此时s2中一定有元素
        /*for(int i = 0 ; i < s1.size() ; i++){
            s2.push(s1.pop());
        }*/
        return s2.pop();
    }

    //出栈
    public int peek(){
        if(empty()){
            return -1;
        }
        if(s2.empty()){
            // 需要先判断s2里面的状态，如果s2有元素，直接出，没有元素，
            // 需要把s1里面的元素全部都倒过来
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }




    //判断空，两个栈为空，则队列为空
    public boolean empty(){
        return s1.empty() && s2.empty();
    }
}
