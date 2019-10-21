package Solutions;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution283().moveZeroes1(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        int count = 0;
        int p = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }
        int p0 = -1;
        int pp = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                p0 = i;
            } else {
                pp = i;
            }
            if (p0 >= 0 && pp >= 0 && p0 < pp) {
                nums[p0] = nums[pp];
                nums[pp] = 0;
                p0 = pp;
            }
        }


    }

    public void moveZeroes1(int[] nums) {

        for (int lastNonZeroIndex = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int temp = nums[cur];
                nums[cur] = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex] = temp;
                lastNonZeroIndex++;
            }
        }

    }


}
