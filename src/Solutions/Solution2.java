package Solutions;

import model.ListNode;
import util.DataUtils;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {

    public static void main(String[] args) {
        ListNode l1 = DataUtils.generateListNode(new int[]{9});
        ListNode l2 = DataUtils.generateListNode(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});


        ListNode listNode = new Solution2().addTwoNumbers(l1, l2);
        DataUtils.printListNode(listNode);

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curr = dummyHead;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val, y = p2 == null ? 0 : p2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;

    }

    long generateNum(ListNode node) {
        ListNode p = node;
        long res = 0;
        long num = 1;
        while (p != null) {
            int val = p.val;
            res += val * num;
            num *= 10;
            p = p.next;
        }
        return res;
    }

    ListNode generateListNode(long num) {
        int head = (int) (num % 10);
        ListNode node = new ListNode(head);
        ListNode p = node;
        num = num / 10;
        while (num > 0) {
            long i = num % 10;
            p.next = new ListNode((int) i);
            p = p.next;
            num /= 10;
        }
        return node;
    }


}
