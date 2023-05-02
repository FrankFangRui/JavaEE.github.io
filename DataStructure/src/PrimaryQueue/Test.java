package PrimaryQueue;

import java.util.PriorityQueue;

/**
 * @author 方锐
 * @since 2023/4/29 21:23
 */
public class Test {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.initArray(array);

        testHeap.createHeap();

        testHeap.offer(80);

        //System.out.println("---");

        //testHeap.poll();

        PriorityQueue<Integer> priorityQueue2 =new PriorityQueue<>();
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(null);
        priorityQueue.offer(new Student());
    }
}
