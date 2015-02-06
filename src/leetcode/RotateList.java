package leetcode;

import util.PrintUtil;
import leetcode.struct.ListNode;

/**
 * Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author yanfeixiang
 * 
 */

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (n == 0 || head == null)
			return head;

		ListNode l1 = head;
		ListNode l2 = head;
		int count = 0;
		for (int i = 0; i < n && l1 != null; i++) {
			l1 = l1.next;
			count++;
		}

		if (l1 == null) {

			n = n % count;
			l1 = head;
			for (int i = 0; i < n && l1.next != null; i++) {
				l1 = l1.next;
			}
		}

		while (l1.next != null) {
			l1 = l1.next;
			l2 = l2.next;
		}

		l1.next = head;
		ListNode l3 = l2.next;
		l2.next = null;

		return l3;
	}

	public static void main(String[] args) {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		PrintUtil.printListNode(new RotateList().rotateRight(l1, 5));

	}
}
