package leetcode;

import leetcode.struct.TreeNode;

/**
 * A solution using O(n) space is pretty straight forward. Could you devise a
 * constant space solution?
 * 
 * @author yanfeixiang
 * 
 */
public class RecoverBinarySearchTree {

	int firstDepth = 0;
	int secondDepth = 0;
	TreeNode firstFater;
	TreeNode first;
	TreeNode second;

	public void recoverTree(TreeNode root) {
		depthFirst(root, 0);
		// System.out.println(firstDepth + " " + secondDepth);
		if (second != null) {
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		} else {
			int tmp = first.val;
			first.val = firstFater.val;
			firstFater.val = tmp;
		}

	}

	private void depthFirst(TreeNode root, int depth) {
		if (root == null)
			return;
		if (root.left != null && root.left.val > root.val) {
			if (find(root.left, root, depth + 1))
				return;
		}
		if (root.right != null && root.right.val < root.val) {
			if (find(root.right, root, depth + 1))
				return;
		}

		depthFirst(root.left, depth + 1);
		depthFirst(root.right, depth + 1);

	}

	private boolean find(TreeNode tn, TreeNode f, int depth) {
		if (firstDepth == 0) {
			firstFater = f;
			firstDepth = depth;
			first = tn;
			return false;
		} else {
			secondDepth = depth;
			second = tn;
			return true;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode("10,19,15,3,8,13,18,1,4,6,9,11,14,16,5");
		new RecoverBinarySearchTree().recoverTree(tn);
		System.out.println(tn);
	}
}
