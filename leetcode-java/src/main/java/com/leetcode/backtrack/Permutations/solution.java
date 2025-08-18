package main.java.com.leetcode.backtrack.Permutations;

import java.util.ArrayList;
import java.util.List;

// right
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         backtrack(result, new ArrayList<>(), nums);
//         return result;
//     }

//     private void backtrack(List<List<Integer>> result, List<Integer> currentPath, int[] nums) {
//         if (currentPath.size() == nums.length) {
//             result.add(new ArrayList<>(currentPath));
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             // 如果当前路径已包含这个数字，就跳过，去试下一个
//             if (currentPath.contains(nums[i])) {
//                 continue;
//             }
            
//             // 1. 做选择
//             currentPath.add(nums[i]);
            
//             // 2. 递归探索
//             backtrack(result, currentPath, nums);
            
//             // 3. 撤销选择 (回溯)
//             currentPath.remove(currentPath.size() - 1);
//         }
//     }
// }


// WRONG
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 启动回溯过程
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPath, int[] nums) {
        // 1. 思考结束条件：当路径长度等于数组长度时
        if (currentPath.size() == nums.length) {
            // 找到了一个完整的排列，把它加入结果列表
            // 注意：必须 new 一个新的列表，否则后续的回溯会修改它
            result.add(new ArrayList<>(currentPath));
            return;
        }

        // 2. 遍历“选择列表”（这里就是整个 nums 数组）
        for (int i = 0; i < nums.length; i++) {
            
            // --- 请在这里填充核心逻辑 ---
            
            // a. 如果当前数字 nums[i] 已经被用过了，就跳过
            if(currentPath.contains(nums[i])){
                break;
            }
            
            // b. 做选择：把 nums[i] 加入当前路径
            else{
                currentPath.add(nums[i]);
            }
            
            // c. 递归：继续向下探索
            backtrack(result, currentPath, nums);
            
            // d. 撤销选择（回溯）：把刚刚加入的 nums[i] 移除
            backtrack(result, currentPath.subList(0, currentPath.size()-1), nums);
            
        }
    }
}
