package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * 
 * 
 */
public class FourSum {
	int start = 0;
	int end = 0;

	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		quick(num);
		int i = 0;
		while (i < num.length) {
			int j = num.length - 1;
			while (j > i + 2) {
				start = i + 1;
				end = j - 1;
				while (start < end) {
//					System.out.println("i: " + i + ",j: " + j + ",start: "
//							+ start + ",end: " + end);
					if (search(num, target - (num[i] + num[j]))) {
						List<Integer> sublist = new ArrayList<Integer>();
						sublist.add(num[i]);
						sublist.add(num[start]);
						sublist.add(num[end]);
						sublist.add(num[j]);
						list.add(sublist);
					}
					start = findRight(num, start);
					end = findLeft(num, end);
				}

				j = findLeft(num, j);

			}
			i = findRight(num, i);
		}

		return list;
	}

	private int findLeft(int[] num, int i) {
		int right = num[i];
		int j = i - 1;
		for (; j >= 0; j--) {
			if (num[j] != right)
				return j;
		}
		return j;
	}

	private int findRight(int[] num, int i) {
		int left = num[i];
		int j = i + 1;
		for (; j < num.length; j++) {
			if (num[j] != left)
				return j;
		}
		return j;
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

	public boolean search(int[] dataset, int target) {
		while (start < end) {
			if (dataset[start] + dataset[end] == target)
				return true;
			else if (dataset[start] + dataset[end] < target)
				start++;
			else
				end--;

		}
		return false;

	}

	public static void main(String[] args) {

		List<List<Integer>> lists = new FourSum().fourSum(new int[] { 1, 0, -1,
				0, -2, 2 }, 1);
		for (List<Integer> list : lists) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}
}