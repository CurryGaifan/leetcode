package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.struct.ListNode;

public class MergekSortedLists_Heap {
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode ln = new ListNode(Integer.MIN_VALUE);
		ListNode ln_ = ln;

		if (lists != null) {
			ListNode[] array = lists.toArray(new ListNode[lists.size()]);

			HeapSort hs = new HeapSort();
			int size = array.length;

			for (int i = size - 1; i >= 0; i--) {
				if (array[i] != null)
					break;
				else
					size--;
			}

			for (int i = 0; i < size; i++) {
				if (array[i] == null) {
					hs.Swap(array, i, size - 1);
					size--;
				}

			}

			hs.MakeMinHeap(array, size);
			while (size != 0) {
//				System.out.println("size: " + size);
//				print(array, size);
				ln.next = array[0];
				hs.MinHeapDeleteNumber(array, size);
				ln = ln.next;
				if (ln.next != null) {
					hs.MinHeapAddNumber(array, size - 1, ln.next);
				} else {
					size--;
				}
			}
		}

		return ln_.next;
	}

	private void print(ListNode[] array, int size) {
		for (int i = 0; i < array.length && i < size; i++)
			System.out.print(array[i].val + " ");

		System.out.println();
	}

	class HeapSort {

		// 新加入i结点 其父结点为(i - 1) / 2
		void MinHeapFixup(ListNode a[], int i) {
			int j;
			ListNode temp;
			temp = a[i];
			j = (i - 1) / 2; // 父结点
			while (j >= 0 && i != 0) {
				if (a[j].val <= temp.val)
					break;

				a[i] = a[j]; // 把较大的子结点往下移动,替换它的子结点
				i = j;
				j = (i - 1) / 2;
			}
			a[i] = temp;
		}

		// 在最小堆中加入新的数据nNum
		void MinHeapAddNumber(ListNode a[], int n, ListNode nNum) {
			a[n] = nNum;
			MinHeapFixup(a, n);
		}

		// 从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
		void MinHeapFixdown(ListNode a[], int i, int n) {
			int j;
			ListNode temp;
			temp = a[i];
			j = 2 * i + 1;
			while (j < n) {
				if (j + 1 < n && a[j + 1].val < a[j].val) // 在左右孩子中找最小的
					j++;

				if (a[j].val >= temp.val)
					break;

				a[i] = a[j]; // 把较小的子结点往上移动,替换它的父结点
				i = j;
				j = 2 * i + 1;
			}
			a[i] = temp;
		}

		// 在最小堆中删除数
		void MinHeapDeleteNumber(ListNode a[], int n) {
			Swap(a, 0, n - 1);
			MinHeapFixdown(a, 0, n - 1);
		}

		private void Swap(ListNode a[], int i, int j) {
			ListNode temp = a[i];
			a[i] = a[j];
			a[j] = temp;

		}

		// 建立最小堆
		void MakeMinHeap(ListNode a[], int n) {
			for (int i = n / 2 - 1; i >= 0; i--)
				MinHeapFixdown(a, i, n);
		}

		void MinheapsortTodescendarray(ListNode a[], int n) {
			for (int i = n - 1; i >= 1; i--) {
				// Swap(a[i], a[0]);
				Swap(a, i, 0);
				MinHeapFixdown(a, 0, i);
			}
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

		ListNode ln_2_3 = new ListNode(6);
		ListNode ln_2_2 = new ListNode(4);
		ln_2_2.next = ln_2_3;

		ListNode l2 = new ListNode(2);
		l2.next = ln_2_2;

		ListNode l3 = new ListNode(100);
		ListNode l4 = new ListNode(-100);

		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(null);
		lists.add(null);
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		lists.add(l4);
		ListNode list = new MergekSortedLists_Heap().mergeKLists(lists);

		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}
}
