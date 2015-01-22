package leetcode;

import util.PrintUtil;

/**
 * [0,1,0,2,1,0,1,3,2,1,2,1]. 6
 * 
 * @author yanfeixiang
 * 
 */
public class TrappingRainWater {
	public int trap(int[] A) {
		int[] index_1 = new int[A.length];
		int[] index_2 = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			index_1[i] = i;
			index_2[i] = i;
		}

		quick(A.clone(), index_1, 1);
		int[] B = A.clone();
		quick(B, index_2, 2);

		// PrintUtil.printArray(index_1);
		// PrintUtil.printArray(index_2);
		int j = A.length - 1;
		int sum = 0;
		while (j > -1) {
			// System.out.println("j:" + j);
			int left = findLeft(index_1, j);
			// System.out.println("left:" + left);
			if (left == -1)
				break;
			sum += compute(A, index_1[left], index_1[j]);
			// System.out.println("sum:" + sum);
			j = left;

		}

		for (j = A.length - 1; j > 0 && B[j - 1] == B[j]; j--)
			;

		while (j > -1) {
			// System.out.println("j:" + j);
			int right = findRight(index_2, j);
			// System.out.println("right:" + right);
			if (right == -1)
				break;
			sum += compute(A, index_2[j], index_2[right]);
			// System.out.println("sum:" + sum);
			j = right;

		}
		return sum;
	}

	private int findRight(int[] index, int j) {
		for (int i = j - 1; i > -1; i--) {
			if (index[i] > index[j])
				return i;
		}
		return -1;
	}

	private int findLeft(int[] index, int j) {
		for (int i = j - 1; i > -1; i--) {
			// System.out
			// .println("index[i]:" + index[i] + ",index[j]:" + index[j]);

			if (index[i] < index[j])
				return i;
		}
		return -1;
	}

	private int compute(int[] a, int left, int right) {
		int min = Math.min(a[left], a[right]);
		// System.out.println("min: " + min + ",left:" + left + ",right:" +
		// right);
		// PrintUtil.printArray(a);
		int sum = 0;
		for (int i = left + 1; i < right; i++) {
			sum += (min - a[i]);
		}

		return sum;
	}

	public int getMiddle(int[] list, int[] index, int low, int high, int type) {
		int tmp1 = list[low]; // 数组的第一个作为中轴
		int tmp2 = index[low];
		while (low < high) {
			if (type == 1)
				while (low < high
						&& (list[high] > tmp1 || (list[high] == tmp1 && index[high] > tmp2))) {

					high--;
				}
			else
				while (low < high
						&& (list[high] > tmp1 || (list[high] == tmp1 && index[high] < tmp2))) {

					high--;
				}
			list[low] = list[high]; // 比中轴小的记录移到低端
			index[low] = index[high];
			if (type == 1)
				while (low < high
						&& (list[low] < tmp1 || (list[low] == tmp1 && index[low] < tmp2))) {
					low++;
				}
			else
				while (low < high
						&& (list[low] < tmp1 || (list[low] == tmp1 && index[low] > tmp2))) {
					low++;
				}
			list[high] = list[low]; // 比中轴大的记录移到高端3
			index[high] = index[low];
		}
		list[low] = tmp1; // 中轴记录到尾
		index[low] = tmp2;
		return low; // 返回中轴的位置
	}

	public void _quickSort(int[] list, int[] index, int low, int high, int type) {
		if (low < high) {
			int middle = getMiddle(list, index, low, high, type);
			_quickSort(list, index, low, middle - 1, type);
			_quickSort(list, index, middle + 1, high, type);
		}
	}

	public void quick(int[] a1, int[] a2, int type) {
		if (a1.length > 0) {
			_quickSort(a1, a2, 0, a1.length - 1, type);
		}
	}

	public static void main(String[] args) {
		System.out.println(new TrappingRainWater().trap(new int[] { 2, 0, 2 }));
	}
}
