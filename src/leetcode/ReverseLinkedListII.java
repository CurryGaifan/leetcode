package leetcode;

import util.PrintUtil;
import leetcode.struct.ListNode;

/**
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * @author yanfeixiang
 * 
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		ListNode f = new ListNode(0);
		f.next = head;
		ListNode c = f;
		int i = 0;
		for (; i < m - 1; i++) {
			c = c.next;
		}
		ListNode f1 = c;
		c = c.next;

		ListNode d = c;
		ListNode e = d.next;
		ListNode g = e.next;
		for (; i < n - 1; i++) {
			e.next = d;
			d = e;
			e = g;
			if (g == null)
				break;
			g = g == null ? null : g.next;
		}
		f1.next = d;
		c.next = e;

		return f.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		ListNode l3 = new ListNode(3);
		l2.next = l3;
		ListNode l4 = new ListNode(4);
		l3.next = l4;
		ListNode l5 = new ListNode(5);
		l4.next = l5;
		;
		PrintUtil.printListNode(new ReverseLinkedListII().reverseBetween(l1, 2,
				5));

	}
}
