package leetcode;

import leetcode.struct.ListNode;
import util.PrintUtil;

/**
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode ln = new ListNode(0);
        ListNode _ln = ln;
        ln.next = head;
        while (ln != null && ln.next != null) {
            ListNode cur = ln.next;
            while (cur != null && cur.val == val)
                cur = cur.next;

            ln.next = cur;
            ln = ln.next;
        }
        return _ln.next;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(6);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(3);
        ln3.next = ln4;
        ListNode ln5 = new ListNode(4);
        ln4.next = ln5;
        ListNode ln6 = new ListNode(5);
        ln5.next = ln6;
        ListNode ln7 = new ListNode(6);
        ln6.next = ln7;
        PrintUtil.printListNode(new RemoveLinkedListElements().removeElements(ln6, 6));
    }
}
