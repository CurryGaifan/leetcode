package leetcode;

import java.util.HashMap;
import java.util.Map;

import leetcode.struct.RandomListNode;

public class CopyListwithRandomPointer_2 {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		RandomListNode _head = head;
		RandomListNode copy = new RandomListNode(_head.label);
		RandomListNode _copy = copy;
		map.put(head, copy);
		while (_head.next != null) {
			_copy.next = new RandomListNode(_head.next.label);
			map.put(_head.next, _copy.next);
			_head = _head.next;
			_copy = _copy.next;

		}
		_head = head;
		_copy = copy;

		while (_head != null) {
			if (_head.random != null)
				_copy.random = map.get(_head.random);
			_head = _head.next;
			_copy = _copy.next;
		}

		return copy;
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
		System.out
				.println(new CopyListwithRandomPointer_2().copyRandomList(n1));
		System.out.println(n1);
	}
}
