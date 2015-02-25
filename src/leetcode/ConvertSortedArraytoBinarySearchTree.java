package leetcode;

import leetcode.struct.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {

		if (num.length == 0)
			return null;
		return sortedArrayToBST(num, 0, num.length - 1);

	}

	public TreeNode sortedArrayToBST(int[] num, int start, int end) {

		if (start == end)
			return new TreeNode(num[start]);

		if (start > end)
			return null;

		int middle = (start + end) / 2;

		TreeNode root = new TreeNode(num[middle]);

		root.left = sortedArrayToBST(num, start, middle - 1);
		root.right = sortedArrayToBST(num, middle + 1, end);
		return root;

	}

	public static void main(String[] args) {
		System.out.println(new ConvertSortedArraytoBinarySearchTree()
				.sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
						11, 12, 13, 14, 15, 16 }));
	}
}
