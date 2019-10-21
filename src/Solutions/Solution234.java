package Solutions;

import model.ListNode;
import util.DataUtils;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution234 {
    public static void main(String[] args) {
        ListNode node = DataUtils.generateListNode(new int[]{1, 2, 3, 2, 1});
        System.out.println(new Solution234().isPalindrome(node));
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        int len = 0;
        for (ListNode node = head; node != null; node = node.next) {
            len++;
        }
        ListNode pre = null, cur = head;
        for (int i = 0; i < len / 2; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if ((len & 1) == 1) {
            cur = cur.next;
        }

        for (ListNode p = cur, q = pre; p != null && q != null; p = p.next, q = q.next) {
            if (p.val != q.val) {
                return false;
            }
        }
        return true;
    }

}
