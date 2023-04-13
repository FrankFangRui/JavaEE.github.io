package LinkedList;

public class TestSingleList {
    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
        public Node head;


        public void createList() {
            Node node1 = new Node(0);
            Node node2 = new Node(1);
            Node node3 = new Node(2);
            Node node4 = new Node(3);
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            head = node1;
        }

        public void display(){
            Node cur = head;
            while(cur != null){
                System.out.println(cur.val);
                cur = cur.next;
            }
        }

        public boolean contains(int key){
            Node cur = head;
            while(cur != null){
                if(cur.val == key){
                    return true;
                }else{
                    cur = cur.next;
                }
            }
            return false;
        }
        // 头插法 O(1)
        public void addFirst(int data){
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
        // 尾插法 O(n)
        public void addLast(int data){
            Node node = new Node(data);
            if(head == null){
                head = node;
            }else {
                Node cur = head;
                // 从头开始遍历，当 cur.next = null 的时候，说明 cur 已经到达链表末尾
                // 只需要把最后一个要加入的节点连上即可
                while(cur.next != null){
                    cur = cur.next;
                }
                cur.next = node;
          }
            /* Node cur = head;
            while(cur != null){
                if(cur.next == null){
                    cur.next = node;
                    node.next = null;
                }
                cur = cur.next;
            }*/
        }

        private void checkIndex(int index){
            if(index < 0 || index > size()){
                throw new IndexIllegalException("index位置不合法");
            }
        }
        // while(cur != null)
        // 最后一次循环，循环内部 cur 处于最后一个节点
        // 循环结束 cur 变成 null

        // while(cur.next != null) 最后一次循环 cur 是在倒数第二个节点，循环结束之后
        //  cur 处于 最后一个节点

        // 任意位置插入，第一个数据节点为0号下标
        public void addIndex(int index ,int data) {
            checkIndex(index);
            if (index == 0) {
                addFirst(data);
                return;
            }
            if (index == size()) {
                addLast(data);
                return;
            }
            Node node = new Node(data);
            Node cur = FindIndexSubOfOne(index);
            node.next = cur.next;
            cur.next = node;
            //排除头插尾插



            /*// 需要知道插入位置节点的上一个节点地址
            // 排除一下一个节点为null的情况

            // 创建要插入的节点
            Node node = new Node(data);
            // 检查下标是否超出范围
            checkIndex(index);
            // 设置当前节点为头节点，方便遍历
            Node cur = head;
            // 因为头插的情况会在 while 循环的时候略过，因为在进行 cur.next 的时候直接从第二个
            // 开始判断，跳过了第一个节点
            if( index == 0 ){// 头插的情况
                node.next = head;
            }else {
                // 来对下标进行计算
                int count = 0;
                // 如果是尾插的话，cur.next.next 本来是就是 null ,直接赋值给 node.next

                //  cur.next != null 在 while 循环中作为判断，会导致没有办法尾插
                //  因为当遍历到 cur.next == null 的时候就跳过 while 循环了
                while(cur.next != null){
                    if(count == index - 1){
                        node.next = cur.next;// 先把要存入的节点尾巴和后面连上
                        cur.next = node;// 在把节点前面给连上
                        // 如果顺序颠倒的话，cur.next 已经被 node 给覆盖了
                        break;
                    }else{
                        cur = cur.next;// 没有达到目标下标，把当前节点向前推进
                    }
                    count++;
                }
                if(cur.next == null){
                    cur.next = node;
                }*/
        }

        private Node FindIndexSubOfOne(int index){
            Node cur = head;
            //用下标来做计数器，聪明的一匹，不用单独构造变量
            while(index-1 != 0){
                cur = cur.next;
                index--;
            }
            return cur;
        }

        //得到单链表的长度
        public int size(){
            int count = 0;
            Node cur = head;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count;
        }

        //删除第一次出现关键字为 key 的节点

        public void remove(int key){
            // 处理特殊情况，这种特殊情况出现的原因是 cur.next.val ,既要留着 cur 地址来返回前驱（key的前驱）又要比较cur.next.val的值
            // 是否正确配对，所以会漏掉第一个节点
            if(head.val == key){
                head = head.next;
                return;
            }
            Node cur = searchPrevOfKey(key);
            if(cur == null) return;// 没找到这个 key
            /*Node del = cur.next;// 先把前驱节点的指向下一个节点的地址保存起来
            cur.next = del.next;// 再把要删除的节点的next指向 cur 的next 完成跳过节点*/
            cur.next = cur.next.next;
        }

        /**
         * 找到关键字 key 的前驱
         * @param key
         * @return
         */
        private Node searchPrevOfKey(int key) {
            // 错误： Node cur = new Node(key); 不是新建一个节点而是建立一个指向头节点的节点

            Node cur = this.head;
            while(cur.next != null){
                //遍历到最后一个节点
                if(cur.next.val == key){
                    return cur;
                }
                cur = cur.next;
            }
            return null;

            /*while(cur.next.next != null){ // 遍历完整个链表
                if(cur.next.next == null && cur.next.val == key){
                    return cur;// 返回最后一个节点的先驱节点
                }else if(cur.next.val == key){
                    return cur;
                }
                cur = cur.next;
            }*/

        }


        public void remove2(int key){
            Node cur = head;
            if(cur.val == key){
                head = cur.next;
            }else{
                int flag = 0;
                while(cur != null && flag == 0){
                    if(cur.next != null && cur.next.val == key){
                        cur.next = cur.next.next;
                        flag = 1;
                    }
                    cur = cur.next;
                }
                /*
                当来到倒数第二个节点，cur.next为尾节点，那么在倒二次循环结束的时候
                就会把 cur.next（==null) 赋值给 cur 导致空指针异常，如果不是尾插
                就不会出现这种情况，因为 flag的原因，循环已经结束了，不会到尾节点
                while(cur.next != null && flag == 0){
                    if(cur.next.val == key ){
                        cur.next = cur.next.next;
                        flag = 1;
                    }
                    cur = cur.next;
                }*/
            }
        }

        //删除所有值为key的节点
        public void removeAllKey(int key){
            if(head == null) return; // 如果头节点为空
            Node prev = head;//前驱指向头节点
            Node cur = head.next;//当前节点指向头节点的下一个节点
            while (cur != null) {//因为通过 cur的位置来比较值
                if(cur.val == key) {//如果cur的位置的值是 Key
                    prev.next = cur.next;//prev 走两步
                    cur = cur.next;// cur 走一步
                }else {
                    prev = cur;// prev 走一步
                    cur = cur.next;// cur 走一步
                }
            }
            if(head.val == key) { // 因为 cur 跳过了头节点
                head = head.next;// 最后要单独再判断一下头节点
            }
        }

        // 存放（地址） - 断开（链接） - 重新（启航)
        public void clear() {
            if(this.head == null) return;
            Node cur = head;
            while(cur != null){
                // 把第二个节点的地址传入 curNex
                Node curNext = cur.next /* = node2 = new Node(2); */;
                // 把第一个节点指向第二个节点的 ”箭头“ 设置为 null
                // 但是 curNext 是通过 cur.next 这个桥梁（这个桥梁是必须的，因为不知道node2的地址)来存储 node2, 所以不会使 curNext 变为 null
                cur.next = null;
                cur = curNext;
            }
        }

}

