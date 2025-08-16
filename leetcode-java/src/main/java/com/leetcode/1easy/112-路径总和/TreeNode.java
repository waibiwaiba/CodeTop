
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /**
     * 判断是否存在一条从根到叶子的路径，其节点值之和等于 targetSum。
     * @param root      二叉树的根节点
     * @param targetSum 目标和
     * @return 如果存在则返回 true，否则返回 false
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 步骤 1.1: 基准情况 - 遇到空节点
        // 如果树是空的，那不可能有任何路径。
        if (root == null) {
            return false;
        }

        // 步骤 1.2: 基准情况 - 遇到叶子节点
        // 如果当前节点是叶子节点（没有左孩子也没有右孩子）
        if (root.left == null && root.right == null) {
            // 我们检查，目标和减去当前节点值后是否为 0。
            // 另一种写法是： return targetSum == root.val;
            return (targetSum - root.val) == 0;
        }

        // 步骤 2: 递归递进
        // 如果不是叶子节点，我们就继续向左子树和右子树探索。
        // 我们需要寻找的路径和，就变成了 targetSum 减去当前节点的值。
        // 只要左子树 `OR` 右子树中任何一个能找到满足条件的路径，结果就是 true。
        boolean leftResult = hasPathSum(root.left, targetSum - root.val);
        boolean rightResult = hasPathSum(root.right, targetSum - root.val);
        
        return leftResult || rightResult;
    }
}