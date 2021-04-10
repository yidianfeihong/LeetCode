package solutions;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution125 {

    public static void main(String[] args) {
        System.out.println(new Solution125().isPalindrome(" "));
    }


    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i <= s.length() / 2 && j >= s.length() / 2) {
            while (i <= s.length() / 2 && !isCharOrNum(s.charAt(i))) {
                i++;
            }
            while (j >= s.length() / 2 && !isCharOrNum(s.charAt(j))) {
                j--;
            }
            if (i <= s.length() / 2 && j >= s.length() / 2) {
                if (!((s.charAt(i) + "").equalsIgnoreCase(s.charAt(j) + ""))) {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isCharOrNum(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}
