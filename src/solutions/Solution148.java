package solutions;

import model.ListNode;
import util.DataUtils;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution148 {

    public static void main(String[] args) {
        ListNode node = DataUtils.generateListNode(new int[]{1, 3, 2});
        ListNode res = new Solution148().sortList(node);
        DataUtils.printListNode(res);
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }


    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return null;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        if (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode left = sortList(head, mid);
        ListNode right = sortList(mid, tail);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        ListNode p1 = left;
        ListNode p2 = right;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return dummyHead.next;
    }


}
