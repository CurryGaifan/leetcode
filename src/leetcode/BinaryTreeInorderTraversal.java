package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.PrintUtil;
import leetcode.struct.TreeNode;

/**
 * Given binary tree {1,#,2,3}, return [1,3,2].
 * 
 * @author yanfeixiang
 * 
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		TreeNode tmp = root;

		while (!stack.empty() || tmp != null) {
			while (tmp != null) {
				stack.add(tmp);
				tmp = tmp.left;
			}

			tmp = stack.pop();
			list.add(tmp.val);
			tmp = tmp.right;

		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode tn1 = new TreeNode(2);
		root.right = tn1;

		TreeNode tn2 = new TreeNode(3);
		tn1.left = tn2;

		PrintUtil.printList(new BinaryTreeInorderTraversal()
				.inorderTraversal(root));
	}
}
