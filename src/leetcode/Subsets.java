package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * S = [1,2,3]
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author yanfeixiang
 * 
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		quick(S);
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		_combine(list, new ArrayList<Integer>(), S, 0);
		return list;
	}

	public void _combine(List<List<Integer>> list1, List<Integer> list2,
			int[] S, int index) {

		list1.add((List) ((ArrayList) list2).clone());

		for (int j = index; j < S.length; j++) {
			list2.add(S[j]);
			_combine(list1, list2, S, j + 1);
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
		List<List<Integer>> list = new Subsets().subsets(new int[] { 4, 1, 0 });
		for (List<Integer> l : list) {
			PrintUtil.printList(l);
		}
	}
}
