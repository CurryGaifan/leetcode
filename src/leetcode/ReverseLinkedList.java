package leetcode;

import leetcode.struct.ListNode;

/**
 *
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode nextNode = head.next;
        head.next = null;
        ListNode result = reverseList(nextNode);
        nextNode.next = head;

        return result;
    }
}
