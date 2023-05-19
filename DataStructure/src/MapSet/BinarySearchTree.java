package MapSet;

/**
 * @author 方锐
 * @since 2023/5/17 15:27
 */
public class BinarySearchTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    /**
     * 查找二叉搜索树中是否存在key节点，存在则返回TreeNode
     * @param key
     * @return
     */
    public TreeNode search(int key) {
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val < key) {
                cur = cur.right;
            } else if(cur.val > key) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }
    public boolean insert(int key) {
        // 创建要插入的 节点
        TreeNode node = new TreeNode(key);
        // 判断当前 二叉搜索树 是否为空
        if(root == null) {
            root = node;
            return true;
        }

        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null) {
            // 当比较完一个节点之后，就往它的左/右子树走
            if(cur.val < key) {
                // 当前 cur 位置的值小于 key， parent记录下cur，cur向右树移动，寻找比cur大的值
                parent = cur;
                cur = cur.right;
            }else if(cur.val > key) {
                // 当前 cur 位置的值大于 key， parent记录下cur，cur想做移动，寻找比cur小的值
                parent = cur;
                cur = cur.left;
            }else {
                // 当发现有一个cur.val = key，说明要插入的key已经存在（这种情况不合法），返回 false
                return false;
            }
        }
        // 当走到这里说明 cur == null
        // 即已经走到了 叶子节点 位置
        // 注意将 二叉搜索树 中序遍历一定是正序的
        // cur 为 null，但是不知道走到的是parent节点的左节点还是右节点导致 cur 为 null 所以要判断一下
        // parent值小于key，则放入右节点；大于key，则放入左节点
        if(parent.val < key) {
            parent.right = node;
        }else {
            parent.left = node;
        }
        return true;
    }

    public void remove(int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null) {
            if(cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else if(cur.val > key) {
                parent = cur;
                cur = cur.left;
            }else {
                // 找到key，开始准备删除，因为要分很多种情况所以单独创造一个函数
                removeNode(cur,parent);
            }
        }
    }

    /**
     * 进行删除
     * @param cur
     * @param parent
     */
    private void removeNode(TreeNode cur, TreeNode parent) {
    }
}
