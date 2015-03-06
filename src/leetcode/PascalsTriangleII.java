package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {

		List<Integer> lastList = null;
		List<Integer> subList = new ArrayList<Integer>();
		if (rowIndex < 0)
			return subList;
		for (int i = 0; i < rowIndex + 1; i++) {
			subList = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i)
					subList.add(1);
				else {
					subList.add(lastList.get(j - 1) + lastList.get(j));
				}

			}
			lastList = subList;
		}
		return subList;
	}

	public static void main(String[] args) {
		List<Integer> list = new PascalsTriangleII().getRow(0);

		PrintUtil.printList(list);

	}
}
