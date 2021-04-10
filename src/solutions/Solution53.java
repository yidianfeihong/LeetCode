package solutions;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution53 {

    public static void main(String[] args) {
        System.out.println(new Solution53().maxSubArray(new int[]{2, 1, -8, 2, 3}));
//        System.out.println(new Solution53().maxSubArray(new int[]{-1, -2}));
    }


    public int max(int[] nums) {
        int maxValue = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curr < 0) {
                curr = nums[i];
            } else {
                curr += nums[i];
            }
            if (curr > maxValue) {
                maxValue = curr;
            }

        }
        return maxValue;
    }


    public int maxSubArray(int[] nums) {
        int start = 0, end = 0;

        int currSum = nums[0];
        int max = currSum;
        for (int i = 1; i < nums.length; i++) {
            if (currSum < 0) {
                currSum = nums[i];
                start = i;
            } else {
                currSum += nums[i];
            }
            if (currSum > max) {
                max = currSum;
                end = i;
            }
        }
        System.out.println("start:" + start);
        System.out.println("end:" + end);
        return max;
    }


    public int maxSum(int[] nums) {
        int currentSum = nums[0];
        int max = currentSum;
        for (int i = 1; i < nums.length; i++) {
            if (currentSum <= 0) {
                if (nums[i] > currentSum) {
                    currentSum = nums[i];
                }
            } else {
                if (nums[i] > 0) {
                    currentSum += nums[i];
                } else if (currentSum + nums[i] > 0) {
                    currentSum += nums[i];
                }
            }
        }
        return currentSum;
    }
}
