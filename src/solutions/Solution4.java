package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(new Solution4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        for (int num : nums1) {
            list.add(num);
        }
        for (int num : nums2) {
            list.add(num);
        }
        Collections.sort(list);
        int size = list.size();
        if ((size & 1) == 0) {
            return (double) (list.get((size - 1) / 2) + list.get((size - 1) / 2 + 1)) / 2;
        } else {
            return (double) list.get(list.size() / 2);
        }
    }

}
