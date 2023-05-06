package PriorityQueue.practical1;

/**
 * @author 方锐
 * @since 2023/5/2 20:34
 */
public class Test {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {2,3,4,5,6,7,8};
        testHeap.initArray(array);
        testHeap.createHeap();
        testHeap.offer(9);
        testHeap.poll();
        for(int i = 0 ; i < testHeap.usedSize ; i ++){
            System.out.println(testHeap.elem[i]);
        }

    }
}
