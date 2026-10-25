package byteDance;

import common.ListNode;
import org.junit.Test;

public class I160 {


    @Test
    public void test() {

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);

        ListNode headB = new ListNode(3);
        headB.next = headA.next.next.next;
        System.out.println(getIntersectionNode(headA, headB).val);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode A = headA, B = headB;

        // a+c+b = b+c+a
        // a走完去走b，b走完去走a，两个能遇到的时候就是公共点，遇不上就是无公共点
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }

        return A;
    }
}
