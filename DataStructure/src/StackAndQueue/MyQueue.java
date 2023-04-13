package StackAndQueue;

/**
 * @author 方锐
 * @since 2023/3/20 19:18
 */
public class MyQueue {
    static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public Node head;
    public Node tail;

    //插入
    public void offer(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = tail.next;
        }
    }

    //弹出
    public int poll(){
        if(head == null){
            return -1;
        }
        int oldVal = head.val;
        if(head.next == null){
            head = tail = null;
        }else {
            head = head.next;
        }
        return oldVal;
    }

    // 查看当前队头元素是几
    public int peek(){
        if(head == null){
            return -1;
        }
        return head.val;

    }
}
