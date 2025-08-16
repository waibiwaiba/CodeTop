class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 步骤 1: 处理边界情况
        // 如果数组为 null 或者数组为空，不存在公共前缀。
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 步骤 2: 初始化前缀
        // 我们假设第一个字符串就是最长的公共前缀。
        String prefix = strs[0];

        // 步骤 3: 遍历数组，从第二个字符串开始（索引为1）
        for (int i = 1; i < strs.length; i++) {
            
            // 步骤 4: 比较与缩短
            // String.indexOf(String str) 方法会查找 str 在当前字符串中第一次出现的位置。
            // 如果当前字符串 strs[i] 是以 prefix 开头的，那么 strs[i].indexOf(prefix) 的结果会是 0。
            // 如果结果不是 0，说明 strs[i] 并不以 prefix 开头，我们需要缩短 prefix。
            while (strs[i].indexOf(prefix) != 0) {
                // 使用 substring(0, length - 1) 方法来去掉 prefix 的最后一个字符。
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // 如果在缩短的过程中，prefix 变为空字符串了，
                // 说明没有找到任何公共前缀，可以直接返回。
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // 步骤 5: 返回结果
        // 循环结束后，prefix 就是所有字符串的最长公共前缀。
        return prefix;
    }
}