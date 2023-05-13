package Sort;

/**
 * @author 方锐
 * @since 2023/5/5 10:28
 */
public class Sort {
    /**
     *  直接插入排序
     * @param array
     */
    public void insertSort2(int[] array) {

        for(int i = 1; i < array.length; i++) { // 每循环一次，前 i 个数已经拍好序
            // 将这个数和之前的数比较
            // 一次外层递归本质上只比较一个数字，只将一个数组整理完毕
            int tmp = array[i];
            int j ;
            for(j = i - 1; j >= 0; j--) {
                if(array[j] > tmp){
                    array[j+1] = array[j];
                } else {
                    break;
                    // 当发现数组左边排好序的数，有一个比array[i]小的时候，说明前 i 个数已经排好了
                }
            }

            array[j+1] = tmp; // 全部移动完 才放入元素
        }
    }

    public void insertSort3(int[] array){
        int i,j,tmp;
        for(i = 1; i < array.length; i++) {
            tmp = array[i];
            for(j = i - 1; j >= 0; j-- ) {
                if(tmp < array[j]){
                    array[j+1] = array[j];
                    array[j] = tmp; // 这样子是移动一次就放入一次
                }else{
                    break;
                }
            }
        }
    }

    public static void insertSort4(int[] array) {
        int i, j, tmp;
        for( i = 1; i < array.length; i++) {
            tmp = array[i];
            for( j = i - 1; j >= 0; j--) {
                if(tmp < array[j]){
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            // 当 j-- 完了之后，j 不符合 >= 0, j == -1
            // 当内层 for 循环结束的时候，j的位置是比j+1来的小的，才会进入到 break;结束循环
            array[j+1] = tmp;
        }
    }

    public static void insertSort5(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for(;j >= 0;j--) {
                //加上等号 就是不稳定
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void insertSort(int[] array) {
        int i,j,tmp;
        for(i = 1; i < array.length ; i++){
            tmp = array[i];
            for( j = i - 1; j >= 0 ; j--){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    private static void shell(int[] array, int gap) {
        int i,j,tmp;
        for(i = gap; i < array.length; i++) {
            tmp = array[i];
            for(j = i - gap; j >= 0; j-=gap ) {
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static void shellSort2(int[] array) {
        int[] drr = {5,2,1};
        for (int i = 0 ;i < drr.length;i++) {

        }
    }

    public static void shellSort3(int[] array) {
        int gap = array.length / 2; //初始增量为数组长度的一半
        while (gap > 0) { //当增量大于0时，进行分组排序
            for (int i = gap; i < array.length; i++) { //对每个分组进行直接插入排序
                int temp = array[i]; //保存当前元素
//               int j = i; //记录当前元素的位置
//                while (j >= gap && array[j - gap] > temp) { //如果前一个元素大于当前元素，就交换位置
//                    array[j] = array[j - gap];
//                    j -= gap;
//                }
                int j;
                for(j = i - gap;j >= 0;j -= gap){
                    if(array[j] > temp){
                        array[j+gap] = array[j];
                    }else{
                        break;
                    }
                }
                array[j+=gap] = temp; //将当前元素插入到正确的位置
            }
            gap /= 2; //缩小增量
        }
    }
    public static void shellSort(int[] array){
        int gap = array.length/2;
        while (gap > 0) {
            for(int i = gap ; i < array.length ; i++){
                int tmp = array[i];
                int j;
                for(j = i - gap ; j >= 0 ; j-= gap){
                    if(array[j] < tmp){
                        array[j+gap] = array[j];
                    }else {
                        break;
                    }
                }
                array[j+gap] = tmp;
            }
            gap/=2;
        }

    }
    public static void selectSort3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //每次将i下标的 值 当做是 最小值
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array,minIndex,i);
        }
    }

    public static void selectSort(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            int j;
            int minIndex = i;
            for(j = i + 1 ; j < array.length ; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    public static void selectSort2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int minIndex = left;
            int maxIndex = left;
            // 一次记录两个下标
            for (int i = left + 1; i <= right ; i++) {//从第二个开始比较
                if(array[i] < array[minIndex]){
                    minIndex = i;
                }
                if(array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(array,left,minIndex);
            // 如果当 left 是 maxIndex 下标的时候，就会出错
            if(left == maxIndex) {
                maxIndex = minIndex;
            }
            swap(array,right,maxIndex);
            left++;
            right--;
        }
    }
    private static void swap(int[] array,int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void heapSort(int[] array) {
        //创建大根堆
        createBigHeap(array);
        int end = array.length - 1;
        // 创建了大根堆之后，从上到下按照降序，但是同层的顺序无法保证
        while (end >= 0 ) { //
            swap(array,0,end);// 把最大的移到最后一个

            end--;

            shiftDown(array,0,end);// 开始寻找第二大，将第二大的移动到堆顶
            // 从尾巴开始排列，每排列好一个 end--,end下标往回开始逐渐降序

        }
    }

    private static void createBigHeap(int[] array) {
        for (int parent = (array.length-1-1)/2; parent >= 0 ; parent--){
            shiftDown(array,parent,array.length);
        }
    }
    private static void shiftDown(int[] array, int parent, int len){
        int child = 2 * parent + 1;
        while(child < len){
            if(child + 1 < len && array[child] < array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                swap(array,child,parent);
                parent = child;
                child = 2 * parent + 1;
            }else{
                break;
            }
        }
    }

    public static void bubbleSort(int[] array){
        for(int i = 0 ; i < array.length-1; i++){
            for(int j = 0 ; j < array.length - 1 -i; j++){
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }


    public static void bubbleSort2(int[] array) {
        for(int i = 0 ; i < array.length-1; i++){ // 十个数据 九次for循环，十个数据九个gap
            for(int j = 0 ; j < array.length-1-i ; j++){// 每走一次外层for循环，内层就可以少走一次
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }

    public static void heapSort2(int[] array){
        createBigHeap(array);
        int end = array.length - 1;
        while(end >= 0) {
            swap(array,0,end);

            end--;

            shiftDown2(array,0,end);



        }
    }

    private static void createBigHeap2(int[] array) {
        for(int parent = (array.length-1)/2; parent >= 0 ; parent--){
            shiftDown2(array,parent,array.length);
        }
    }

    // 把小的数往下移动
    private static void shiftDown2(int[] array, int parent, int len) {
        int child = 2 * parent + 1;
        while(child < len){
            if(child + 1 < len && array[child+1] > array[child]){
                child++;
            }
            if(array[child] > array[parent]){
                swap(array,child,parent);
                parent = child;
                child = 2 * parent + 1;
            }
        }
    }
    // 找到 pivot
    private static int partition4(int[] array,int start,int end){
        int i = start; // 事先存储好 start 下标
        int key = array[start]; // 存储好数组最左边的 key
        while(start < end) {
            // 不取等号会死循环
            // 当碰到end碰到一个 key,start也碰到一个key(两个key位置不同）
            // 然后就会交换这两个key，而start<end,一直相互交换，导致死循环
            while ( start < end && array[end] >= key){
                end--;
            }
            while ( start < end && array[start] <= key) {
                start++;
            }
            swap(array,start,end);
        }
        // 当 start = end 的时候
        // 将相交位置和最左边的key交换位置
        swap(array,start,i);
        return start;
    }

    private static void quick(int[] array,int left,int right) {
        // = 就够了，能判断left,right重合，为什么还要 > 呢？
        // 当pivot，left重合的时候，即基准就是left，
        // quick(array,left,pivot-1); -> quick(array,left,left-1); 通过 > 来限制错误
        if(left >= right) return; // 当只有一个节点的时候，结束循环

        int pivot = partition(array,left,right);
        quick(array,left,pivot-1);
        quick(array,pivot+1,right);
    }

    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
    }

    private static int partition(int[] array,int start, int end){
        int prev = start;
        int cur = start+1;
        while(cur <= end){
            // 当 cur 位置的元素大于基准值的时候，if语句中&&短路与将不会执行后面的++prev
            // 即 cur 大于基准值时，只有 cur 移动， prev 不移动
            if(array[cur] < array[start] && array[++prev]!=array[cur]){
                // 走到这里说明 cur,prev之间至少间隔一个比基准大的元素，且cur现在位置的值比基准大
                /*() 内，只有当 cur 小于 基准 的时候，才能 prev++，当碰到一个 比基准大的元素之后，
                  prev 和 cur 之间的间隔元素数量就是数组中比基准大的元素数量（且只会再增大不会减小了）
                */
                // 只有当 cur 的值小于基准 且 prev 和 cur 不是相邻元素的时候，才能进入if

                /*第一次碰到一个比基准小的元素的时候，不会进入if，之后碰到都会进入if(因为&&右边的一定会是 true)
                  碰到的时候,先让 prev++ 使prev位于比基准大的哪些数，然后将cur位置（那个碰到的比基准小的数）
                  和prev这个数交换,交换完毕之后，cur继续向前走，此时prev位置的数还是小于基准值
                */

                swap(array,cur,prev);
            }
            cur++;
        }
        // 当走完一遍数组之后，将prev的位置（小于基准的值）和基准进行交换
        // 为什么走完数组之后，prev位置的值小于基准？
        // 其实只有在 array[++prev]!=array[cur] 到 swap(array,cur,prev)这两个代码之间会出现 prev 位置是大于基准的情况，
        // 一旦prev大于基准，就会和 cur 进行交换（只有当cur碰到小于基准的值的时候，才会让prev右移处于大于基准的数，然后交换）
        // 交换完毕之后，prev立马又变成小于基准值了
        swap(array,prev,start);
        return start;
    }


//挖坑法
    private static int partition5(int[] array,int start,int end){
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
        // 相遇位置放 key
        array[start] = key;
        return start;
    }



    private static int partition2(int[] array,int start,int end){
        int i = start; // 事先存储好 start 下标
        int key = array[start]; // 存储好数组最左边的 key
        while(start < end) {
            // 不取等号会死循环
            // 当碰到end碰到一个 key,start也碰到一个key(两个key位置不同）
            // 然后就会交换这两个key，而start<end,一直相互交换，导致死循环
            while ( start < end && array[end] > key){
                end--;
            }
            if (start < end) array[start++] = array[end]; // 这里移动了 start
            while ( start < end && array[start] < key) {
                start++;
            }
            if (start < end) array[end--] = array[start]; // 这里移动了 end
        }
        // 当 start = end 的时候
        // 将相交位置和最左边的key交换位置
        array[start] = key;
        return start;
    }


    public static void quickSort2(int[] array,int left, int right){
        if(left >= right){
            return;
        }
        int pivot = partition3(array, left, right);
        quickSort2(array,pivot+1,right);
        quickSort2(array,left,pivot-1);
    }
    private static int partition3(int[] array, int start, int end){
        int keyIndex = start;
        int key = array[start];
        while(start < end){
            while(start < end && array[end] >= key){
                end--;
            }
            while(start < end && array[start] <= key){
                start++;
            }
            swap(array,start,end);
        }
        swap(array,keyIndex,start);
        return start;// 返回 pivot 位置
    }

}
