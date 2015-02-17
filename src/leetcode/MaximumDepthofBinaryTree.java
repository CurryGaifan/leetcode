package leetcode;

import leetcode.struct.TreeNode;

public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		System.out.println(new MaximumDepthofBinaryTree()
				.maxDepth(new TreeNode("1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,17")));
	}
}
