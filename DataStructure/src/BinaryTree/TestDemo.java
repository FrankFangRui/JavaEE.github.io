package BinaryTree;

/**
 * @author 方锐
 * @since 2023/3/31 10:31
 */
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTree();
        System.out.println("前序遍历");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        System.out.println("中序遍历");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        System.out.println("后序遍历");
        binaryTree.postOrder(binaryTree.root);
    }
}
