package LinkedList;

import LinkedList.IndexIllegalException;

/**
 * @author 方锐
 * @since 2023/3/14 18:33
 */
public class MyLinkedList {
    static class ListNode{
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last;

    public void display(){
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last = node;
        }else{
            last.next = node;
            node.prev = last;
            last = last.next;
        }
    }

    public boolean contains(int key){
        ListNode cur = head;
        while(cur != null) {
            if (cur.val == key) return true;
            cur = cur.next;
        }
            return false;
        }
    public int size(){
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void addIndex(int index, int data){
        // 1.检查 index 合法性
        if(index < 0 || index > size()){
            throw new IndexIllegalException("双向链表");
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
        }
        ListNode node = new ListNode(data);
        // 2.获取到当前的index位置的节点的地址
        ListNode cur = findIndex(index);
        //插入节点和后面节点，两个节点连接
        node.next = cur;
        cur.prev.next = node;//第二个节点.prev == null,会出现空指针异常
        //插入节点和前面节点，两个节点连接
        node.prev = cur.prev;
        cur.prev = node;

    }
    private ListNode findIndex(int index){
        ListNode cur = head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //删除第一次出现 k 的节点
    public void remove(int key){
        ListNode cur = head;
        while(cur != null){
            if(cur.val == key){
                if(cur == head){//头节点情况
                    head = head.next;
                    head.prev = null;
                }else{
                    cur.prev.next = cur.next;//如果是单链表则需要curNext变量
                    if(cur.next != null){//尾节点情况
                        cur.next.prev = cur.prev;
                    }else{
                        last = cur.prev;
                    }
                }
                return;//删除完毕，结束
            }
            cur = cur.next;
        }
    }
    public void clear(){
        ListNode cur = head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;//curNext在前面走，带路，cur清除节点
        }
        head = null;
        last = null;
    }
}

