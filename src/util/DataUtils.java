package util;

import model.ListNode;
import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DataUtils {

    public static void printListNode(ListNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        System.out.println(list);
    }


    public static ListNode generateListNode(int[] num) {

        if (num == null) {
            return null;
        }

        ListNode root = new ListNode(-1);
        ListNode p = root;
        for (int i = 0; i < num.length; i++) {
            p.next = new ListNode(num[i]);
            p = p.next;
        }
        return root.next;
    }

    public static void BstPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue != null) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                System.out.println(node.val + "\t");
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
