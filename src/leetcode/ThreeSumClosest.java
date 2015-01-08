package leetcode;

/**
 * S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {
		quick(num);
		int closest = Integer.MAX_VALUE;
		int minDif = Integer.MAX_VALUE;
		int i = 0;
		while (i < num.length) {
			int j = num.length - 1;
			while (j > i + 1) {
				int index = binarySearch(num, target - (num[i] + num[j]),
						i + 1, j - 1);

				int dif = Math.abs(num[i] + num[j] + num[index] - target);

				// System.out.println("i: " + i + ",j: " + j + ",index: " +
				// index
				// + ",dif: " + dif);
				if (dif == 0)
					return target;
				if (dif < minDif) {
					closest = num[i] + num[j] + num[index];
					minDif = dif;
				}

				j = findLeft(num, j);

			}
			i = findRight(num, i);
		}

		return closest;
	}

	private int findLeft(int[] num, int i) {
		int right = num[i];
		int j = i - 1;
		for (; j >= 0; j--) {
			if (num[j] != right)
				return j;
		}
		return j;
	}

	private int findRight(int[] num, int i) {
		int left = num[i];
		int j = i + 1;
		for (; j < num.length; j++) {
			if (num[j] != left)
				return j;
		}
		return j;
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

	public void quick(int[] a2) {
		if (a2.length > 0) {
			_quickSort(a2, 0, a2.length - 1);
		}
	}

	public int binarySearch(int[] dataset, int data, int beginIndex,
			int endIndex) {
		int midIndex = (beginIndex + endIndex) / 2;

		if (data < dataset[beginIndex])
			return beginIndex;

		if (data > dataset[endIndex])
			return endIndex;

		if (data == dataset[midIndex])
			return midIndex;

		if (midIndex + 1 < dataset.length && data == dataset[midIndex + 1])
			return midIndex + 1;

		if (midIndex + 1 < dataset.length && dataset[midIndex] < data
				&& data < dataset[midIndex + 1]) {
			if (data - dataset[midIndex] < dataset[midIndex + 1] - data)
				return midIndex;
			else
				return midIndex + 1;

		}

		if (data < dataset[midIndex]) {
			return binarySearch(dataset, data, beginIndex, midIndex - 1);
		} else {
			return binarySearch(dataset, data, midIndex + 1, endIndex);
		}
	}

	public static void main(String[] args) {

		System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { 1, 1, -1, -1,
				3 }, -1));
		// System.out.println(new Q16().binarySearch(new int[] { 1, 3, 5, 7, 9
		// },
		// 6, 3, 4));
	}
}
