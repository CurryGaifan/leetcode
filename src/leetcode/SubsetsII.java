package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * If S = [1,2,2], a solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author yanfeixiang
 * 
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		quick(num);
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();

		List<Integer> list2 = new ArrayList<Integer>();

		subsetsWithDup(list1, list2, num, 0);

		return list1;

	}

	private void subsetsWithDup(List<List<Integer>> list1, List<Integer> list2,
			int[] num, int index) {

		if (index == num.length) {
			list1.add(((List) ((ArrayList) list2).clone()));
			return;
		}

		int n = num[index];
		int length = 0;
		for (int i = index; i < num.length && num[i] == n; i++) {
			length++;
		}
		subsetsWithDup(list1, list2, num, index + length);
		for (int i = 0; i < length; i++) {
			list2.add(n);
			subsetsWithDup(list1, list2, num, index + length);
		}

		for (int i = 0; i < length; i++) {
			list2.remove(list2.size() - 1);
		}

	}

	public int getMiddle(int[] list, int low, int high) {
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

	public void _quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high);
			_quickSort(list, low, middle - 1);
			_quickSort(list, middle + 1, high);
		}
	}

	public void quick(int[] a2) {
		if (a2.length > 0) {
			_quickSort(a2, 0, a2.length - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new SubsetsII().subsetsWithDup(new int[] {
				1, 2, 2 });
		for (List<Integer> l : list) {
			PrintUtil.printList(l);
		}
	}
}
