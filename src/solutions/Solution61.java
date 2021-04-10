package solutions;

import model.ListNode;
import util.DataUtils;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class Solution61 {

    public static void main(String[] args) {
        ListNode node = DataUtils.generateListNode(new int[]{1, 2, 3, 4, 5});
        ListNode rs = new Solution61().rotateRight(node, 2);
        DataUtils.printListNode(rs);
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        int position = len - k % len;
        if (position == len) {
            return head;
        }
        cur.next = head;
        while (position-- > 0) {
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }

}
