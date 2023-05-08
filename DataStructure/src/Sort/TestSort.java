package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 方锐
 * @since 2023/5/5 10:28
 */
public class TestSort {
    public static void main(String[] args) {
        int[] array = new int[10_0000];
            initArrayOrder(array); // 有序
        //   initArrayNotOrder(array); // 无序
        testInsertSort(array);
        testShellSort(array);
        testSelectSort(array);
    }
    public static void testSelectSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long startTime = System.currentTimeMillis();
        Sort.selectSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("选择排序耗时： " + (endTime-startTime));
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
    public static void initArrayOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length-i;
        }
    }

    public static void initArrayNotOrder(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000_0000);
        }
    }
}
