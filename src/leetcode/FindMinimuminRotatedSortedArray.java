package leetcode;

/**
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * @author yanfeixiang
 * 
 */
public class FindMinimuminRotatedSortedArray {
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
		if (num[start] < num[middle] && num[middle] > num[end]) {
			return findMin(num, middle, end);
		} else if (num[start] > num[middle] && num[middle] < num[end]) {
			return findMin(num, start, middle);
		} else {
			return num[start];
		}
	}

	public static void main(String[] args) {
		System.out.println(new FindMinimuminRotatedSortedArray()
				.findMin(new int[] { 1, 3, 3 }));
	}
}
