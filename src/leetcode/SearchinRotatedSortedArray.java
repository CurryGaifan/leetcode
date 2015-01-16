package leetcode;

public class SearchinRotatedSortedArray {
	public int search(int[] A, int target) {
		return _search(A, 0, A.length - 1, target);
	}

	public int _search(int[] A, int start, int end, int target) {
		if ((end == start && A[start] != target) || start > end)
			return -1;

		int middle = (end - start) / 2 + start;
//		System.out.println("start: " + start + ",end:" + end + ",middle:"
//				+ middle);
		if (target > A[middle]) {
			if (target > A[end] && A[middle] <= A[end])
				return _search(A, start, middle - 1, target);
			else
				return _search(A, middle + 1, end, target);
		} else if (target < A[middle]) {
			if (target < A[start] && A[start] <= A[middle])
				return _search(A, middle + 1, end, target);
			else
				return _search(A, start, middle - 1, target);
		} else {
			return middle;
		}
	}

	public static void main(String[] args) {
		System.out.println(new SearchinRotatedSortedArray().search(new int[] {
				3, 1 }, 3));
	}
}
