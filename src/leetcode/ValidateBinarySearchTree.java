package leetcode;

import leetcode.struct.TreeNode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		boolean lb = true;
		if (root.left != null) {
			TreeNode tmp = root.left;
			while (tmp.right != null)
				tmp = tmp.right;
			lb = tmp.val < root.val;
		}

		boolean rl = true;
		if (root.right != null) {
			TreeNode tmp = root.right;
			while (tmp.left != null)
				tmp = tmp.left;
			rl = tmp.val > root.val;
		}

		return (root.left == null ? true : lb)
				&& (root.right == null ? true : rl) && isValidBST(root.left)
				&& isValidBST(root.right);

	}

	public static void main(String[] args) {
		System.out.println(new ValidateBinarySearchTree()
				.isValidBST(new TreeNode("0,#,-1")));

		System.out.println(new TreeNode("0,#,-1"));
	}
}
