package leetcode;

import leetcode.struct.ListNode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode first = head;
		ListNode second = head;
		for (int i = 0; i < n; i++) {
			if (first == null)
				return null;
			first = first.next;
		}

		if (first == null)
			return head.next;
		while (first.next != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return head;
	}

	/**
	 * 1->2->3->4->5, and n = 2. 1->2->3->5
	 */
	public static void main(String[] args) {
		ListNode ln_5 = new ListNode(5);

		ListNode ln_4 = new ListNode(4);
		ln_4.next = ln_5;

		ListNode ln_3 = new ListNode(3);
		ln_3.next = ln_4;

		ListNode ln_2 = new ListNode(2);
		ln_2.next = ln_3;

		ListNode ln_1 = new ListNode(1);
		ln_1.next = ln_2;

		ListNode list = new RemoveNthNodeFromEndofList().removeNthFromEnd(ln_1,
				5);

		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}
}