package leetcode;

import java.util.Arrays;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		char[] array = new char[n];
		for (int i = 0; i < n; i++)
			array[i] = (char) ('0' + (i + 1));
		getPermutation(0, array, k);
		return new String(array);
	}

	private int getPermutation(int index, char[] array, int k) {
		char[] copy = Arrays.copyOf(array, array.length);
		if (index == array.length - 1) {
			k--;
//			 System.out.println(new String(array) + ",k:" + k);
			return k;
		}

		for (int i = index; i < array.length; i++) {
			swap(array, index, i);
			k = getPermutation(index + 1, array, k);

			if (k == 0)
				return k;
			// swap(array, index, i);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = copy[i];
		}

		return k;
	}

	private void swap(char[] array, int index, int i) {
		char tmp = array[index];
		array[index] = array[i];
		array[i] = tmp;

	}

	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(8, 8590));
	}
}
