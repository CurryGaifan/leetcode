package leetcode;

import leetcode.struct.TreeNode;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		if (root.right == null && root.left == null)
			return 1;

		return Math.min(root.left != null ? minDepth(root.left)
				: Integer.MAX_VALUE, root.right != null ? minDepth(root.right)
				: Integer.MAX_VALUE) + 1;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumDepthofBinaryTree()
				.minDepth(new TreeNode("1,2,3,3")));
	}
}
