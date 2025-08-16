package main.java.com.leetcode.tree.对称二叉树;

// 二叉树节点的定义
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 1. 处理根节点为空的特殊情况
        if(root == null){
            return true;
        }
        // 2. 调用辅助函数开始真正的比较
        return isMirror(root.left, root.right);
    }

    // 这是一个私有的辅助函数，用来执行递归
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        // 在这里实现我们刚才总结的三步逻辑
        // 1. 两个都为 null 的情况
        if(node1==null && node2==null){
            return true;
        }
        // 2. 一个为 null 或者值不等的情况
        if((node1==null)&&(node2!=null)||(node1!=null)&&(node2==null)||node1.val!=node2.val){
            return false;
        }
        // 3. 递归比较子节点的情况
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}

// BETTER
// private boolean isMirror(TreeNode node1, TreeNode node2) {
//     // 如果两个节点都为空，那么它们是镜像对称的
//     if (node1 == null && node2 == null) {
//         return true;
//     }

//     // 如果只有一个节点为空，或者两个节点的值不相等，
//     // 那么它们肯定不是镜像对称的
//     if (node1 == null || node2 == null || node1.val != node2.val) {
//         return false;
//     }

//     // 递归地“交叉”检查它们的子树是否也互为镜像
//     return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
// }