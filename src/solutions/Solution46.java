package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution46 {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] mark;

    public static void main(String[] args) {

        List<List<Integer>> res = new Solution46().permute(new int[]{1, 2, 3});
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        mark = new boolean[nums.length];
        backTrack(nums, 0, list);
        return res;
    }


    public void backTrack(int[] nums, int index, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!mark[i]) {
                list.add(nums[i]);
                mark[i] = true;
                backTrack(nums, index + 1, list);
                list.remove(list.size() - 1);
                mark[i] = false;
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backTrac2k(nums.length, res, output, 0);
        return res;
    }

    public void backTrac2k(int n, List<List<Integer>> res, List<Integer> output, int index) {
        if (index == n) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = index; i < n; i++) {
            Collections.swap(output, i, index);
            backTrac2k(n, res, output, index + 1);
            Collections.swap(output, i, index);
        }
    }

}
