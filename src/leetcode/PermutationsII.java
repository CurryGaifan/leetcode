package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * [1,1,2] have the following unique permutations: [1,1,2], [1,2,1], and
 * [2,1,1].
 * 
 * @author yanfeixiang
 * 
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		quick(num);

		List<Integer> list1 = new ArrayList<Integer>();
		List<List<Integer>> list2 = new ArrayList<List<Integer>>();
		List<Integer> subList = new ArrayList<Integer>();
		for (int a : num)
			list1.add(a);
		permute(list1, list2, subList);
		return list2;
	}

	private void permute(List<Integer> list1, List<List<Integer>> list2,
			List<Integer> sublist) {
		if (list1.size() == 0) {

			list2.add((List<Integer>) ((ArrayList<Integer>) sublist).clone());
			return;
		}
		int last = list1.get(0) - 1;

		for (int i = 0; i < list1.size(); i++) {

			int num = list1.remove(0);
			sublist.add(num);
			if (num != last)
				permute(list1, list2, sublist);
			list1.add(num);
			sublist.remove(sublist.size() - 1);
			last = num;
		}

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
			int middle = getMiddle(list, low, high); // 将list数组进行一分为二
			_quickSort(list, low, middle - 1); // 对低字表进行递归排序
			_quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
	}

	public void quick(int[] a2) {
		if (a2.length > 0) { // 查看数组是否为空
			_quickSort(a2, 0, a2.length - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> a = new PermutationsII().permuteUnique(new int[] {
				1, 2, 1 });
		PrintUtil.printListList(a);
	}
}
