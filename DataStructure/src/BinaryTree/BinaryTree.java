package BinaryTree;

import java.util.Stack;

/**
 * @author 方锐
 * @since 2023/3/31 10:25
 */
public class BinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val){
            this.val = val;
        }
    }
    //二叉树的根节点
    public TreeNode root;

    public void createTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        this.root = A;
    }
    //前序遍历
    void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val +" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历
    void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val +" ");
        inOrder(root.right);
    }
    //后序遍历
    void postOrder(TreeNode root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val +" ");
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 左边为空，右边不会空 或者 左边不为空，右边为空
        if(p == null && q != null || p != null && q == null) {
            return false;
        }
        // 两边都为空
        if(q == null && p == null){
            return true;
        }
        // 两边都不为空
        if(p.val != q.val){
            return false;
        }
        // 代码走到这里说明
        // p != null && q != null && p.val == q.val
        // 即 p,q 是相同非空节点

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }

    /**
     * 找到根节点和指定节点之间的路径，放入栈当中
     * @param root
     * @param node
     * @param stack
     */
    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p, TreeNode q){
        if(root == null || p == null || q == null){
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        getPath(root,p,stack1);
        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root,q,stack2);

        int size1 = stack1.size();
        int size2 = stack2.size();

        if(size1 > size2) {
            int tmp = size1 - size2;
            while(tmp != 0) {
                stack1.pop();
                tmp--;
            }
        } else {
            int tmp = size2 - size1;
            while (tmp != 0) {
                stack2.pop();
                tmp--;
            }
        }
        // 两个栈当中，现在元素个数是一样的
        while (!stack1.empty() && !stack2.empty()){
            if(stack1.peek() == stack2.peek()) {
                return stack1.peek();
            } else {
                stack1.pop();
                stack2.pop();
            }
        }
        // 走到这里还没有返回，说明没有公共祖先
        return null;
    }
    private boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack){
        if(root == null || node == null) {
            return false;
        }
        stack.push(root);
        if(root == node) {
            return true;
        }
        boolean ret1 = getPath(root.left,node,stack);
        //不能判断false的问题，因为此时只能证明左边不存在
        if(ret1) {
            return true;
        }
        boolean ret2 = getPath(root.right,node,stack);
        if(ret2) {
            return true;
        }
        // 根节点不是要找的节点，根左边没找到，右边也没找到
        // 把root弹出去
        stack.pop();
        return false;
    }
}
