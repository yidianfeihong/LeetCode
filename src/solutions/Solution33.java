package solutions;

public class Solution33 {

    public static void main(String[] args) {
        System.out.println(new Solution33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1, right = nums[nums.length - 1];
        while (i <= j) {
            int mid = i + (j - i >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > right) {
                //大区间
                if (target < nums[mid] && target >= nums[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                //小区间
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}
