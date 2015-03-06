package leetcode;

import leetcode.struct.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {

		if (head == null)
			return false;

		ListNode oneStep = head;
		ListNode secondStep = head;

		while (oneStep.next != null && secondStep.next != null
				&& secondStep.next.next != null) {
			oneStep = oneStep.next;
			secondStep = secondStep.next.next;
			if (oneStep == secondStep)
				return true;
		}

		return false;
	}
}
