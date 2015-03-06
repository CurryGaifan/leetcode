package leetcode;

/**
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author yanfeixiang
 * 
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] strs1 = version1.split("\\.");
		String[] strs2 = version2.split("\\.");
		int i = 0;
		for (; i < strs1.length && i < strs2.length; i++) {
			int n1 = Integer.parseInt(strs1[i]);
			int n2 = Integer.parseInt(strs2[i]);
			if (n1 > n2)
				return 1;
			else if (n1 < n2)
				return -1;
		}
		if (strs1.length > strs2.length) {
			for (; i < strs1.length; i++) {
				if (Integer.parseInt(strs1[i]) != 0)
					return 1;
			}
			return 0;
		} else if (strs1.length < strs2.length) {
			for (; i < strs2.length; i++) {
				if (Integer.parseInt(strs2[i]) != 0)
					return -1;
			}
			return 0;
		} else
			return 0;
	}
}
