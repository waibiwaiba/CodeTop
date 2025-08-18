package main.java.com.leetcode.search.binary;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 在这里实现比较和移动指针的逻辑
            // 1. 如果 nums[mid] == target
            if (nums[mid] == target) {
                return mid;
            }
            // 2. 如果 nums[mid] < target
            if (nums[mid] < target) {
                left = mid + 1;
            } else {// 3. 如果 nums[mid] > target
                right = mid - 1;
            }
        }

        // 如果循环结束了还没找到，说明不存在
        return -1;
    }
}