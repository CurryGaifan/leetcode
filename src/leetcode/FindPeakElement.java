package leetcode;

public class FindPeakElement {
	public int findPeakElement(int[] num) {
		if (num.length == 0)
			return 0;
		return findPeakElement(num, 0, num.length - 1);
	}

	public int findPeakElement(int[] num, int start, int end) {
		if (start == end)
			return start;
		if (start + 1 == end) {
			if (num[start] > num[end])
				return start;
			else
				return end;
		}
		int middle = (end + start) / 2;
		if ((middle == 0 || num[middle] > num[middle - 1])
				&& (middle == end || num[middle] > num[middle + 1])) {
			return middle;
		} else if (middle == end
				|| (middle != 0 && num[middle] < num[middle - 1])) {
			return findPeakElement(num, start, middle);
		} else {
			return findPeakElement(num, middle, end);
		}
	}

	public static void main(String[] args) {
		System.out.println(new FindPeakElement().findPeakElement(new int[] { 1,
				2, 3, 4 }));
	}
}
