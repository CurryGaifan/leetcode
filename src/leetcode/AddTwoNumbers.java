package leetcode;

import leetcode.struct.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode tmp = null;
		int add = 0;
		while (l1 != null || l2 != null || add == 1) {
			int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val)
					+ add;
			add = sum / 10;
			ListNode node = new ListNode(sum % 10);
			if (result == null) {
				result = node;
				tmp = result;
			} else {
				tmp.next = node;
				tmp = node;
			}
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		ListNode l1_1 = new ListNode(9);
		ListNode l1_2 = new ListNode(9);
		l1.next = l1_1;
		l1_1.next = l1_2;

		ListNode l2 = new ListNode(1);
		ListNode l2_1 = new ListNode(0);
		ListNode l2_2 = new ListNode(0);
		l2.next = l2_1;
		l2_1.next = l2_2;

		AddTwoNumbers q2 = new AddTwoNumbers();
		ListNode result = q2.addTwoNumbers(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}


