package Test;

import model.ListNode;

import java.util.HashMap;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 5, 6, 7, 0, 0, 0, 0};
        int[] b = new int[]{1, 2, 3};
        new Test().est();

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[k] = nums1[i--];
                } else {
                    nums1[k] = nums2[j--];
                }
            } else if (i >= 0) {
                nums1[k] = nums1[i--];
            } else if (j >= 0) {
                nums1[k] = nums2[j--];
            } else {
                break;
            }
        }
    }


    public void est() {

        Random random = new Random();
        int i = random.nextInt(10) + 1;
        System.out.println(i);

    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = pHead2;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = pHead1;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }


}
