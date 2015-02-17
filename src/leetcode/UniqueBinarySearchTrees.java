package leetcode;

/**
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * @author yanfeixiang
 * 
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if (n == 0)
			return 0;

		int[] num = new int[n + 1];
		num[0] = 1;
		num[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += num[j] * num[i - j - 1];
			}
			num[i] = sum;
		}
		return num[n];
	}

	public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTrees().numTrees(4));
	}
}
