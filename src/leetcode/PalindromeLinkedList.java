package leetcode;

import leetcode.struct.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p/>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode first = head;
        ListNode second = head;

        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }
        ListNode tail = first;
        first = first.next;
        tail.next = null;

        ListNode rHead = reverse(first);

//        PrintUtil.printListNode(head);
//        PrintUtil.printListNode(rHead);

        while (rHead != null) {
            if (head.val != rHead.val)
                return false;
            head = head.next;
            rHead = rHead.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head) {
        if (head.next == null)
            return head;
        else {
            ListNode p = head.next;
            ListNode q = head.next.next;
            head.next = null;
            while (q != null) {
                p.next = head;
                head = p;
                p = q;
                q = q.next;
            }
            p.next = head;
            return p;
        }

    }


    public static void main(String[] args) {
        ListNode tn1 = new ListNode(0);
        ListNode tn2 = new ListNode(0);
        tn1.next = tn2;
        ListNode tn3 = new ListNode(2);
//        tn2.next = tn3;
        ListNode tn4 = new ListNode(1);
        tn3.next = tn4;
        ListNode tn5 = new ListNode(0);
        tn4.next = tn5;

        System.out.println(new PalindromeLinkedList().isPalindrome(tn1));
    }
}
