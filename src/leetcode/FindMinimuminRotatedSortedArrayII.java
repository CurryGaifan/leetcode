package leetcode;

public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] num) {
		if (num.length == 0)
			return 0;
		return findMin(num, 0, num.length - 1);
	}

	public int findMin(int[] num, int start, int end) {
		if (start >= end)
			return num[start];
		if (start + 1 == end)
			return Math.min(num[start], num[end]);

		int middle = (start + end) / 2;
		if (num[start] == num[middle] && num[middle] == num[end])
			return Math.min(findMin(num, middle + 1, end),
					findMin(num, start, middle));
		else if (num[start] > num[middle] && num[middle] == num[end])
			return findMin(num, start, middle);
		else if (num[start] == num[middle] && num[middle] > num[end])
			return findMin(num, middle, end);
		else if (num[start] < num[middle] && num[middle] > num[end]) {
			return findMin(num, middle, end);
		} else if (num[start] > num[middle] && num[middle] < num[end]) {
			return findMin(num, start, middle);
		} else {
			return num[start];
		}
	}

	public static void main(String[] args) {
		System.out.println(new FindMinimuminRotatedSortedArrayII()
				.findMin(new int[] { 3, 3, 1 }));
	}
}
