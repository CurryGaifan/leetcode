package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * If n = 4 and k = 2, a solution is: [ [2,4], [3,4], [2,3], [1,2], [1,3],
 * [1,4], ]
 * 
 * @author yanfeixiang
 * 
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		_combine(list, new ArrayList<Integer>(), k, 1, n);
		return list;
	}

	public void _combine(List<List<Integer>> list1, List<Integer> list2, int i,
			int index, int n) {
		if (i == 0) {
			list1.add((List) ((ArrayList) list2).clone());
			return;
		}
		for (int j = index; j <= n; j++) {
			list2.add(j);
			_combine(list1, list2, i - 1, j + 1, n);
			list2.remove(list2.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new Combinations().combine(5, 4);
		for (List<Integer> l : list) {
			PrintUtil.printList(l);
		}
	}
}
