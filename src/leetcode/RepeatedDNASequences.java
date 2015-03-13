package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.PrintUtil;

/**
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * Bit Manipulation
 * 
 * @author yanfeixiang
 * 
 */
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		Set<Integer> set = new HashSet<Integer>();
		Set<String> set_2 = new HashSet<String>();
		int i = 0;
		for (; i + 10 <= s.length(); i++) {
			String tmp = s.substring(i, i + 10);
			if (set.contains(getCode(tmp))) {
				set_2.add(tmp);
			} else {
				set.add(getCode(tmp));
			}
		}
		return new ArrayList<String>(set_2);
	}

	private int getCode(String tmp) {
		int v = 0;
		for (int i = 0; i < 10; i++) {
			int vv = 0;
			if (tmp.charAt(i) == 'A')
				vv = 0;
			else if (tmp.charAt(i) == 'C')
				vv = 1;
			else if (tmp.charAt(i) == 'G')
				vv = 2;
			else
				vv = 3;

			v <<= 2;
			v |= vv;
		}
		return v;
	}

	public static void main(String[] args) {
		PrintUtil.printList(new RepeatedDNASequences()
				.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
