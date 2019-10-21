package Solutions;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));


    }


    public int lengthOfLongestSubstring(String s) {

        int[] index = new int[128];
        int len = s.length();
        int ans = 0;
        for (int l = 0, r = 0; r < len; r++) {
            char c = s.charAt(r);
            if (index[c] > 0) {
                l = Math.max(l, index[c]);
            }
            ans = Math.max(ans, r - l + 1);
            index[c] = r + 1;
        }
        return ans;

    }
}
