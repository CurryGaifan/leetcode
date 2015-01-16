package leetcode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		if (A.length == 0)
			return 0;
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			while (start < end) {
				if (A[start] == elem)
					break;
				start++;
			}

			while (start < end) {
				if (A[end] != elem)
					break;
				end--;
			}

			if (start != end) {
				int tmp = A[start];
				A[start] = A[end];
				A[end] = tmp;
			}
		}
		if (A[start] == elem)
			return start;
		else
			return start + 1;

	}

	public static void main(String[] args) {
		int[] A = new int[] {};
		int count = new RemoveElement().removeElement(A, 1);
		System.out.println(count);
		for (int i = 0; i < count; i++)
			System.out.print(A[i] + " ");
	}
}
