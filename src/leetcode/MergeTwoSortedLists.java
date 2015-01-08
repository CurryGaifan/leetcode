package leetcode;

import leetcode.struct.ListNode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode allNode = new ListNode(Integer.MIN_VALUE);
		ListNode allNode_ = allNode;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				allNode.next = l1;
				l1 = l1.next;
			} else {
				allNode.next = l2;
				l2 = l2.next;
			}
			allNode = allNode.next;
		}
		if (l1 != null)
			allNode.next = l1;
		else
			allNode.next = l2;
		return allNode_.next;
	}

	public static void main(String[] args) {

		ListNode ln_5 = new ListNode(9);

		ListNode ln_4 = new ListNode(7);
		ln_4.next = ln_5;

		ListNode ln_3 = new ListNode(5);
		ln_3.next = ln_4;

		ListNode ln_2 = new ListNode(3);
		ln_2.next = ln_3;

		ListNode l1 = new ListNode(1);
		l1.next = ln_2;

		
		ListNode ln_2_3 = new ListNode(6);
		ListNode ln_2_2 = new ListNode(4);
		ln_2_2.next = ln_2_3;

		ListNode l2 = new ListNode(2);
		l2.next = ln_2_2;

		ListNode list = new MergeTwoSortedLists().mergeTwoLists(ln_5, null);
		
		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}
}
