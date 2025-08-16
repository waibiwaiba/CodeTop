package main.java.com.leetcode.tree.二叉树前序遍历;

import java.util.ArrayList;
import java.util.List;

// 二叉树节点的定义
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 我们需要一个辅助函数来进行递归
        preorderHelper(root, result);
        return result;
    }

    // 这是我们的递归辅助函数
    private void preorderHelper(TreeNode node, List<Integer> result) {
        // 1. 思考终止条件
        if (node == null) {
            // 应该做什么？
            return;
        }

        // 2. 思考递归逻辑 (根 -> 左 -> 右)
        // 处理 根 (当前节点)
        preorderHelper(node, result);//wrong, stackoverflow
        //the right answer
        result.add(node.val);             // 处理 根
        // 递归处理 左子树
        preorderHelper(node.left, result);
        // 递归处理 右子树
        preorderHelper(node.right, result);
    }
}
