package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class ListNode {
		int val;
		int key;
		ListNode next;
		ListNode last;

		public ListNode(int key, int val) {
			this.val = val;
			this.key = key;
		}
	}

	int capacity;
	ListNode start;
	ListNode end;
	Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	private int remove(int key) {
		int value;
		if (map.size() == 1) {
			value = map.remove(key).val;
			start = null;
			end = null;
		} else if (map.get(key) == start) {
			ListNode ln = map.remove(key);
			value = ln.val;
			start = ln.next;
			start.last = null;

		} else if (map.get(key) == end) {
			ListNode ln = map.remove(key);
			value = ln.val;
			end = ln.last;
			end.next = null;
		} else {
			ListNode ln = map.remove(key);
			value = ln.val;
			ln.last.next = ln.next;
			ln.next.last = ln.last;
		}
		return value;
	}

	/**
	 * Get the value (will always be positive) of the key if the key exists in
	 * the cache, otherwise return -1.
	 * 
	 * @param key
	 * @return
	 */
	public int get(int key) {

		// System.out.println(key + " " + map.size());
		if (map.containsKey(key)) {
			int value = remove(key);
			set(key, value);
			return value;
		}

		else
			return -1;
	}

	/**
	 * Set or insert the value if the key is not already present. When the cache
	 * reached its capacity, it should invalidate the least recently used item
	 * before inserting a new item.
	 * 
	 * @param key
	 * @param value
	 */
	public void set(int key, int value) {
		if (map.containsKey(key)) {
			remove(key);

		} else if (map.size() == capacity) {
			remove(start.key);

		}

		if (map.size() == 0) {
			ListNode tn = new ListNode(key, value);
			map.put(key, tn);
			start = tn;
			end = tn;
		} else {
			ListNode tn = new ListNode(key, value);
			map.put(key, tn);
			end.next = tn;
			tn.last = end;
			end = tn;
		}

	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.set(5, 5);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
	}
}
