package leetcode;

import leetcode.struct.RandomListNode;

public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		RandomListNode _head = head;

		while (_head != null) {
			RandomListNode node = new RandomListNode(_head.label);
			node.next = _head.next;
			_head.next = node;
			_head = node.next;
		}
		_head = head;

		while (_head != null) {
			if (_head.random != null)
				_head.next.random = _head.random.next;
			if (_head.next == null)
				break;
			_head = _head.next.next;
		}
		_head = head;
		RandomListNode result = head.next;
		while (_head.next.next != null) {
			RandomListNode tmp = _head.next.next;
			_head.next.next = _head.next.next.next;
			_head.next = tmp;
			_head = _head.next;
		}
		_head.next = null;
		return result;
	}

	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);

		RandomListNode n2 = new RandomListNode(2);
		n1.next = n2;
		RandomListNode n3 = new RandomListNode(3);
		n2.next = n3;
		RandomListNode n4 = new RandomListNode(4);
		n3.next = n4;
		RandomListNode n5 = new RandomListNode(5);
		n4.next = n5;
		System.out.println(new CopyListwithRandomPointer().copyRandomList(n1));
		System.out.println(n1);
	}
}
