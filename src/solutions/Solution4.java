package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(new Solution4().findMedianSortedArrays3(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
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

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        int m = 0, n = 0;
        for (int i = 0; i < temp.length; i++) {
            if (m == nums1.length) {
                if (n < nums2.length) {
                    temp[i] = nums2[n++];
                }
                continue;
            }
            if (n == nums2.length) {
                if (m < nums1.length) {
                    temp[i] = nums1[m++];
                }
                continue;
            }
            if (nums1[m] <= nums2[n]) {
                temp[i] = nums1[m++];
            } else {
                temp[i] = nums2[n++];
            }
        }
        int len = temp.length;
        if ((len & 1) == 0) {
            return (double) (temp[len / 2 - 1] + temp[len / 2]) / 2;
        } else {
            return (double) temp[len / 2];
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] newArr = new int[len1 + len2];
        while (i != len1 && j != len2) {
            if (nums1[i] <= nums2[j])
                newArr[k++] = nums1[i++];
            else
                newArr[k++] = nums2[j++];
        }
        while (i != len1)
            newArr[k++] = nums1[i++];
        while (j != len2)
            newArr[k++] = nums2[j++];
        return (newArr[newArr.length / 2] + newArr[(newArr.length - 1) / 2]) * 0.5;
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int m = 0, n = 0;
        int lNum = -1, rNum = -1;
        for (int i = 0; i <= len / 2; i++) {
            lNum = rNum;
            if (m < nums1.length && (n >= nums2.length || nums1[m] <= nums2[n])) {
                rNum = nums1[m++];
            } else {
                rNum = nums2[n++];
            }
        }
        if ((len & 1) == 1) {
            return rNum;
        } else {
            return (lNum + rNum) / 2.0;
        }
    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            if (totalLength % 2 == 1) {
                int midIndex = totalLength / 2;
                double median = getKthElement(nums1, nums2, midIndex + 1);
                return median;
            } else {
                int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
                double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
                return median;
            }
        }

        public int getKthElement(int[] nums1, int[] nums2, int k) {
            int length1 = nums1.length, length2 = nums2.length;
            int start1 = 0, start2 = 0;
            while (true) {
                // 边界情况
                if (start1 == length1) {
                    return nums2[start2 + k - 1];
                }
                if (start2 == length2) {
                    return nums1[start1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[start1], nums2[start2]);
                }
                // 正常情况
                int half = k / 2;
                int end1 = Math.min(start1 + half, length1) - 1;
                int end2 = Math.min(start2 + half, length2) - 1;
                int pivot1 = nums1[end1], pivot2 = nums2[end2];
                if (pivot1 <= pivot2) {
                    k -= (end1 - start1 + 1);
                    start1 = end1 + 1;
                } else {
                    k -= (end2 - start2 + 1);
                    start2 = end2 + 1;
                }
            }
        }
    }



}