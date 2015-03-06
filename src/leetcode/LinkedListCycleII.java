package leetcode;

import leetcode.struct.ListNode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode oneStep = head;
		ListNode secondStep = head;
		int step = 0;
		boolean cycle = false;
		while (oneStep.next != null && secondStep.next != null
				&& secondStep.next.next != null) {
			oneStep = oneStep.next;
			secondStep = secondStep.next.next;
			if (oneStep == secondStep) {
				cycle = true;
				break;
			}
			step++;

		}

		if (!cycle)
			return null;

		int cycleStep = 0;

		while (oneStep.next != null && secondStep.next != null
				&& secondStep.next.next != null) {
			oneStep = oneStep.next;
			secondStep = secondStep.next.next;
			if (oneStep == secondStep)
				break;
			cycleStep++;
		}

		int fistStep = step - cycleStep;
		for (int i = 0; i < fistStep; i++) {
			head = head.next;
		}

		while (true) {
			if (head == oneStep)
				return head;
			else {
				head = head.next;
				oneStep = oneStep.next;
			}
		}

	}
}
