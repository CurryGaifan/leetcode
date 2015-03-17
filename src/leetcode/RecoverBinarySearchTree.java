package leetcode;

import leetcode.struct.TreeNode;

/**
 * A solution using O(n) space is pretty straight forward. Could you devise a
 * constant space solution?
 * 
 * solve the problem with help.
 * 
 * https://leetcode.com/discuss/13034/no-fancy-algorithm-just-simple-and-
 * powerful-order-traversal
 * 
 * @author yanfeixiang
 * 
 */
public class RecoverBinarySearchTree {

	TreeNode first;
	TreeNode second;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {
		find(root);

		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;

	}

	private void find(TreeNode root) {

		if (root == null)
			return;

		find(root.left);

		if (first == null && prev.val >= root.val) {
			first = prev;
		}

		if (first != null && prev.val >= root.val) {
			second = root;
		}
		prev = root;

		find(root.right);

	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode("10,19,15,3,8,13,18,1,4,6,9,11,14,16,5");
		new RecoverBinarySearchTree().recoverTree(tn);
		System.out.println(tn);
	}
}
