package leetcode;

import util.PrintUtil;
import leetcode.struct.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode result = new ListNode(0);

		while (head != null) {
			ListNode _result = result;
			boolean insert = false;
			ListNode ln = new ListNode(head.val);
			while (_result.next != null) {
				if (head.val < _result.next.val) {

					insert = true;
					ListNode tmp = _result.next;
					_result.next = ln;
					ln.next = tmp;
					break;
				}
				_result = _result.next;
			}
			if (!insert) {
				_result.next = ln;
			}
			head = head.next;
		}
		return result.next;

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
		PrintUtil.printListNode(new InsertionSortList().insertionSortList(ln1));
	}
}
