import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 处理边界情况
        if (s == null || s.length() == 0) {
            return 0;
        }

        // map 用于存储字符及其最新出现的位置索引
        Map<Character, Integer> map = new HashMap<>();
        
        int maxLength = 0;
        // 使用 left 和 right 两个指针定义滑动窗口 [left, right]
        for (int left = 0, right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 检查当前字符是否在窗口内已经存在
            if (map.containsKey(currentChar)) {
                // 如果存在，说明遇到了重复字符。
                // 我们需要将窗口的左边界 left 移动到重复字符上一次出现位置的下一个位置。
                // 但同时要确保 left 指针不会向左回退。
                // 例如 s = "abba"，当 right 指向第二个 a 时，map.get('a') 是 0，
                // 但此时 left 已经是 2 了，我们不能让 left 变回 1。
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // 无论如何，都要更新当前字符的最新位置
            map.put(currentChar, right);

            // 计算当前窗口的长度，并更新最大长度记录
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}