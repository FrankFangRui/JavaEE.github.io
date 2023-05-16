package Sort;

/**
 * @author 方锐
 * @since 2023/5/14 21:31
 */
public class QuickSort {
    public static void main(String[] args) {
        int array[] = {2,1};
        // QuickSortHoare(array,0,array.length-1);
         QuickSortDigHole(array,0,array.length-1);
        //QuickSortTwoPointers(array,0,array.length-1);;
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    // Hoare 法 快排
    public static void QuickSortHoare(int[] array, int start, int end){
        if(start >= end) return;
        int pivot = partition(array,start,end);
        QuickSortHoare(array,pivot+1,end);
        QuickSortHoare(array,start,pivot-1);
    }
    public static int partition(int[] array, int start, int end){
        int i = start;
        int key = array[start];
        while(start < end){
            while(start < end && array[end] >= key){
                end--;
            }
            while(start < end && array[start] <= key){
                start++;
            }
            swap(array,end,start);
        }
        swap(array,i,start);
        return i;
    }
    public static void swap(int[] array,int a,int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    //

    // 挖坑法
    public static void QuickSortDigHole(int[] array, int start, int end){
        if(start >= end) return;
        int pivot = partition2(array,start,end);
        QuickSortDigHole(array,pivot+1,end);
        QuickSortDigHole(array,start,pivot-1);
    }

    public static int partition2(int[] array, int start, int end){
        int key = array[start];
        while(start < end){
            while(start < end && array[end] >= key){
                end--;
            }
            array[start] = array[end];
            while(start < end && array[start] <= key){
                start++;
            }
            array[end] = array[start];
        }
        array[start] = key;
        // 最开始的时候，array[0] 的元素被存到 key 当中，第一次end就将这个key给覆盖掉了（或者直接走到key位置）
        // 所以最后相遇的时候，要将相遇位置 的元素 赋值为 key
        return start;
    }

    // 前后指针法

    public static void QuickSortTwoPointers(int[] array, int start, int end){
        if(start >= end) return;
        int pivot = partition3(array,start,end);
        QuickSortTwoPointers(array,pivot+1,end);
        QuickSortTwoPointers(array,start,pivot-1);
    }
    public static int partition3(int[] array, int start, int end){
        int key = array[start];
        int prev = start;
        int cur = start + 1;
        while(cur <= end){
            if(array[cur] < key && array[++prev] != array[cur]){
                swap(array,prev,cur);
            }
            cur++;
        }
        swap(array,start,prev);
        return start;
    }
}
