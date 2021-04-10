package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Solution77 {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Solution77().combine(4, 3));
    }


    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || n < k) {
            return res;
        }
        ArrayList<Integer> output = new ArrayList<>();
        backTrack(n, k, 1, output);
        return res;
    }

    public void backTrack(int n, int k, int start, List<Integer> output) {
        if (output.size() == k) {
            res.add(new ArrayList<>(output));
            return;
        }
        int end = n - (k - output.size()) + 1;
        for (int i = start; i <= end; i++) {
            output.add(i);
            backTrack(n, k, i + 1, output);
            output.remove(output.size() - 1);
        }
    }
}
