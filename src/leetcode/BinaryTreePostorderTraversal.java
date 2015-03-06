package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.PrintUtil;
import leetcode.struct.TreeNode;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> result = new Stack<TreeNode>();
		stack.push(root);
		while (stack.size() != 0) {
			TreeNode tn = stack.pop();
			if (tn == null)
				continue;
			result.add(tn);
			stack.add(tn.left);
			stack.add(tn.right);
		}
		while (result.size() != 0)
			list.add(result.pop().val);

		return list;
	}

	public static void main(String[] args) {
		PrintUtil.printList(new BinaryTreePostorderTraversal()
				.postorderTraversal(new TreeNode("1,#,2,#,3")));
	}
}
