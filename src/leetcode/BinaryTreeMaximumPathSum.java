package leetcode;

import leetcode.struct.TreeNode;

public class BinaryTreeMaximumPathSum {
	int max;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		max = root.val;
		pathSum(root);
		return max;
	}

	public int pathSum(TreeNode root) {
		if (root == null)
			return 0;

		int left = pathSum(root.left);

		int right = pathSum(root.right);
		max = Math.max(max, root.val + (left < 0 ? 0 : left)
				+ (right < 0 ? 0 : right));

		if (left <= 0 && right <= 0)
			return root.val;

		if (left > right)
			return left + root.val;
		else
			return right + root.val;

	}

	public static void main(String[] args) {
		System.out.println(new BinaryTreeMaximumPathSum()
				.maxPathSum((new TreeNode("-1,-2,3"))));
	}
}
