package main.java.com.leetcode.dp.climbStairs;
// 更好
// class Solution {
//     public int climbStairs(int n) {
//         // 处理 n=1, n=2 的基础情况
//         if (n <= 2) {
//             return n;
//         }

//         // 初始化前两个状态
//         int prev2 = 1; // 代表 f(1)
//         int prev1 = 2; // 代表 f(2)

//         // 从第3阶开始循环计算
//         for (int i = 3; i <= n; i++) {
//             // 计算当前状态 f(i)
//             int current = prev1 + prev2;
            
//             // "滚动"更新状态，为下一次计算做准备
//             prev2 = prev1;
//             prev1 = current;
//         }

//         // 最终结果存储在 prev1 中
//         return prev1;
//     }
// }

public class Solution {
    public int climbStairs(int n) {
        // 1. 处理边界情况 (比如 n=1)
        if (n <= 1) {
            return 1;
        }

        // 2. 创建 dp 数组来“记忆”结果
        // 数组大小应该是多少？
        int[] dp = new int[n + 1];

        // 3. 设置初始值 (Base Cases)
        dp[1] = 1;
        dp[2] = 2;

        // 4. 使用循环，根据状态转移方程填充剩下的 dp 数组
        for (int i = 3; i <= n; i++) {
            // 在这里写下状态转移方程
            dp[n] = dp[n-1] + dp[n-2];
        }

        // 5. 最终的结果存在哪里？
        return dp[n];
    }
}