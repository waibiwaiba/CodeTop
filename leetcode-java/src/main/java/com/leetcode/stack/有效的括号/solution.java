package 有效的括号;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // 使用 Stack<Character> 来存储左括号
        Stack<Character> stack = new Stack<>();

        // 使用 HashMap 存储括号的对应关系
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        // --- 请在这里开始填充你的代码 ---

        // 1. 遍历字符串中的所有字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 2. 判断 c 是左括号还是右括号
            if (map.containsValue(c)) {
                // 这是左括号，应该做什么？
                stack.push(c);
            } else {
                // 这是右括号，应该做什么？
                // (注意要处理栈为空的边界情况)
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        // 3. 遍历结束后，最终应该返回什么？

        return stack.isEmpty(); // 这是一个临时的返回值，你需要替换它
    }
}