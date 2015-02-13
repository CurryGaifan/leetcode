package leetcode;

public class SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		return _search(A, 0, A.length - 1, target);
	}

	public boolean _search(int[] A, int start, int end, int target) {
		if ((end == start && A[start] != target) || start > end)
			return false;

		int middle = (end - start) / 2 + start;
		// System.out.println("start: " + start + ",end:" + end + ",middle:"
		// + middle);
		if (target == A[middle]) {
			return true;
		} else if (A[middle] == A[end] || A[middle] == A[start]) {
			return _search(A, start, middle - 1, target)
					|| _search(A, middle + 1, end, target);
		} else if (target > A[middle]) {
			if (target > A[end] && A[middle] <= A[end])
				return _search(A, start, middle - 1, target);
			else
				return _search(A, middle + 1, end, target);
		} else {
			if (target < A[start] && A[start] <= A[middle])
				return _search(A, middle + 1, end, target);
			else
				return _search(A, start, middle - 1, target);
		}
	}

	public static void main(String[] args) {
		System.out.println(new SearchinRotatedSortedArrayII().search(new int[] {
				1, 3, 3, 1 }, 1));
	}
}
