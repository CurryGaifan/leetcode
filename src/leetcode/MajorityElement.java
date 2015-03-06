package leetcode;

/**
 * The majority element is the element that appears more than n/2 ⌋ times.
 * 
 * @author yanfeixiang
 * 
 */
public class MajorityElement {
	public int majorityElement(int[] num) {
		return majorityElement(num, 0, num.length - 1, (num.length + 1) / 2);
	}

	public int majorityElement(int[] num, int start, int end, int length) {
		if (start == end)
			return num[start];

		if (start + 1 == end) {
			if (length == 1)
				return Math.min(num[start], num[end]);
			else
				return Math.max(num[start], num[end]);
		}

		int tmp = num[start];
		int i = start;
		int j = end;
		while (i < j) {
			while (i < j && num[j] >= tmp) {
				j--;
			}
			num[i] = num[j];
			while (i < j && num[i] <= tmp) {
				i++;
			}
			num[j] = num[i];
		}
		num[i] = tmp;
		if (i == length - 1)
			return tmp;
		else if (i < length - 1) {
			return majorityElement(num, i + 1, end, (length - i - 1));
		} else {
			return majorityElement(num, start, i - 1, length);
		}

	}

	public static void main(String[] args) {
		System.out.println(new MajorityElement().majorityElement(new int[] { 1,
				2, 1, 1 }));
	}
}
