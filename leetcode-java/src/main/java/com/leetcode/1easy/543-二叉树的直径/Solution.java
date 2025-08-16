/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // 用于记录全局的最大直径。
    // 我们把它定义为成员变量，这样在递归的各层调用中都可以访问和修改它。
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 从根节点开始进行深度优先搜索
        depth(root);
        // 递归结束后，maxDiameter 就保存了整个树的最大直径
        return maxDiameter;
    }

    /**
     * 这是一个辅助的递归函数，它的主要作用有两个：
     * 1. 计算以 `node` 为根的子树的最大深度（边数）。
     * 2. 在计算深度的过程中，顺便计算并更新以 `node` 为“拐点”的路径长度，
     * 并更新全局的 maxDiameter。
     * @param node 当前节点
     * @return 返回以 `node` 为根的子树的最大深度
     */
    private int depth(TreeNode node) {
        // 递归的终止条件：如果节点为空，那么深度为0。
        if (node == null) {
            return 0;
        }

        // 递归计算左子树的最大深度。
        // `leftDepth` 是从 node.left 到其最远叶子节点的边数。
        int leftDepth = depth(node.left);

        // 递归计算右子树的最大深度。
        // `rightDepth` 是从 node.right 到其最远叶子节点的边数。
        int rightDepth = depth(node.right);

        // *** 核心部分 ***
        // 经过当前 `node` 节点的最长路径长度 = 左子树深度 + 右子树深度。
        // 这就是一条潜在的“直径”，我们用它来更新全局的 maxDiameter。
        // 比如，对于 [4,2,1,3] 这条路径，当递归到节点 1 时，
        // leftDepth 会是 2 (路径 1->2->4 的长度),
        // rightDepth 会是 1 (路径 1->3 的长度),
        // 于是我们计算出一条长度为 2 + 1 = 3 的路径。
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // 这个函数的返回值是当前节点的深度。
        // 节点的深度 = 它的子树中较深的那个的深度 + 1
        // (加的这个 1 是当前节点到其子节点的这条边)。
        // 这个返回值会被上一层递归调用所使用。
        return Math.max(leftDepth, rightDepth) + 1;
    }
}