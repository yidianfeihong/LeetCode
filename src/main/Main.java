package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<List<Integer>> res;
    boolean[] mark;

    public static void main(String[] args) {
        List<List<Integer>> permute = new Main().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        mark = new boolean[nums.length];
        dps(nums, new ArrayList<>());
        return res;
    }


    public void dps(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!mark[i]) {
                list.add(nums[i]);
                mark[i] = true;
                dps(nums, list);
                mark[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}