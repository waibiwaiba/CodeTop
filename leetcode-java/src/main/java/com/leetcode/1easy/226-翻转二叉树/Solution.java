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
    /**
     * 翻转一棵二叉树。
     * @param root 二叉树的根节点
     * @return 翻转后二叉树的根节点
     */
    public TreeNode invertTree(TreeNode root) {
        // 步骤 1: 递归的终止条件
        // 如果当前节点是 null，说明已经没有节点可以翻转了，直接返回。
        if (root == null) {
            return null;
        }

        // 步骤 2: 核心操作 - 交换当前节点的左右子节点
        // 先用一个临时变量保存左子节点，防止被覆盖
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 步骤 3: 递归的递进
        // 对当前节点的左子树（已经是交换后的了）进行递归翻转
        invertTree(root.left);
        // 对当前节点的右子树（已经是交换后的了）进行递归翻转
        invertTree(root.right);

        // 步骤 4: 返回根节点
        // 每一层递归都返回当前处理的节点，最终返回的就是整棵树的根节点。
        return root;
    }
}