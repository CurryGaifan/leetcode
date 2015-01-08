package leetcode;

import leetcode.struct.ListNode;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode ln = new ListNode(0);
		ln.next = head;
		ListNode _ln = ln;

		while (ln.next != null && ln.next.next != null) {
			ListNode tmp = ln.next.next.next;
			ListNode first = ln.next;
			ln.next = first.next;
			ln.next.next = first;
			ln.next.next.next = tmp;
			ln = ln.next.next;
		}
		return _ln.next;
	}

	public static void main(String[] args) {
		ListNode ln_5 = new ListNode(9);

		ListNode ln_4 = new ListNode(7);
		ln_4.next = ln_5;

		ListNode ln_3 = new ListNode(5);
		ln_3.next = ln_4;

		ListNode ln_2 = new ListNode(3);
//		ln_2.next = ln_3;

		ListNode l1 = new ListNode(1);
		l1.next = ln_2;

		ListNode list = new SwapNodesinPairs().swapPairs(l1);

		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}
}
