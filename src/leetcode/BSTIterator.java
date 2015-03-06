package leetcode;

import java.util.Stack;

import leetcode.struct.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * solve this problem with help.
 * 
 * https://oj.leetcode.com/discuss/20001/my-solutions-in-3-languages-with-stack
 * 
 * @author yanfeixiang
 * 
 */
public class BSTIterator {

	Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return stack.size() != 0;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tn = stack.pop();
		int num = tn.val;
		tn = tn.right;
		while (tn != null) {
			stack.push(tn);
			tn = tn.left;
		}

		return num;

	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
