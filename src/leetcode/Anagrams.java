package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.PrintUtil;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			List<Character> list = new ArrayList<Character>();
			for (char ch : c) {
				list.add(ch);
			}
			Collections.sort(list);
			for (int i = 0; i < c.length; i++) {
				c[i] = list.get(i);
			}
			if (map.containsKey(new String(c)))
				map.get(new String(c)).add(str);
			else {
				List<String> strList = new ArrayList<String>();
				strList.add(str);
				map.put(new String(c), strList);
			}

		}

		List<String> result = new ArrayList<String>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getValue().size() != 1)
				for (String str : entry.getValue()) {
					result.add(str);
				}

		}
		return result;
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

		List<String> a = new Anagrams().anagrams(new String[] { "tea", "and",
				"ate", "eat", "dan" });
		PrintUtil.printList(a);
	}
}
