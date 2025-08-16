package main.java.com.leetcode.tree.二叉树层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树节点的定义 (和之前一样)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 最终要返回的结果列表
        List<List<Integer>> result = new ArrayList<>();
        // 处理边界情况：如果根节点为空，直接返回空列表
        if (root == null) {
            return result;
        }

        // 创建一个队列，并把根节点加进去
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 当队列不为空时，持续循环
        while (!queue.isEmpty()) {
            // 记录当前层的节点数量
            int levelSize = queue.size();
            // 创建一个列表，用来存放当前这一层的所有节点值
            List<Integer> currentLevel = new ArrayList<>();

            // 循环 levelSize 次，正好处理完当前这一整层的节点
            for (int i = 0; i < levelSize; i++) {
                
                // --- 请在这里填充核心逻辑 ---
                
                // 1. 从队列中取出一个节点 (出队)
                TreeNode element = queue.poll();
                
                // 2. 将这个节点的值，加入到 currentLevel 列表中
                currentLevel.add(element.val);
                
                // 3. 如果这个节点的左子节点不为空，把它加入队列 (入队)
                if(element.left!=null){
                    queue.offer(element.left);
                }
                
                // 4. 如果这个节点的右子节点不为空，把它加入队列 (入队)
                if(element.right!=null){
                    queue.offer(element.right);
                }                
                
            }
            // for 循环结束后，当前层的所有节点都已经处理完毕
            // 把存储着当前层节点值的列表 currentLevel 加入到最终结果中
            result.add(currentLevel);
        }

        return result;
    }
}
