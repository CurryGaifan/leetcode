package leetcode;

/**
 * 
 * @author yanfeixiang
 * 
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		// System.out.println(s1 + " " + s2);
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;
		if (s1.length() == 1)
			return false;
		char[] s1_c = s1.toCharArray();
		char[] s2_c = s2.toCharArray();
		quick(s1_c);
		quick(s2_c);
		if (!new String(s1_c).equals(new String(s2_c)))
			return false;

		for (int i = 1; i < s2.length(); i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
					&& isScramble(s1.substring(i),
							s2.substring(0, s2.length() - i)))
				return true;
		}
		return false;

	}

	public int getMiddle(char[] list, int low, int high) {
		char tmp = list[low];
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high];
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low];
		}
		list[low] = tmp;
		return low;
	}

	public void _quickSort(char[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high);
			_quickSort(list, low, middle - 1);
			_quickSort(list, middle + 1, high);
		}
	}

	public void quick(char[] a2) {
		if (a2.length > 0) {
			_quickSort(a2, 0, a2.length - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(new ScrambleString().isScramble("ab", "ba"));
	}
}
