package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.struct.ListNode;

public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		List<Integer> list = new ArrayList<Integer>();
		int length = 0;
		if (lists != null)
			for (ListNode ln : lists) {
				while (ln != null) {
					list.add(ln.val);
					length++;
					ln = ln.next;
				}
			}
		Integer[] array = list.toArray(new Integer[length]);

		quick(array);

		ListNode ln = new ListNode(Integer.MIN_VALUE);
		ListNode ln_ = ln;
		for (int num : array) {
			ListNode node = new ListNode(num);
			ln.next = node;
			ln = ln.next;
		}
		return ln_.next;
	}

	public int getMiddle(Integer[] list, int low, int high) {
		int tmp = list[low];
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high];
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low];
		}
		list[low] = tmp;
		return low;
	}

	public void _quickSort(Integer[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high);
			_quickSort(list, low, middle - 1);
			_quickSort(list, middle + 1, high);
		}
	}

	public void quick(Integer[] a2) {
		if (a2.length > 0) {
			_quickSort(a2, 0, a2.length - 1);
		}
	}

	public static void main(String[] args) {
		new MergekSortedLists().mergeKLists(null);
	}
}
