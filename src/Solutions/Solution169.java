package Solutions;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution169 {

    public static void main(String[] args) {

        System.out.println(new Solution169().majorityElement1(new int[]{6, 6, 5, 5, 6}));
    }

    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = nums[i];
                count = 1;
            }
        }
        return num;
    }
    public int majorityElement1(int[] nums) {
        int num = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count == 1) {
                num = nums[i];
            }
        }
        return num;
    }

}
