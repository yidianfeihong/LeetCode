package solutions;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution7 {

    public static void main(String[] args) {

        System.out.println(new Solution7().reverse(1534236469));
    }


    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            int n = x % 10;
            x = x / 10;
            ans = ans * 10 + n;
            if (ans > Math.pow(2, 31) - 1 || ans < -Math.pow(2, 31)) {
                return 0;
            }

        }
        return (int) ans;
    }
}