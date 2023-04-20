import java.util.Arrays;

/**
 * @author 方锐
 * @since 2023/4/20 9:35
 */
public class TestHeap {

    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    public void initArray(int[] array) {
        elem = Arrays.copyOf(array,array.length);
        usedSize = elem.length;
    }

    //建堆: 大根堆
    public void createHeap(){

    }
}
