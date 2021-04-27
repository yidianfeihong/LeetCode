package solutions;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * 如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
 * <p>
 * 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
 * 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
 * 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
 * 类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
 * <p>
 * depth("") = 0
 * depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
 * depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
 * depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
 * 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
 * <p>
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1614 {


    public static void main(String[] args) {
        System.out.println(new Solution1614().maxDepth("(1"));
        Map<Integer,Integer> map = new HashMap<>();
    }

    public int maxDepth(String s) {
        int max = 0, size = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                size++;
                max = Math.max(max, size);
            } else if (c == ')') {
                size--;
            }
        }
        return max;
    }

    public int calDepth(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    max = Math.max(max, stack.size());
                    stack.pop();
                } else {
                    return 0;
                }
            }
        }
        if (!stack.isEmpty()) {
            max = 0;
        }
        return max;
    }


}
