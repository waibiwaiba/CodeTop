package main.java.com.leetcode.greedy.cookiesForKids;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 第 1 步：先对两个数组进行升序排序，这步我忘了 XD
        Arrays.sort(g);
        Arrays.sort(s);
        // 在这里实现我们刚刚总结的算法
        int i = 0, j = 0, count = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
