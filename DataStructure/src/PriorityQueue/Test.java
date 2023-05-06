package PriorityQueue;

import PriorityQueue.practical1.AgeComparator;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 方锐
 * @since 2023/4/29 21:23
 */
public class Test {
 /*   public int[] smallestK(int[] array,int k) {
        int[] ret = new int[k];
        if(k == 0) {
            return ret;
        }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0 ; i < array.length; i++) {
            if(maxPQ.size() < k){
                // 当 堆 中没有放满，直接加入元素
                maxPQ.offer(array[i]);
            } else {
                // 当放满了，获取到 小根堆 堆顶元素
                int top = maxPQ.peek();
                // 找前 k 个最小的
                // 如果要插入的元素比堆顶元素还小，就插入这个元素
                if(array[i] < top) {
                    maxPQ.poll();
                    maxPQ.offer(array[i]);
                }
            }
        }

        // 要前几个元素中最大的元素
        for (int i = 0 ;i < k ; i++) {
            int val = maxPQ.poll();
            System.out.println(val);
        }

    }*/
    public static void topK1(int[] array,int k) {
        PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0 ; i < array.length; i++) {
            MaxPQ.offer(array[i]);
        }

        // 要前几个元素中最大的元素
        for (int i = 0 ;i < k ; i++) {
            int val = MaxPQ.poll();
            System.out.println(val);
        }

    }

    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.initArray(array);

        testHeap.createHeap();

        testHeap.heapSort();

        System.out.println("d");
    }

    public static void main5(String[] args) {
        int[] array = {12,45,32,17,2,18,5,10};
        topK1(array,3);
    }
    public static void main4(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] array = {12,45,32,17,2,18,5,10};
        for ( int i = 0 ; i < array.length; i++) {
            priorityQueue.offer(array[i]);
        }
        // 将数组数据插入队列之后，自动通过比较器比较大小变成大根堆
        // System.out.println("..");
    }
    public static void main3(String[] args) {
        Student student = new Student(5);
        Student student1 = new Student(15);

    }
    public static void main2(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.initArray(array);

        testHeap.createHeap();

        testHeap.offer(80);

        //System.out.println("---");

        //testHeap.poll();

        PriorityQueue<Integer> priorityQueue2 =new PriorityQueue<>();
        AgeComparator ageComparator = new AgeComparator();
        PriorityQueue<Student> priorityQueue5 = new PriorityQueue<>(ageComparator);
        PriorityQueue<Student> priorityQueue4 = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });

/*        PriorityQueue<Student> priorityQueue3 = new PriorityQueue<>( (o1,o2)-> o1.age - o2.age );
        priorityQueue.offer(null);
        priorityQueue.offer(new Student(15));*/
    }
}
