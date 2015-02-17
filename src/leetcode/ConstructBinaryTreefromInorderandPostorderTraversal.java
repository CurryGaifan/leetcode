package leetcode;

import leetcode.struct.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;

		return buildTree(postorder, 0, postorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	public TreeNode buildTree(int[] postorder, int pstart, int pend,
			int[] inorder, int instart, int inend) {
		if (pstart == pend) {
			return new TreeNode(postorder[pstart]);
		}

		int root = postorder[pend];

		int index = findIndex(inorder, root, instart, inend);

		TreeNode tn = new TreeNode(root);

		if (index != instart)
			tn.left = buildTree(postorder, pstart,
					pstart + index - instart - 1, inorder, instart, index - 1);

		if (index != inend)
			tn.right = buildTree(postorder, pstart + index - instart, pend - 1,
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
				.println(new ConstructBinaryTreefromInorderandPostorderTraversal()
						.buildTree(new int[] { 7, 3, 8, 1, 9, 4, 10, 0, 11, 5,
								12, 2, 13, 6, 14 }, new int[] { 7, 8, 3, 9, 10,
								4, 1, 11, 12, 5, 13, 14, 6, 2, 0 }));
	}
}
