package solutions;

import model.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？
 */
public class Solution142 {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
//        ListNode second = new ListNode(2);
//        ListNode third = new ListNode(3);
//        ListNode four = new ListNode(4);
//        first.next = second;
//        second.next = third;
//        third.next = four;
//        four.next = second;
        ListNode listNode = new Solution142().detectCycle(first);
        System.out.println(listNode.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode cur = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }

}
