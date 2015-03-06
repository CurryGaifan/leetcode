package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumGap {
	public int maximumGap(int[] num) {
		if (num.length < 2)
			return 0;

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		for (int x : num)
			list.add(x);

		Integer[] n;
		int j = 1;
		for (int i = 0; i < 10; i++) {
			map.clear();
			n = list.toArray(new Integer[list.size()]);
			list.clear();

			for (Integer x : n) {
				int b = x / j % 10;
				if (map.containsKey(b)) {
					map.get(b).add(x);
				} else {
					List<Integer> subList = new ArrayList<Integer>();
					subList.add(x);
					map.put(b, subList);
				}

			}

			for (Map.Entry<Integer, List<Integer>> en : map.entrySet()) {
//				System.out.println(en.getValue().size());
				list.addAll(en.getValue());
			}

			j = j * 10;
		}

		int max = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			max = Math.max(max, list.get(i + 1) - list.get(i));
		}
		return max;

	}

	public static void main(String[] args) {
		System.out.println(new MaximumGap().maximumGap(new int[] { 6,1,3,10 }));
	}
}
