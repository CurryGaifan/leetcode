package leetcode;

import util.PrintUtil;
import leetcode.struct.ListNode;

/**
 * Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author yanfeixiang
 * 
 */

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode ln = head;
		ListNode first = head;
		if (head != null)
			head = head.next;
		while (head != null) {
			if (head.val == first.val) {
				first.next = head.next;

			} else {
				first = head;
			}
			head = head.next;
		}

		return ln;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		l1.next = l2;
		ListNode l3 = new ListNode(1);
		l2.next = l3;
		ListNode l4 = new ListNode(1);
		l3.next = l4;
		ListNode l5 = new ListNode(1);
		l4.next = l5;

		new RemoveDuplicatesfromSortedList().deleteDuplicates(null);
		PrintUtil.printListNode(l5);
	}
}
