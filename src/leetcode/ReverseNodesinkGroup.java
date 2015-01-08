package leetcode;

import leetcode.struct.ListNode;

public class ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1)
			return head;
		ListNode ln = new ListNode(0);
		ln.next = head;
		ListNode _ln = ln;
		ListNode glast;
		while ((glast = CanRevers(ln, k)) != null) {

			// System.out.println("glast: " + glast.val);
			ListNode ns = glast.next;
			// ln.next.next = ns;
			ListNode tmp = ln.next;
			ln.next = revers(ln.next, k);
			ln = tmp;
			tmp.next = ns;
//			print(_ln.next);
		}
		return _ln.next;
	}

	private ListNode revers(ListNode ln, int k) {
		// System.out.println("in revers :" + k);
		if (k == 1)
			return ln;
		ListNode second = ln.next;

		ListNode nFirst = revers(second, k - 1);

		second.next = ln;

		return nFirst;
	}

	private ListNode CanRevers(ListNode ln, int k) {
		for (int i = 0; i < k; i++) {
			if (ln.next == null)
				return null;
			ln = ln.next;
		}
		return ln;
	}

	private void print(ListNode list) {
		while (list != null) {
			// System.out.println(list.val + " ");
			list = list.next;
		}

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

		ListNode list = new ReverseNodesinkGroup().reverseKGroup(l1, 3);

		System.out.println("revers end.");
		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}
}
