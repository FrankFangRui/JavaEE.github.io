package PrimaryQueue;

import java.util.Arrays;

/**
 * @author 方锐
 * @since 2023/4/20 9:35
 */
public class TestHeap {


    // 堆的本质是一个数组
    public int[] elem;

    // usedSize 表示当前数组中有效元素的个数，即实际参与构建堆的元素数量。
    public int usedSize;

    // 初始化 堆 ：长度为 10 的数组，最开始数组中没有存入元素 userSize 为 0
    public TestHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    // 初始化一个数组，将传入的数组赋值给 elem, usedSize 是数组的长度
    // 复制这个传入的数组，并将数组扩容到原来数组长度的两倍
    public void initArray(int[] array) {
        elem = Arrays.copyOf(array, array.length);
        usedSize = elem.length;

    }

    //建堆: 大根堆
    public void createHeap() {
        // for 循环开始值为最后一个叶子节点的父节点
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            // 从最后一个叶子节点的父节点开始循环，直到根节点
            // 每次比较的都是三个节点 <----这句话是错误的
            // 每次比较都是比较 parent 节点和 其所有子节点
            // 为什么不是 比较它的两个 左右子节点就可以了呢？
            // 因为 parent 节点可能比它的左右子节点的一个或者两个都小，那么就不止和子节点交换位置了，还要继续和子节点的子节点来比较
            // 大小，来判断是不是还要进一步向下移动
            shiftDown(parent, usedSize);
        }
    }

    /**
     * 实现 向下调整，将父节点和子节点的值进行比较并交换
     *
     * @param parent 每棵子树的根节点的下标
     * @param len    每棵子树的结束位置
     */
    private void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
        // 当左孩子的下标没有超出数组的长度，说明左孩子存在
        // 用 while 循环因为会一直比较一个节点和它的所有子节点的大小，直到判断到叶子节点
        while (child < len) {

            // 比较左孩子和右孩子哪个值比较大，判断的前提是有右孩子，前面while循环只判断了 child 存在
            // 而不知道右孩子是否存在 ， 所以 if 中要加上 child+1 < len
            // child + 1 < len 不是 < usedSize 是因为usedSize是元素个数，不是存放元素的格子的数
            // 当 < len 就说明仍然有元素可以放置
            // 当 传入的 len 长度等于 usedSize 的时候，这里len为 usedSize不会出错
            // 像 堆排序中，传入的len不等于 usedSize 就会报错
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                // 此时保存了左右孩子节点中最大值的下标
                child++;
            }
            // 上述if判断了左孩子节点和右孩子节点哪一个大，且 child 位于大的孩子节点的下标位置
            // 接下来开始判断孩子节点和父亲节点哪一个比较大，如果孩子节点比较大，就进行交换
            if (elem[child] > elem[parent]) {
                // 交换父节点和子节点的值
                swap(elem, child, parent);
                /*在创建大根堆的过程中，需要更新子节点的索引是因为我们要确保整个子树都满足大根堆的性质。当父节点与子节点交换后，我们需要继续检查被交换下来的节点是否满足大根堆的性质。
考虑这样一个情况：当一个父节点的值小于其子节点的值时，我们需要将它们的值进行交换。然而，仅仅交换一次可能还不足以使整个子树满足大根堆的性质。这是因为在交换后，原来较小的父节点值被放置在子节点的位置，可能仍然小于它的新子节点。在这种情况下，我们需要继续进行交换操作，直到该节点满足大根堆的性质或者到达叶子节点。
为了实现这个过程，我们需要在每次交换后更新父子节点的索引。通过将父节点索引更新为刚刚交换的子节点索引，我们可以在下一次循环中检查新的子节点。同样，我们需要更新子节点的索引，以便在下一次循环中检查正确的子节点。
总之，更新子节点的索引是为了确保在创建大根堆时，整个子树都满足大根堆的性质。这样可以保证当一个节点的值被交换到子节点位置时，我们仍然能够正确地向下调整堆结构。*/
                // 将父节点的索引变成比它大的子节点的索引
                parent = child;
                // 将比父节点大的子节点的索引换成 子节点的左孩子节点的索引（此时parent等于child)
                // child = 2 * child + 1;
                child = 2 * parent + 1;
            } else {
                //父亲节点大于孩子节点，满足大根堆
                break;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    public void offer(int x) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, elem.length * 2);
        }
        this.elem[usedSize] = x;
        usedSize++;
        shiftUp(usedSize - 1);
    }

    private void shiftUp(int child) {
        // 当 child 不是复述，且比父节点大，就交换节点
        while (child > 0 && elem[child] > elem[(child - 1) / 2]) {
            swap(elem, child, (child - 1) / 2);
            child = (child - 1) / 2;
        }
    }

/*    private void shiftUp(int child) {
        // 通过子节点的下标，得到父节点的下标
        int parent = ( child-1 ) / 2;
        while(child > 0) {
            if(elem[child] > elem[parent]) {
                swap(elem,child,parent);
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }*/

    public boolean isFull() {
        return usedSize == elem.length;
    }

    // 出队
    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        int old = elem[0];
        swap(elem, 0, usedSize - 1);
        usedSize--;
        // 开始从 0 下标向下调整
        shiftDown(0, usedSize);
        return old;

    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public void heapSort() {
        // end 指向数组当中的最后一个元素
        int end = usedSize - 1;
        // 遍历大根堆中的每一个元素
        while (end > 0) {
            swap(elem,0,end);
            shiftDown(0,end);
            end--;
        }
    }
}


