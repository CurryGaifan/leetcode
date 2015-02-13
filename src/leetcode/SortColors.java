package leetcode;

import util.PrintUtil;

public class SortColors {
	public void sortColors(int[] A) {
		int l0 = 0;
		int r2 = A.length - 1;

		for (int i = 0; i < A.length && i <= r2; i++) {

			if (A[i] == 2) {
//				System.out.println("a" + i + " " + r2);
				swap(A, i, r2);
				r2--;
				i--;
			} else if (A[i] == 0) {
//				System.out.println("b" + i + " " + l0);
				swap(A, i, l0);
				l0++;
				i = Math.max(l0 - 1, i - 1);
			}

		}

	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 2,0,1 };
		new SortColors().sortColors(A);
		PrintUtil.printArray(A);
	}
}
