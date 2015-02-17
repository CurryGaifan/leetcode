package leetcode;

import leetcode.struct.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int pstart, int pend,
			int[] inorder, int instart, int inend) {

		if (pstart == pend) {
			return new TreeNode(preorder[pstart]);
		}

		int root = preorder[pstart];

		int index = findIndex(inorder, root, instart, inend);

		TreeNode tn = new TreeNode(root);

		if (index != instart)
			tn.left = buildTree(preorder, pstart + 1, pstart + index - instart,
					inorder, instart, index - 1);

		if (index != inend)
			tn.right = buildTree(preorder, pstart + 1 + index - instart, pend,
					inorder, index + 1, inend);
		return tn;
	}

	private int findIndex(int[] inorder, int root, int instart, int inend) {
		for (int i = instart; i <= inend; i++) {
			if (inorder[i] == root)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out
				.println(new ConstructBinaryTreefromPreorderandInorderTraversal()
						.buildTree(new int[] { 0, 1, 3, 7, 8, 4, 9, 10, 2, 5,
								11, 12, 6, 13, 14 }, new int[] { 7, 3, 8, 1, 9,
								4, 10, 0, 11, 5, 12, 2, 13, 6, 14 }));
	}
}
