package solutions;

import model.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Solution160 {

    public static void main(String[] args) {


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public ListNode practice(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        int sizeA = 0,sizeB = 0;
        while(p1!=null){
            p1 = p1.next;
            sizeA++;
        }
        while(p2!=null){
            p2 = p2.next;
            sizeB++;
        }
        int numA = 1,numB = 1;
        p1 = headA;
        p2 = headB;
        while(p1!=p2){
            if(p1==null&&numA != sizeA+sizeB){
                p1 = headB;
            }else{
                p1 = p1.next;
            }
            if(p2==null&&numB != sizeB+sizeA){
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }
        return p1;
    }
}
