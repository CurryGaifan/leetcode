package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		quick(num);
		int i = 0;
		while (i < num.length) {
			int j = num.length - 1;
			while (j > i + 1) {
				int index = binarySearch(num, -(num[i] + num[j]), i + 1, j - 1);
				if (-1 != index) {
					List<Integer> sublist = new ArrayList<Integer>();
					sublist.add(num[i]);
					sublist.add(num[index]);
					sublist.add(num[j]);
					list.add(sublist);
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

	public int binarySearch(int[] dataset, int data, int beginIndex,
			int endIndex) {
		int midIndex = (beginIndex + endIndex) / 2;
		if (data < dataset[beginIndex] || data > dataset[endIndex]
				|| beginIndex > endIndex) {
			return -1;
		}
		if (data < dataset[midIndex]) {
			return binarySearch(dataset, data, beginIndex, midIndex - 1);
		} else if (data > dataset[midIndex]) {
			return binarySearch(dataset, data, midIndex + 1, endIndex);
		} else {
			return midIndex;
		}
	}

	public static void main(String[] args) {

		List<List<Integer>> lists = new ThreeSum().threeSum(new int[] { -1, 0, 1, 2,
				-1, -4, });
		for (List<Integer> list : lists) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}
}
