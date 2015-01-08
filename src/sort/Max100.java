package sort;

public class Max100 {

	public static void main(String[] args) {
		int[] a = { 23, 43523, 657, 9, 3, 456, 95, 32, 456, 43, 46, 21, 75, 4,
				234, 87, 387, 43523, 43523, 657, 9, 3, 456, 95, 32, 456, 43,
				46, 21, 75, 4, 234, 87, 387, 43523, 657, 9, 3, 456, 95, 32,
				456, 43, 46, 21, 75, 4, 234, 87, 387, 43523, 657, 9, 3, 456,
				95, 32, 456, 43, 46, 21, 75, 4, 234, 87, 387, 43523, 657, 9, 3,
				456, 95, 32, 456, 43, 46, 21, 75, 4, 234, 87, 387, 43523, 657,
				9, 3, 456, 95, 32, 456, 43, 46, 21, 75, 4, 234, 87, 387, 43523,
				657, 9, 3, 456, 95, 32, 456, 43, 46, 21, 75, 4, 234, 87, 387,
				43523, 657, 9, 3, 456, 95, 32, 456, 43, 46, 21, 75, 4, 234, 87,
				387, 657, 9, 3, 456, 95, 32, 456, 43, 46, 21, 75, 4, 234, 87,
				387, 43523, 657, 9, 3, 456, 95, 32, 456, 43, 46, 21, 75, 4,
				234, 87, 387, 43523, 657, 9, 3, 456, 95, 32, 456, 43, 46, 21,
				75, 4, 234, 87, 387, 43523, 657, 9, 3, 456, 95, 32, 456, 43,
				234, 87, 387, 43523, 657, 9, 3, 456, 95, 32, 456, 43, 234, 87,
				387, 43523, 657, 9, 3, 456, 95, 32, 456, 43, 234, 87, 387,
				43523, 657, 9, 3, 456, 95, 32, 456, 43, 234, 87, 387, 43523,
				657, 9, 3, 456, 95, 32, 456, 43, 234, 87, 387, 43523, 657, 9,
				3, 456, 95, 32, 456, 43, 234, 87, 387, 43523, 657, 9, 3, 456,
				95, 32, 456, 43, 234, 87, 387, 43523, 657, 9, 3, 456, 95, 32,
				456, 43, 234, 87, 387, 43523, 657, 9, 3, 456, 95, 32, 456, 43,
				234, 87, 387, 43523, 657, 9, 3, 456, 95, 32, 456, 43, 234, 87,
				387, 43523, 657, 9, 3, 456, 95, 32, 456, 43, 234, 87, 387,
				43523, 657, 9, 3, 456, 95, 32, 456, 43, 234, 87, 387, 43523,
				657, 9, 3, 456, 95, 32, 456, 43, 46, 21, 75, 4, 234, 87, 387,
				43523, 657, 9, 3, 456, 95, 32, 456, 43, 46, 21, 75, 4, 234, 87,
				387 };
		int[] result = getMax100(a);

		for (int num : result) {
			System.out.print(num + " ");
		}
	}

	static int[] getMax100(int[] array) {
		int[] max100 = new int[100];
		System.arraycopy(array, 0, max100, 0, 100);
		MakeMinHeap(max100, 100);
		for (int num : max100) {
			System.out.print(num + " ");
		}
		System.out.println();
		for (int i = 100; i < array.length; i++) {
			if (array[i] > max100[0]) {
				max100[0] = array[i];
				MinHeapFixdown(max100, 0, 100);
			}
			for (int num : max100) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

		return max100;

	}

	static void MinHeapFixdown(int a[], int i, int n) {
		int j, temp;

		temp = a[i];
		j = 2 * i + 1;
		while (j < n) {
			if (j + 1 < n && a[j + 1] < a[j]) 
				j++;

			if (a[j] >= temp)
				break;

			a[i] = a[j]; 
			i = j;
			j = 2 * i + 1;
		}
		a[i] = temp;
	}

	static void MakeMinHeap(int a[], int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			MinHeapFixdown(a, i, n);
	}

}
