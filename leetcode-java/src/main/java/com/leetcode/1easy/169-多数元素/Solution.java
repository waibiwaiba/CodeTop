class Solution {
    /**
     * 查找数组中的多数元素。
     * @param nums 整数数组
     * @return 多数元素
     */
    public int majorityElement(int[] nums) {
        // Boyer-Moore 投票算法
        
        // 初始化候选人 candidate 和计数器 count
        int candidate = 0;
        int count = 0;

        // 遍历数组
        for (int num : nums) {
            // 如果 count 为 0，表示之前的候选人已经被“消耗完”
            // 我们需要选择当前的元素作为新的候选人
            if (count == 0) {
                candidate = num;
            }

            // 判断当前元素是否与候选人相同
            // 如果相同，计数器加 1
            // 如果不同，计数器减 1
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // 因为题目保证了多数元素总是存在，
        // 所以当遍历结束后，candidate 中存储的一定是那个多数元素。
        return candidate;
    }
}