package solutions;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 通过次数209,549提交次数456,112
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution16 {

    public static void main(String[] args) {
//        System.out.println(new Solution16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//        System.out.println(new Solution16().threeSumClosest(new int[]{0, 1, 2}, 3));
        System.out.println(new Solution16().threeSumClosest(new int[]{1, 1, 1, 0}, 0));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 10000;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(target - sum) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return best;
    }
}
