package Solutions;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution387 {
    public static void main(String[] args) {
        System.out.println(new Solution387().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        int[] nums = new int[128];
        for (char c : s.toCharArray()) {
            nums[c] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

}
