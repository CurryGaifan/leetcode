package leetcode;

public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = binarySearchIndex(matrix, target);
		if (row == -1)
			return false;
//		System.out.println(row);
		return binarySearch(matrix[row], target) != -1;

	}

	public static int binarySearchIndex(int[][] srcArray, int des) {
		if (des < srcArray[0][0])
			return -1;

		int low = 0;
		int high = srcArray.length - 1;
		while (low <= high) {
			if (low == high) {
				if (des >= srcArray[high][0])
					return high;
				else
					return low - 1;
			}

			if (high - low == 1) {
				if (des >= srcArray[high][0])
					return high;
				else if (des >= srcArray[low][0])
					return low;
				else
					return low - 1;
			}

			int middle = (low + high) / 2;
			if (des == srcArray[middle][0]) {
				return middle;
			} else if (des < srcArray[middle][0]) {
				high = middle - 1;
			} else {
				low = middle;
			}
		}
		return high;
	}

	public static int binarySearch(int[] srcArray, int des) {

		int low = 0;
		int high = srcArray.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (des == srcArray[middle]) {
				return middle;
			} else if (des < srcArray[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Searcha2DMatrix().searchMatrix(new int[][] {
				{ 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } },50));
	}
}
