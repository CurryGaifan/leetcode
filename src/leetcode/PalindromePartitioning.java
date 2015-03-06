package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.PrintUtil;

/**
 * For example, given s = "aab", Return [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author yanfeixiang
 * 
 */
public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<List<String>>();

		List<String> subList = new ArrayList<String>();
		partition(list, subList, s);
		return list;
	}

	private void partition(List<List<String>> list, List<String> subList,
			String s) {

		if (s.length() == 0) {
			List<String> copy = (ArrayList) ((ArrayList) subList).clone();
			list.add(copy);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			if (isPalind(s.substring(0, i + 1))) {
				subList.add(s.substring(0, i + 1));
				partition(list, subList, s.substring(i + 1));
				subList.remove(subList.size() - 1);
			}
		}

	}

	private boolean isPalind(String str) {

		int i = 0;
		int j = str.length() - 1;
		char[] ch = str.toCharArray();
		while (i < j) {
			if (ch[i] != ch[j]) {
				return false;
			}

			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		List<List<String>> list = new PalindromePartitioning().partition("aa");
		for (List<String> l : list) {
			PrintUtil.printList(l);
		}
	}
}
