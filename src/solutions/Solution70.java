package solutions;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution70 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new Solution70().climbStairs(i));
        }
    }


    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else {
            int[] nums = new int[n];
            nums[0] = 1;
            nums[1] = 2;
            for (int i = 2; i < n; i++) {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
            return nums[n - 1];
        }
    }
}
