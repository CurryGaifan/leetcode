package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * For example, given candidate set 2,3,6,7 and target 7, A solution set is: [7]
 * [2, 2, 3]
 * 
 * @author yanfeixiang
 * 
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		quick(candidates);
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combinationSum(candidates, target, 0, resultList, list);
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

		for (int i = 0; i * candidates[index] <= target; i++) {
			for (int j = 0; j < i; j++) {
				list.add(candidates[index]);
			}

			combinationSum(candidates, target - i * candidates[index],
					index + 1, resultList, list);
			for (int j = 0; j < i; j++) {
				list.remove(list.size() - 1);
			}
		}

	}

	public int getMiddle(int[] list, int low, int high) {
		int tmp = list[low]; // ����ĵ�һ����Ϊ����
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high]; // ������С�ļ�¼�Ƶ��Ͷ�
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low]; // �������ļ�¼�Ƶ��߶�
		}
		list[low] = tmp; // �����¼��β
		return low; // ���������λ��
	}

	public void _quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // ��list�������һ��Ϊ��
			_quickSort(list, low, middle - 1); // �Ե��ֱ���еݹ�����
			_quickSort(list, middle + 1, high); // �Ը��ֱ���еݹ�����
		}
	}

	public void quick(int[] a2) {
		if (a2.length > 0) { // �鿴�����Ƿ�Ϊ��
			_quickSort(a2, 0, a2.length - 1);
		}
	}

	public static void main(String[] args) {
		int[] candidates = new int[] { 8, 7, 4, 3 };
		List<List<Integer>> list = new CombinationSum().combinationSum(
				candidates, 11);

		for (List<Integer> list1 : list)
			PrintUtil.printList(list1);
	}
}
