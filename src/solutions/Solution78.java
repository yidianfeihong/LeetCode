package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution78 {

    public static void main(String[] args) {
        System.out.println(new Solution78().subsets1(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }


    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }


    public void dfs(int[] nums, int cur, List<List<Integer>> res, List<Integer> list) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        dfs(nums, cur + 1, res, list);
        list.remove(list.size() - 1);
        dfs(nums, cur + 1, res, list);
    }


    /**
     * 循环枚举
     */
    public List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

}
