package leetcode;

import leetcode.struct.ListNode;

/**
 * •If the two linked lists have no intersection at all, return null.
 * 
 * •The linked lists must retain their original structure after the function
 * returns.
 * 
 * •You may assume there are no cycles anywhere in the entire linked structure.
 * 
 * •Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author yanfeixiang
 * 
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode _headA = headA;
		ListNode _headB = headB;

		int alength = 0;
		int blength = 0;
		while (_headA.next != null) {
			_headA = _headA.next;
			alength++;
		}

		while (_headB.next != null) {
			_headB = _headB.next;
			blength++;
		}

		if (_headB != _headA)
			return null;

		_headA = headA;
		_headB = headB;
		if (alength > blength) {
			for (int i = 0; i < alength - blength; i++)
				_headA = _headA.next;
		}

		if (alength < blength) {
			for (int i = 0; i < blength - alength; i++)
				_headB = _headB.next;
		}

		while (_headA != null) {
			if (_headA == _headB)
				return _headA;
			_headA = _headA.next;
			_headB = _headB.next;
		}

		return null;
	}

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ListNode ln5 = new ListNode(5);
		ln1.next = ln2;
		ln3.next = ln2;
		ln2.next = ln4;
		ln4.next = ln5;
		System.out.println(new IntersectionofTwoLinkedLists()
				.getIntersectionNode(ln1, ln1).val);
	}
}
