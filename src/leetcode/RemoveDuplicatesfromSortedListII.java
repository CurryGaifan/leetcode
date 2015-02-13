package leetcode;

import util.PrintUtil;
import leetcode.struct.ListNode;

/**
 * Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.
 * 
 * @author yanfeixiang
 * 
 */

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode ln = new ListNode(-1);
		ln.next = head;
		ListNode first = ln;
		while (head != null && head.next != null) {
			if (head.val == head.next.val) {
			} else if (first.next != head) {
				first.next = head.next;
			} else {
				first = head;

			}
			head = head.next;
		}

		if (first.next != head) {
			first.next = null;
		}

		return ln.next;
	}

	public static void main(String[] args) {
		ListNode l0 = new ListNode(1);

		ListNode l1 = new ListNode(1);
		l0.next = l1;
		ListNode l2 = new ListNode(2);
		 l1.next = l2;
		ListNode l3 = new ListNode(3);
		l2.next = l3;
		ListNode l4 = new ListNode(3);
		l3.next = l4;
		ListNode l5 = new ListNode(4);
		l4.next = l5;
		ListNode l6 = new ListNode(4);
		l5.next = l6;
		ListNode l7 = new ListNode(5);
		l6.next = l7;
		ListNode l8 = new ListNode(5);
		l7.next = l8;
		PrintUtil.printListNode(l0);
		ListNode ln = new RemoveDuplicatesfromSortedListII()
				.deleteDuplicates(l0);
		PrintUtil.printListNode(ln);
	}
}
