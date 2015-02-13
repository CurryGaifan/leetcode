package leetcode;

import util.PrintUtil;
import leetcode.struct.ListNode;

/**
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author yanfeixiang
 * 
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode l = new ListNode(-1);
		ListNode g = new ListNode(-1);
		ListNode _l = l;
		ListNode _g = g;
		while (head != null) {
			if (head.val < x) {
				_l.next = head;
				_l = _l.next;
			} else {
				_g.next = head;
				_g = _g.next;
			}

			head = head.next;
		}
		_g.next = null;
		_l.next = g.next;

		return l.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		l1.next = l2;
		ListNode l3 = new ListNode(3);
		l2.next = l3;
		ListNode l4 = new ListNode(2);
		l3.next = l4;
		ListNode l5 = new ListNode(5);
		l4.next = l5;
		ListNode l6 = new ListNode(2);
		l5.next = l6;
		PrintUtil.printListNode(new PartitionList().partition(l1, 0));
	}
}
