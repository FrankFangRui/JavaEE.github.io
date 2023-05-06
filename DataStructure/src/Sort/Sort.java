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

    public void insertSort(int[] array){
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

    public void swap(int[] array, int j, int m) {
        int tmp2 = array[m];
        array[m] = array[j];
        array[j] = tmp2;
    }
}
