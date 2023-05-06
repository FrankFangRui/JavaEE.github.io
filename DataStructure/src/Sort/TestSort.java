package Sort;

/**
 * @author 方锐
 * @since 2023/5/5 10:28
 */
public class TestSort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = {6,5,4,3,2,1};
        sort.insertSort(array);
        for(int i = 0 ; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
