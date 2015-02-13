package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(0);
		for (int i = 1; i <= n; i++) {
			int size = list.size();
			for (int j = 0; j < size; j++)
				list.add(list.get(size - j - 1) + (int) Math.pow(2, i - 1));

		}

		return list;
	}

	public static void main(String[] args) {
		PrintUtil.printList(new GrayCode().grayCode(0));
	}
}
