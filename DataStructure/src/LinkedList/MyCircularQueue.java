package LinkedList;

class MyCircularQueue {

    public int[] elem;
    public int usedSize;
    public int front;//队头下标
    public int rear;//队尾下表

    public MyCircularQueue(int k) {
        this.elem = new int[k];
    }
    //入队
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        this.elem[rear] = value;
        //这里千万不能： rear++  可能会把 front 给覆盖了
        rear = (rear+1) % elem.length;
        return true;
    }
    // 出队
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        // front--;
        front = (front + 1) % elem.length;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return elem[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int index = (rear == 0) ? elem.length-1 : rear-1;
        return elem[index];
    }
    
    public boolean isEmpty() {
        return rear == front;
    }
    
    public boolean isFull() {
        return (rear + 1) % elem.length == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */