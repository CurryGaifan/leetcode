package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

/**
 * [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1],
 * [3,1,2], and [3,2,1].
 * 
 * @author yanfeixiang
 * 
 */
public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<List<Integer>> list2 = new ArrayList<List<Integer>>();
		List<Integer> subList = new ArrayList<Integer>();
		for (int a : num)
			list1.add(a);
		permute(list1, list2, subList);
		return list2;
	}

	public void permute(List<Integer> list1, List<List<Integer>> list2,
			List<Integer> sublist) {
		if (list1.size() == 0)
			list2.add((List<Integer>) ((ArrayList<Integer>) sublist).clone());

		for (int i = 0; i < list1.size(); i++) {
			int num = list1.remove(0);
			sublist.add(num);
			permute(list1, list2, sublist);
			list1.add(num);
			sublist.remove(sublist.size() - 1);
		}

	}

	public static void main(String[] args) {
		List<List<Integer>> a = new Permutations()
				.permute(new int[] { 1, 2, 3 });
		PrintUtil.printListList(a);
	}
}
