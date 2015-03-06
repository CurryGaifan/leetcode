package leetcode;

import leetcode.struct.TreeNode;

public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return sumNumbers(root, "");
	}

	public int sumNumbers(TreeNode root, String digit) {
		if (root.left == null && root.right == null)
			return Integer.valueOf(digit + root.val);

		return (root.left == null ? 0 : sumNumbers(root.left, digit + root.val))
				+ (root.right == null ? 0 : sumNumbers(root.right, digit
						+ root.val));

	}

	public static void main(String[] args) {
		System.out.println(new SumRoottoLeafNumbers().sumNumbers(new TreeNode(
				"1,0")));
	}
}
