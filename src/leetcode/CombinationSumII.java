package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set
 * is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * @author yanfeixiang
 * 
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		quick(num);
		combinationSum(num, target, 0, resultList, list);
		return resultList;

	}

	private void combinationSum(int[] candidates, int target, int index,
			List<List<Integer>> resultList, List<Integer> list) {
		// System.out.println("target:" + target + ",index:" + index);
		// PrintUtil.printList(list);
		if (target == 0) {
			// System.out.println("zhong");
			// PrintUtil.printList(list);
			resultList.add((List<Integer>) ((ArrayList) list).clone());
			return;
		}
		if (target < 0 || index >= candidates.length)
			return;

		int end = findEnd(candidates, index);

		for (int i = 0; i < end - index + 2 && i * candidates[index] <= target; i++) {
			for (int j = 0; j < i; j++) {
				list.add(candidates[index]);
			}

			combinationSum(candidates, target - i * candidates[index], end + 1,
					resultList, list);
			for (int j = 0; j < i; j++) {
				list.remove(list.size() - 1);
			}
		}

	}

	private int findEnd(int[] candidates, int index) {
		int start = candidates[index];
		int i = index;
		for (; i < candidates.length && candidates[i] == start; i++) {

		}
		return i - 1;
	}

	public int getMiddle(int[] list, int low, int high) {
		int tmp = list[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
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
		// int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		int[] candidates = new int[] { 1, 1, 2, 5, 6, 7, 10 };
		List<List<Integer>> list = new CombinationSumII().combinationSum2(
				candidates, 8);

		for (List<Integer> list1 : list)
			PrintUtil.printList(list1);
	}
}
