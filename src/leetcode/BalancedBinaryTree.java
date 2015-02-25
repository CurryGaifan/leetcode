package leetcode;

import leetcode.struct.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return -1 != _isBalanced(root);
	}

	public int _isBalanced(TreeNode root) {
		if (root == null)
			return 0;

		int left = _isBalanced(root.left);
		int right = _isBalanced(root.right);


		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) <= 1)

			return Math.max(left, right) + 1;
		else
			return -1;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode("1,2,#,3");
		System.out.println(new BalancedBinaryTree().isBalanced(root));
	}
}
