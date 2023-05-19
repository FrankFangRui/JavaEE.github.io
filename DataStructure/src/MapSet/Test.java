package MapSet;

/**
 * @author 方锐
 * @since 2023/5/17 16:48
 */
public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {80,30,48,60,90,56};
        for(int i = 0; i < array.length; i++) {
            binarySearchTree.insert(array[i]);
        }
        System.out.println("------");
    }
}
