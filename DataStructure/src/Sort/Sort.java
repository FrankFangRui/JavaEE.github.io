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
        for(int i = 1; i < array.length ; i++){
            tmp = array[i];
            for(int)

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

    public static void shellSort(int[] array) {
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
    public static void selectSort(int[] array) {
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
    private static void swap(int[] array,int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
