package leetcode;

import util.PrintUtil;
import leetcode.struct.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author yanfeixiang
 * 
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode right = sortList(slow.next);
		slow.next = null;
		return merge(sortList(head), right);

	}

	private ListNode merge(ListNode sortList, ListNode right) {
		ListNode head = new ListNode(0);
		ListNode _head = head;
		while (sortList != null || right != null) {
			if ((sortList != null && right == null)
					|| (sortList != null && right != null && sortList.val < right.val)) {
				_head.next = sortList;
				sortList = sortList.next;
			} else {
				_head.next = right;
				right = right.next;
			}
			_head = _head.next;
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(6);
		ListNode ln2 = new ListNode(1);
		ListNode ln3 = new ListNode(2);
		ListNode ln4 = new ListNode(5);
		ListNode ln5 = new ListNode(4);
		ListNode ln6 = new ListNode(3);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = ln6;
		PrintUtil.printListNode(new SortList().sortList(ln6));
	}
}
