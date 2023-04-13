package LinkedList;

/**
 * @author 方锐
 * @since 2023/4/4 10:01
 */
public class MyCircularQueue2 {
    //环形队列底层是数组
    public int[] elem;
    //队头的下标
    public int front;
    //队尾的下标
    public int rear;

    //判断队列是否为满
    //假设 front 等于 8 ，当 rear 等于 7 的时候就会返回true
    //导致入队操作停止，此时下标为 7 的位置还没有放入元素
    public boolean isFull(){
        return (rear + 1) % elem.length == front;
    }

    //判断队列是否为空
    //当有 isFull() 来判断队列是否为满之后
    //出现当队列满了，rear 和 front 之间一定会有一个空的格子
    //所以就排除 rear == front 时队列满的情况，只剩下队列是
    //空的情况
    public boolean isEmpty(){
        return rear == front;
    }

    //构造方法
    public MyCircularQueue2(int k){
        this.elem = new int[k];
    }

    //入队
    public boolean enQueue(int value){
        // 判断是否已满
        if(isFull()){
            return false;
        }
        // 向队尾存入值
        elem[rear] = value;
        // 移动队尾下标
        rear = (rear + 1) % elem.length;
        return true;
    }

    //出队
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % elem.length;
        return true;
    }

    //返回 front 处元素
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return elem[front];                                    
    }



}
