package leetcode;

import util.PrintUtil;
import leetcode.struct.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * 
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * @author yanfeixiang
 * 
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast == slow)
			return;
		// PrintUtil.printListNode(slow.next);
		ListNode right = reverse(slow.next);
		// PrintUtil.printListNode(right);

		slow.next = null;
		ListNode _head = head;
		while (right != null) {
			ListNode h_n = _head.next;
			ListNode r_n = right.next;
			_head.next = right;
			right.next = h_n;
			_head = h_n;
			right = r_n;
		}
		return;
	}

	private ListNode reverse(ListNode node) {
		if (node == null)
			return null;
		ListNode i = node.next;
		node.next = null;
		while (i != null) {
			ListNode j = i.next;
			i.next = node;
			node = i;
			i = j;
		}
		return node;
	}

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ListNode ln5 = new ListNode(5);
		ListNode ln6 = new ListNode(6);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = ln6;

		PrintUtil.printListNode(ln1);
		// PrintUtil.printListNode(new ReorderList().reverse(ln1));
		new ReorderList().reorderList(ln6);
		PrintUtil.printListNode(ln6);
	}
}
