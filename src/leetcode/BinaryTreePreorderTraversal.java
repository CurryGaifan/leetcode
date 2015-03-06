package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.struct.TreeNode;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (stack.size() != 0) {
			TreeNode tn = stack.pop();
			if (tn == null)
				continue;
			list.add(tn.val);
			stack.add(tn.right);
			stack.add(tn.left);
		}
		return list;
	}
}
