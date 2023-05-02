package PrimaryQueue.practical1;

import java.util.Arrays;

/**
 * @author 方锐
 * @since 2023/5/2 20:28
 */
public class TestHeap {

    // 初始化堆的属性
    public int[] elem;
    public int usedSize;
    public TestHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    // 初始化一个数组
    public void initArray(int[] array) {
        elem = Arrays.copyOf(array,array.length);
        usedSize = elem.length;
    }

    // 创建一个大根堆
    public void createHeap() {
        // 从最后一个节点（数组元素）的父节点开始
        for(int parent = (usedSize-1)/2 ; parent >= 0 ; parent--) {
            shiftDown(parent,usedSize);
        }
    }
    private void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
        // 当子节点仍然在 数组 的长度内
        while(child < len) {
            if(child + 1 < usedSize && elem[child + 1] > elem[child]) {
                // 当右子节点在范围内且比左节点大，那就和右节点作比较，不然和左节点作比较
                child++;
            }
            if(elem[child] > elem[parent]) {
                swap(elem, parent, child);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
                // 当出现父节点比左右两个节点都大的时候,while循环可以截止了，因为 parent 为根的堆，已经是大根堆了
                // 即所有子节点都比parent所在的节点的值小

            }
        }
    }
    private void swap(int[] elem, int parent, int child) {
        int tmp = elem[parent];
        elem[parent] = elem[child];
        elem[child] = tmp;
    }

    public void offer(int x) {
        if (isFull()) {
            // 如果满了，就扩容
            elem = Arrays.copyOf(elem,elem.length*2);
        }
        this.elem[usedSize] = x;
        usedSize++;
        // 当把元素插入到了数组最后一个元素的时候，如果它比父节点大，就要向上移动
        shiftUp(usedSize-1);
    }

    private void shiftUp(int child) {
        // 当 child 不是复述，且比父节点大，就交换节点
        while(child > 0 && elem[child] > elem[(child-1)/2]) {
            swap(elem,child,(child-1)/2);
            child = (child-1)/2;
        }
    }
    private boolean isFull() {
        return usedSize == elem.length;
    }

    // 弹出元素
    public int poll() {
        if(isEmpty()) return -1;
        int old = elem[0];
        // 弹出元素，是弹出 数组的第一个元素，
        // 为了将弹出元素之后的 二叉树，仍然是一个大根堆，就直接把最后一个元素，和第一个元素交换，然后向下调整这个元素
        swap(elem,0,usedSize-1);
        usedSize--;
        shiftDown(0,usedSize);
        return old;
    }

    private boolean isEmpty() {
        return usedSize == 0;
    }
}
