package leetcode;

import leetcode.struct.ListNode;
import leetcode.struct.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);

		ListNode _head = head;
		int i = 1;
		for (; _head.next != null; i++) {

			_head = _head.next;
		}

		return sortedListToBST(head, i);

	}

	private TreeNode sortedListToBST(ListNode start, int n) {

		if (start == null || n == 0)
			return null;
		
		ListNode _start = start;
		int i = 1;
		for (; i < n / 2 + 1; i++) {
			_start = _start.next;
		}

		TreeNode tn = new TreeNode(_start.val);

		tn.left = sortedListToBST(start, i - 1);
		tn.right = sortedListToBST(_start.next, n - i);
		return tn;
	}

	public static void main(String[] args) {

		ListNode ln1 = new ListNode(1);

		ListNode ln2 = new ListNode(2);
		ln1.next = ln2;

		ListNode ln3 = new ListNode(3);
		ln2.next = ln3;

		ListNode ln4 = new ListNode(4);
		ln3.next = ln4;
		
		ListNode ln5 = new ListNode(5);
		ln4.next = ln5;
		ListNode ln6 = new ListNode(6);
		ln5.next = ln6;
		ListNode ln7= new ListNode(7);
		ln6.next = ln7;
		System.out.println(new ConvertSortedListtoBinarySearchTree()
				.sortedListToBST(ln1));

	}
}
