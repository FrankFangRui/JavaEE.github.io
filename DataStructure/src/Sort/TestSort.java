package Sort;

import java.util.Arrays;
import java.util.Random;
/**
 * @author 方锐
 * @since 2023/5/5 10:28
 */
public class TestSort {
    public static void main(String[] args) {
        //int[] array = new int[10_0000];
        int[] array = {2,4,1,9};
          // initArrayOrder(array); // 正序
         //initArrayNotOrder(array); // 无序
        //逆序
        //initArrayInvertOrder(array);
        //testInsertSort(array);
        //testShellSort(array);
        //testSelectSort(array);
        //testHeapSort(array);
        //testBubbleSort(array);
        //testQuickSort(array);
        //Sort.heapSort2(array);
        //Sort.quickSort(array);
        Sort.test(array,0,array.length-1);
        /*for(int i = 0 ; i < array.length; i ++){
            System.out.println(array[i]);
        }*/
    }
    public static void testSelectSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时： " + (endTime-startTime));
    }
    public static void testBubbleSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.bubbleSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡排序耗时："+(endTime-startTime));
    }
    public static void testHeapSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.heapSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序耗时： " + (endTime-startTime));
    }
    public static void testInsertSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.insertSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序耗时："+(endTime-startTime));
    }

    public static void testShellSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.shellSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序耗时："+(endTime-startTime));
    }
    public static void testQuickSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.quickSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("快速排序耗时："+(endTime-startTime));
    }
    public static void initArrayOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static void initArrayNotOrder(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000_0000);
        }
    }

    public static void initArrayInvertOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length-i;
        }
    }
}
