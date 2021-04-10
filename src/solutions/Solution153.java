package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution153 {


    public static void main(String[] args) {

        String[] strings = {"1", "2", "1"};
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("1");
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.remove("1");
        }

        for (String s : arrayList) {
            System.out.println(s);
        }

    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < min) {

            } else if (nums[mid] > min){

            }
        }
        return min;
    }

}
