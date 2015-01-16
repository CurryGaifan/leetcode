package leetcode;

import util.PrintUtil;

/**
 * 1,2,3 ¡ú 1,3,2 3,2,1 ¡ú 1,2,3 1,1,5 ¡ú 1,5,1
 * 
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		int max = Integer.MIN_VALUE;
		for (int i = num.length - 1; i > 0; i--) {
			max = Math.max(max, num[i]);

			if (num[i - 1] < max) {
				handle(num, i - 1);
				return;
			}

		}

		_quickSort(num, 0, num.length - 1);

	}

	private void handle(int[] num, int j) {
		int index = j + 1;
		for (int i = j + 1; i < num.length; i++) {
			if (num[i] > num[j] && num[i] < num[index]) {
				index = i;
			}

		}

		int tmp = num[j];
		num[j] = num[index];
		num[index] = tmp;
		_quickSort(num, j + 1, num.length - 1);
	}

	public int getMiddle(int[] list, int low, int high) {
		int tmp = list[low];
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

	public void _quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high);
			_quickSort(list, low, middle - 1);
			_quickSort(list, middle + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 1, 5 };

		new NextPermutation().nextPermutation(array);

		PrintUtil.printArray(array);
	}
}
