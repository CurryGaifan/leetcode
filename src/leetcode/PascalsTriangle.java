package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> lastList = null;
		for (int i = 0; i < numRows; i++) {
			List<Integer> subList = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i)
					subList.add(1);
				else {
					subList.add(lastList.get(j - 1) + lastList.get(j));
				}

			}
			lastList = subList;
			list.add(subList);
		}
		return list;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new PascalsTriangle().generate(30);
		for (List<Integer> l : list) {
			PrintUtil.printList(l);
		}
	}
}
